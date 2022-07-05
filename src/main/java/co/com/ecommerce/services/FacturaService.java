package co.com.ecommerce.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import co.com.ecommerce.entities.Factura;
import co.com.ecommerce.entities.Venta;

public interface FacturaService {
	public void agregarFactura(Factura factura); 
	public void actualizarFactura(Factura factura);
	public List<Factura> buscarFacturaVenta(int idVenta, String fechaCompra);
	public void validarFactura(Venta venta); 
	public Factura buscarFactura(int idFactura);
	public List<Factura> listarFacturas();
}
