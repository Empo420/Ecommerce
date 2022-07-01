package co.com.ecommerce.daos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import co.com.ecommerce.entities.Factura;
import co.com.ecommerce.entities.Producto;
import co.com.ecommerce.entities.Venta;
import co.com.ecommerce.utilities.Conexion;

public class FacturaDao {
	EntityManager entity = Conexion.getEntityManagerFactory().createEntityManager();

	private ProductoDao productoDao;
	
	public FacturaDao() {
		productoDao = new ProductoDao();
	}
	
	public void agregarFactura(Factura factura) {
		entity.getTransaction().begin();
		entity.persist(factura);
		entity.getTransaction().commit();
	}
	
	public List<Factura> buscarFacturaVenta(int idVenta, Date fechaCompra){
		List<Factura> facturas = new ArrayList<>();
		Query consulta = entity.createQuery("SELECT ft FROM Factura ft WHERE idventa = " + idVenta + " AND fechacompra = " + fechaCompra);
		facturas = consulta.getResultList();	
		
		return facturas;
	}
	
	public void validarFactura(Venta venta) {
		 List<Factura> factura = buscarFacturaVenta(venta.getId(), venta.getFechaventa());
		 Factura facturaEncontrada = null;
		 for(int i = 0; i < factura.size(); i++) {
			 facturaEncontrada = factura.get(i);
			 
			 Producto producto = productoDao.buscarProductoPorId(facturaEncontrada.getProducto().getId());
			 int cantidad = facturaEncontrada.getCantidad();
			 int unidadesVendidas = producto.getUnidadesVendidas();
			 int cantidadUnidades = producto.getCantidadUnidades();

			 cantidadUnidades -= cantidad;
			 unidadesVendidas += cantidad;
			 
			 productoDao.compraDevolucionProducto(cantidadUnidades, unidadesVendidas, producto.getId());
		 }
	}
	
	public ArrayList<Object> listarFacturasNoPagasUsuario(int user) {
		ArrayList<Object> facturas = new ArrayList<>();
		Query consulta = entity.createQuery("SELECT Factura.precio, Factura.cantidad, Factura.total, Producto.nombre, Empresa.nombre, Venta.estadoventa, Factura.fechacompra, Usuario.nombre FROM Factura" +
		"JOIN Venta ON venta.id = Factura.idventa" +
		"JOIN Usuario ON Usuario.identificacion = " + user + 
		"JOIN Producto ON Producto.id = Factura.idproducto" + 
		"JOIN Administrador ON Administrador.identificacion = Producto.idadministrador" + 
		"JOIN Empresa ON  Empresa.nit = Administrador.idempresa" +
		"WHERE Producto.estado = 1 AND Usuario.estado = 1 AND Administrador.estado = 1 AND Empresa.estado = 1 AND Venta.estadoVenta = 1");
		
		facturas =   (ArrayList<Object>) consulta.getResultList();
		
		return facturas;
	}
	
	public ArrayList<Object> listarFacturasPagasUsuario(int user) {
		ArrayList<Object> facturas = new ArrayList<>();
		Query consulta = entity.createQuery("SELECT Factura.precio, Factura.cantidad, Factura.total, Producto.nombre, Empresa.nombre, Venta.estadoventa, Factura.fechacompra, Usuario.nombre FROM Factura" +
		"JOIN Venta ON venta.id = Factura.idventa" +
		"JOIN Usuario ON Usuario.identificacion = " + user + 
		"JOIN Producto ON Producto.id = Factura.idproducto" + 
		"JOIN Administrador ON Administrador.identificacion = Producto.idadministrador" + 
		"JOIN Empresa ON  Empresa.nit = Administrador.idempresa" +
		"WHERE Producto.estado = 1 AND Usuario.estado = 1 AND Administrador.estado = 1 AND Empresa.estado = 1 AND Venta.estadoVenta = 2");
		
		facturas = (ArrayList<Object>) consulta.getResultList();
		
		return facturas;
	}
	
	public ArrayList<Object> listarFacturasNoPagasAdministrador( int admin) {
		ArrayList<Object> facturas = new ArrayList<>();
		Query consulta = entity.createQuery("SELECT Factura.precio, Factura.cantidad, Factura.total, Producto.nombre, Empresa.nombre, Venta.estadoventa, Factura.fechacompra, Usuario.nombre FROM Factura" +
		"JOIN Venta ON venta.id = Factura.idventa" +
		"JOIN Usuario ON Usuario.identificacion = Venta.idusuario"  + 
		"JOIN Producto ON Producto.id = Factura.idproducto" + 
		"JOIN Administrador ON Administrador.identificacion = " + admin + 
		"JOIN Empresa ON  Empresa.nit = Administrador.idempresa" +
		"WHERE Producto.estado = 1 AND Usuario.estado = 1 AND Administrador.estado = 1 AND Empresa.estado = 1 AND Venta.estadoVenta = 1");
		
		facturas =  (ArrayList<Object>) consulta.getResultList();
		
		return facturas;
	}
	
	public ArrayList<Object> listarFacturasPagasAdministrador(int admin) {
		ArrayList<Object> facturas = new ArrayList<>();
		Query consulta = entity.createQuery("SELECT Factura.precio, Factura.cantidad, Factura.total, Producto.nombre, Empresa.nombre, Venta.estadoventa, Factura.fechacompra, Usuario.nombre FROM Factura" +
		"JOIN Venta ON venta.id = Factura.idventa" +
		"JOIN Usuario ON Usuario.identificacion = Venta.idusuario"  + 
		"JOIN Producto ON Producto.id = Factura.idproducto" + 
		"JOIN Administrador ON Administrador.identificacion = " + admin + 
		"JOIN Empresa ON  Empresa.nit = Administrador.idempresa" +
		"WHERE Producto.estado = 1 AND Usuario.estado = 1 AND Administrador.estado = 1 AND Empresa.estado = 1 AND Venta.estadoVenta = 2");
		
		facturas =  (ArrayList<Object>) consulta.getResultList();
		
		return facturas;
	}
}
