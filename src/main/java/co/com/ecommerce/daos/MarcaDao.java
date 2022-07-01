package co.com.ecommerce.daos;

import javax.persistence.EntityManager;
import co.com.ecommerce.entities.Marca;
import co.com.ecommerce.utilities.Conexion;

public class MarcaDao {
	EntityManager entity = Conexion.getEntityManagerFactory().createEntityManager();
	
	public void agregarNuevaMarca(Marca marca) {
		entity.getTransaction().begin();
		entity.persist(marca);
		entity.getTransaction().commit();
	}
	
	public void actualizar(Marca marca) {
		entity.getTransaction().begin();
		entity.merge(marca);
		entity.getTransaction().commit();
		//ConexionDB.disconnect();
	}
	
	public Marca buscarMarca(int idMarca) {
		Marca marca= new Marca();
		marca = entity.find(Marca.class, idMarca);
	
		//ConexionDB.disconnect();
		return marca;
	}
}
