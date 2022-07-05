package co.com.ecommerce.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.com.ecommerce.entities.Categoria;
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
	
	public List<Marca> listarMarcas(){
		List<Marca> marcas = new ArrayList<>();
		Query consulta = entity.createQuery("SELECT m FROM Marca m ");
		marcas = consulta.getResultList();	
		return marcas;
	}
}
