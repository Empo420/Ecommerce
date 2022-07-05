package co.com.ecommerce.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.com.ecommerce.entities.Venta;

public interface VentaService {
	public boolean vender(Venta ventas, ArrayList<Integer> idsProductos);
	public boolean venderProductos(int estado, int usuario, Date fecha);
	public List<Venta> listarVentasPagas(int user, Date fecha);
	public List<Venta> listarVentasNoPagas(int user);
	public List<Venta> listarVentas(); 
	public Venta buscarVenta(int idVenta);
	public void CrearVenta(Venta venta);
}
