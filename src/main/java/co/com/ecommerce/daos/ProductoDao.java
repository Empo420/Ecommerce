package co.com.ecommerce.daos;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.com.ecommerce.entities.Administrador;
import co.com.ecommerce.entities.Categoria;
import co.com.ecommerce.entities.Marca;
import co.com.ecommerce.entities.Producto;
import co.com.ecommerce.utilities.Conexion;

public class ProductoDao {

	EntityManager entity = Conexion.getEntityManagerFactory().createEntityManager();
	
	public void agregarProducto(Producto producto) {
		entity.getTransaction().begin();
		entity.persist(producto);
		entity.getTransaction().commit();
	}
	
	
	public List<Producto> obtenerProductos() {
		List<Producto> listaProductos = new ArrayList<>();
		Query consulta = entity.createQuery("SELECT pr FROM Producto pr WHERE pr.estado = 1");
		listaProductos = consulta.getResultList();		
		return listaProductos;
	}
	
	public List<Producto> obtenerProductosPorCategoria(int categoria) {
		List<Producto> listaProductos = new ArrayList<>();
		Query consulta = entity.createQuery("SELECT pr FROM Producto pr WHERE idcategoria =" + categoria + " AND estado = 1");
		listaProductos = consulta.getResultList();		
		return listaProductos;
	}
	
	public List<Producto> obtenerProductosPorCategoriaAdministrador(int categoria, int admin) {
		List<Producto> listaProductos = new ArrayList<>();
		Query consulta = entity.createQuery("SELECT pr FROM Producto pr WHERE idcategoria =" + categoria + " AND idadministrador = " + admin + " AND estado = 1");
		listaProductos = consulta.getResultList();		
		return listaProductos;
	}
	
	public List<Producto> obtenerProductosPorMarca(int marca) {
		List<Producto> listaProductos = new ArrayList<>();
		Query consulta = entity.createQuery("SELECT pr FROM Producto pr WHERE idmarca =" + marca + " AND estado = 1");
		listaProductos = consulta.getResultList();		
		return listaProductos;
	}
	
	public List<Producto> obtenerProductosPorMarcaAdministrador(int marca, int admin) {
		List<Producto> listaProductos = new ArrayList<>();
		Query consulta = entity.createQuery("SELECT pr FROM Producto pr WHERE idmarca =" + marca + " AND idadministrador = " + admin + " AND estado = 1");
		listaProductos = consulta.getResultList();		
		return listaProductos;
	}
	
	public Producto buscarProductoPorId(Integer id) {
		Producto producto= new Producto();
		producto = entity.find(Producto.class, id);
		if(producto.getEstado() != 0) {
			return producto;
		}
		//ConexionDB.disconnect();
		return null;
	}
	
	public List<Producto> buscarProductoPorNombre(String nombre) {
		List<Producto> listaProductos = new ArrayList<>();
		Query consulta = entity.createQuery("SELECT pr FROM Producto pr WHERE nombre ='" + nombre + "' AND estado = 1");
		listaProductos = consulta.getResultList();		
		return listaProductos;
	}
	
	public List<Producto> buscarProductoAdministrador(String nombre, int admin) {
		List<Producto> listaProductos = new ArrayList<>();
		Query consulta = entity.createQuery("SELECT pr FROM Producto pr WHERE nombre ='" + nombre + "' AND idadministrador ="+ admin + " AND estado = 1");
		listaProductos = consulta.getResultList();		
		return listaProductos;
	}
	
	public void compraDevolucionProducto(Integer cantidadUnidades, Integer unidadesVendidas, Integer idProducto) {
		
		Producto producto = new Producto();
		entity.getTransaction().begin();
		producto = entity.find(Producto.class, idProducto);
		//ConexionDB.disconnect();
		if(producto.getEstado() != 0) {
			producto.setCantidadUnidades(cantidadUnidades);
			producto.setUnidadesVendidas(unidadesVendidas);	
			entity.merge(producto);
			entity.getTransaction().commit();
		}
		//ConexionDB.disconnect();
	}
	
	public void actualizarProducto(Producto produc) {
		entity.getTransaction().begin();
		entity.merge(produc);
		entity.getTransaction().commit();
		//ConexionDB.disconnect();
	}
	
	public List<Producto> misProductosAdministrador(int admin){
		List<Producto> listaProductos = new ArrayList<>();
		Query consulta = entity.createQuery("SELECT pr FROM Producto pr WHERE pr.idAdministrador = " + admin + "AND pr.estado = 1");
		listaProductos = consulta.getResultList();		
		return listaProductos;
	}
	
	public void eliminarProducto(int idProducto, Administrador idAdministrador) {
		Producto producto = new Producto();
		entity.getTransaction().begin();
		producto = entity.find(Producto.class, idProducto);
		
		if(producto.getEstado() != 0 && producto.getIdAdministrador() == idAdministrador) {
			producto.setEstado(0);
			entity.merge(producto);
			entity.getTransaction().commit();
		}
	}
	
	public boolean abastecer(int cantidad, int idProducto) {
		boolean abastecio = false;
		int cantidadVendida = 0;
		Producto producto = new Producto();
		entity.getTransaction().begin();
		producto = entity.find(Producto.class, idProducto);
		
		if(producto.getCantidadUnidades() < producto.getCantidadMinima()) {
			if(cantidad > producto.getCantidadUnidades()) {
				cantidadVendida = producto.getCantidadUnidades();
				producto.setCantidadUnidades(0);
			}
			else {
				int unidades = producto.getCantidadUnidades();
				unidades -= cantidad;
				producto.setCantidadUnidades(unidades);
				cantidadVendida = cantidad;
			}
			
			int cantidadUnidades = producto.getUnidadesVendidas();
			cantidadUnidades += cantidadVendida;
			producto.setUnidadesVendidas(cantidadUnidades);
			entity.merge(producto);
			entity.getTransaction().commit();
			abastecio = true;
		}
		
		return abastecio;
	}
	
	public int cantidadDeProducto(int admin) {
		List<Producto> listaProductos = new ArrayList<>();
		Query consulta = entity.createQuery("SELECT pr FROM Producto pr WHERE pr.idAdministrador = " + admin + "AND pr.estado = 1");
		listaProductos = consulta.getResultList();		
		return listaProductos.size();
	}
	
	public void descuentoCategoria(int categoria, int admin, double descuento) {
		Query consulta = entity.createQuery("UPDATE Producto SET descuento = " + descuento + "WHERE estado = 1" + "AND idadministrador = " + admin + "AND idcategoria = " + categoria);
	}
	
	public void descuentoMarca(int marca, int admin, double descuento) {
		Query consulta = entity.createQuery("UPDATE Producto SET descuento = " + descuento + "WHERE estado = 1" + "AND idadministrador = " + admin + "AND idmarca = " + marca);
	}
}
