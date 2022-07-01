package co.com.ecommerce.services;

import java.util.ArrayList;
import java.util.Date;
import co.com.ecommerce.entities.Venta;

public interface VentaService {
	public boolean vender(Venta ventas, ArrayList<Integer> idsProductos);
	public boolean venderProductos(int estado, int usuario, Date fecha);
}
