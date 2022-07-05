package co.com.ecommerce.daos;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import co.com.ecommerce.entities.Ciudad;
import co.com.ecommerce.utilities.Conexion;

public class CiudadDao {
	EntityManager entity = Conexion.getEntityManagerFactory().createEntityManager();
	
	public void agregarNuevaCiudad(Ciudad ciudad) {
		entity.getTransaction().begin();
		entity.persist(ciudad);
		entity.getTransaction().commit();
	}
	
	public void actualizar(Ciudad ciudad) {
		entity.getTransaction().begin();
		entity.merge(ciudad);
		entity.getTransaction().commit();
		//ConexionDB.disconnect();
	}
	
	public Ciudad buscarCiudad(int idCiudad) {
		Ciudad ciudad= new Ciudad();
		ciudad = entity.find(Ciudad.class, idCiudad);
	
		//ConexionDB.disconnect();
		return ciudad;
	}
	
	public List<Ciudad> listarCiudades(){
		List<Ciudad> ciudades = new ArrayList<>();
		Query consulta = entity.createQuery("SELECT c FROM Ciudad c ");
		ciudades = consulta.getResultList();	
		return ciudades;
	}
}
