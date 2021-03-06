package co.com.ecommerce.daos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import co.com.ecommerce.entities.Factura;
import co.com.ecommerce.entities.Producto;
import co.com.ecommerce.entities.Usuario;
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
	
	public void actualizarFactura(Factura factura) {
		entity.getTransaction().begin();
		entity.merge(factura);
		entity.getTransaction().commit();
	}
	
	public List<Factura> buscarFacturaVenta(int idVenta, String fechaCompra){
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
	
	public Factura buscarFactura(int idFactura) {
		Factura factura = new Factura();
		factura = entity.find(Factura.class, idFactura);
	
		//ConexionDB.disconnect();
		return factura;
	}
	
	public List<Factura> listarFacturas(){
		List<Factura> facturas = new ArrayList<>();
		Query consulta = entity.createQuery("SELECT ft FROM Factura ft");
		facturas = consulta.getResultList();		
		return facturas;
	}
	
}
