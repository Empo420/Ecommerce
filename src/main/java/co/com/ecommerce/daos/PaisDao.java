package co.com.ecommerce.daos;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import co.com.ecommerce.entities.Pais;
import co.com.ecommerce.utilities.Conexion;

public class PaisDao {
	EntityManager entity = Conexion.getEntityManagerFactory().createEntityManager();
	
	public void agregarNuevoPais(Pais pais) {
		entity.getTransaction().begin();
		entity.persist(pais);
		entity.getTransaction().commit();
	}
	
	public void actualizar(Pais pais) {
		entity.getTransaction().begin();
		entity.merge(pais);
		entity.getTransaction().commit();
		//ConexionDB.disconnect();
	}
	
	public Pais buscarPais(int idPais) {
		Pais pais = new Pais();
		pais = entity.find(Pais.class, idPais);
	
		//ConexionDB.disconnect();
		return pais;
	}
	
	public List<Pais> listarPaises(){
		List<Pais> paises = new ArrayList<>();
		Query consulta = entity.createQuery("SELECT p FROM Pais p ");
		paises = consulta.getResultList();	
		return paises;
	}
}
