package co.com.ecommerce.services;

import java.util.List;
import co.com.ecommerce.entities.DetalleVenta;

public interface DetalleVentaService {
	public List<DetalleVenta> listarFacturasNoPagasUsuario(int user);
	public List<DetalleVenta> listarFacturasPagasUsuario(int user); 
	public List<DetalleVenta> listarFacturasNoPagasAdministrador( int admin);
	public List<DetalleVenta> listarFacturasPagasAdministrador(int admin);
}
