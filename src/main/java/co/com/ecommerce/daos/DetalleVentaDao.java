package co.com.ecommerce.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.com.ecommerce.entities.DetalleVenta;
import co.com.ecommerce.utilities.Conexion;

public class DetalleVentaDao {
	EntityManager entity = Conexion.getEntityManagerFactory().createEntityManager();

	public List<DetalleVenta> listarFacturasNoPagasUsuario(int user) {
		List<DetalleVenta> detalle = new ArrayList<>();
		Query consulta = entity.createQuery("SELECT dv FROM DetalleVenta dv WHERE idusuario = " + user + "AND estadoventa = 1");
		detalle =  consulta.getResultList();
		return detalle;
	}
	
	public List<DetalleVenta> listarFacturasPagasUsuario(int user) {
		List<DetalleVenta> detalle = new ArrayList<>();
		Query consulta = entity.createQuery("SELECT dv FROM DetalleVenta dv WHERE idUsuario = " + user + "AND estadoVenta = 2");
		detalle =  consulta.getResultList();
		return detalle;
	}
	
	public List<DetalleVenta> listarFacturasNoPagasAdministrador( int admin) {
		List<DetalleVenta> detalle = new ArrayList<>();
		Query consulta = entity.createQuery("SELECT dv FROM DetalleVenta dv WHERE idAdminitrador = " + admin + "AND estadoVenta = 1");
		detalle =  consulta.getResultList();
		return detalle;
	}
	
	public List<DetalleVenta> listarFacturasPagasAdministrador(int admin) {
		List<DetalleVenta> detalle = new ArrayList<>();
		Query consulta = entity.createQuery("SELECT dv FROM DetalleVenta dv WHERE idAdminitrador = " + admin + "AND estadoVenta = 2");
		detalle =  consulta.getResultList();
		return detalle;
	}
}
