package co.com.ecommerce.serviceImpl;

import java.util.List;

import co.com.ecommerce.daos.DetalleVentaDao;
import co.com.ecommerce.entities.DetalleVenta;
import co.com.ecommerce.services.DetalleVentaService;

public class DetellaVentaServiceImpl implements DetalleVentaService{

	private DetalleVentaDao detalleVentaDao;
	
	public DetellaVentaServiceImpl() {
		detalleVentaDao = new DetalleVentaDao();
	}
	
	@Override
	public List<DetalleVenta> listarFacturasNoPagasUsuario(int user) {
		List<DetalleVenta> detalle = detalleVentaDao.listarFacturasNoPagasUsuario(user);
		return detalle;
	}

	@Override
	public List<DetalleVenta> listarFacturasPagasUsuario(int user) {
		List<DetalleVenta> detalle = detalleVentaDao.listarFacturasPagasUsuario(user);
		return detalle;
	}

	@Override
	public List<DetalleVenta> listarFacturasNoPagasAdministrador(int admin) {
		List<DetalleVenta> detalle = detalleVentaDao.listarFacturasNoPagasAdministrador(admin);
		return detalle;
	}

	@Override
	public List<DetalleVenta> listarFacturasPagasAdministrador(int admin) {
		List<DetalleVenta> detalle = detalleVentaDao.listarFacturasPagasAdministrador(admin);
		return detalle;
	}

}
