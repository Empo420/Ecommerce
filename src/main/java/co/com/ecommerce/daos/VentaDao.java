package co.com.ecommerce.daos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.com.ecommerce.entities.Pais;
import co.com.ecommerce.entities.Usuario;
import co.com.ecommerce.entities.Venta;
import co.com.ecommerce.utilities.Conexion;

public class VentaDao {
	EntityManager entity = Conexion.getEntityManagerFactory().createEntityManager();

	public void crearVenta(Venta venta) {
		entity.getTransaction().begin();
		entity.persist(venta);
		entity.getTransaction().commit();
	}
	
	public List<Venta> buscarVentaNoPagas(int user) {
		List<Venta> listaVentass = new ArrayList<>();
		Query consulta = entity.createQuery("SELECT vt FROM Venta vt WHERE idUsuario = " + user + " AND estadoVenta = 1");
		listaVentass = consulta.getResultList();		
		return listaVentass;
	}
	
	public List<Venta> buscarVentaPagas(int user, Date fecha ) {
		List<Venta> listaVentass = new ArrayList<>();
		Query consulta = entity.createQuery("SELECT vt FROM Venta vt WHERE idusuario = " + user + "AND fechaventa = " + fecha + " AND estadoventa = 2");
		listaVentass = consulta.getResultList();		
		return listaVentass;
	}
	
	public List<Venta> listarVentas() {
		List<Venta> listaVentass = new ArrayList<>();
		Query consulta = entity.createQuery("SELECT vt FROM Venta vt");
		listaVentass = consulta.getResultList();		
		return listaVentass;
	}
	
	public void actualizarEstadoVenta(int estado,  Venta venta) {
		entity.getTransaction().begin();
		venta.setEstadoventa(estado);
		if(venta.getEstadoventa() != 0 && venta.getEstadoventa() != 1) {
			entity.merge(venta);
			entity.getTransaction().commit();
		}
		//ConexionDB.disconnect();
	}
	
	
	public void eliminarVenta ( Venta venta) {
		entity.getTransaction().begin();
		venta.setEstadoventa(0);
		if(venta.getEstadoventa() == 0) {
			entity.merge(venta);
			entity.getTransaction().commit();
		}
		//ConexionDB.disconnect();
	}
	
	public void actualizarVenta(Venta venta) {
		entity.getTransaction().begin();
		if(venta.getEstadoventa() != 0) {
			entity.merge(venta);
			entity.getTransaction().commit();
		}
	}
	
	public Venta buscarVenta(int idVenta) {
		Venta venta = new Venta();
		venta = entity.find(Venta.class, idVenta);
		if(venta.getEstadoventa() != 0) {
			return venta;
		}
		//ConexionDB.disconnect();
		return null;
	}
}
