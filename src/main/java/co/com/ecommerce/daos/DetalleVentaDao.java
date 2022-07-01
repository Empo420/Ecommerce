package co.com.ecommerce.daos;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import co.com.ecommerce.utilities.Conexion;

public class DetalleVentaDao {
	EntityManager entity = Conexion.getEntityManagerFactory().createEntityManager();

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
