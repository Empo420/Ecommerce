package co.com.ecommerce.serviceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import co.com.ecommerce.daos.FacturaDao;
import co.com.ecommerce.daos.ProductoDao;
import co.com.ecommerce.daos.VentaDao;
import co.com.ecommerce.entities.Factura;
import co.com.ecommerce.entities.Producto;
import co.com.ecommerce.entities.Venta;
import co.com.ecommerce.services.VentaService;

public class VentaServiceImpl implements VentaService{

	private VentaDao ventaDao;
	private ProductoDao productoDao;
	private FacturaDao facturaDao;
	
	public VentaServiceImpl() {
		ventaDao = new VentaDao();
		productoDao = new ProductoDao();
		facturaDao = new FacturaDao();
	}
	
	@Override
	public boolean vender(Venta ventas, ArrayList<Integer> idsProductos) {
		boolean vendio = false;
		ventaDao.crearVenta(ventas);
		ArrayList<Integer> productos = idsProductos;
		Collections.sort(productos);
		
		List<Venta> venta = ventaDao.buscarVentaNoPagas(ventas.getUsuario().getIdentificacion(), ventas.getFechaventa());
		
		for(int i = 0; i < venta.size(); i++) {
			Venta ventaEncontrada =  venta.get(i);
			
			Set<Integer> miSet = new HashSet<Integer>(productos);
			for (int id : miSet) {
				int repeticiones = Collections.frequency(productos, id);
				Producto producto = productoDao.buscarProductoPorId(id);
			
				double precio = producto.getValor();
				double iva = producto.getIva();
				double descuento = producto.getDescuento();
				
				double total = (precio + precio * iva) * descuento;
				Factura factura = new Factura( producto, ventaEncontrada, precio, repeticiones, ventas.getFechaventa(), total);
				facturaDao.agregarFactura(factura);
				vendio = true;
			}
		}
		return vendio;
	}

	@Override
	public boolean venderProductos(int estado, int usuario, Date fecha) {
		boolean compro = false;
		List<Venta> venta = ventaDao.buscarVentaNoPagas(usuario, fecha);
		for(int i = 0; i < venta.size(); i++) {
			Venta ventaEncontrada = venta.get(i);
			
			ventaDao.actualizarEstadoVenta(estado, ventaEncontrada);
			facturaDao.validarFactura(ventaEncontrada);
			compro = true;
		}
		return compro;
	}


}
