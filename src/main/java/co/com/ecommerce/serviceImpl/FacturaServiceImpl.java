package co.com.ecommerce.serviceImpl;

import java.util.List;

import co.com.ecommerce.daos.FacturaDao;
import co.com.ecommerce.entities.Factura;
import co.com.ecommerce.entities.Venta;
import co.com.ecommerce.services.FacturaService;

public class FacturaServiceImpl implements FacturaService{
	private FacturaDao facturaDao;

	public FacturaServiceImpl() {
		facturaDao = new FacturaDao();
	}

	@Override
	public void agregarFactura(Factura factura) {
		facturaDao.agregarFactura(factura);	
	}

	@Override
	public void actualizarFactura(Factura factura) {
		facturaDao.actualizarFactura(factura);
	}

	@Override
	public List<Factura> buscarFacturaVenta(int idVenta, String fechaCompra) {
		List<Factura> factura = facturaDao.buscarFacturaVenta(idVenta, fechaCompra);
		return factura;
	}

	@Override
	public void validarFactura(Venta venta) {
		facturaDao.validarFactura(venta);
	}

	@Override
	public Factura buscarFactura(int idFactura) {
		Factura factura = facturaDao.buscarFactura(idFactura);
		return factura;
	}

	@Override
	public List<Factura> listarFacturas() {
		List<Factura> facturas = facturaDao.listarFacturas();
		return facturas;
	}
	
	
	
	
}
