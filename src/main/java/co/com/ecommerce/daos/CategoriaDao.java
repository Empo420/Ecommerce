package co.com.ecommerce.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.com.ecommerce.entities.Categoria;
import co.com.ecommerce.utilities.Conexion;

public class CategoriaDao {

	EntityManager entity = Conexion.getEntityManagerFactory().createEntityManager();
	
	public void agregarNuevaCategoria(Categoria categoria) {
		entity.getTransaction().begin();
		entity.persist(categoria);
		entity.getTransaction().commit();
	}
	
	public void actualizar(Categoria categoria) {
		entity.getTransaction().begin();
		entity.merge(categoria);
		entity.getTransaction().commit();
		//ConexionDB.disconnect();
	}
	
	public Categoria buscarCategoria(int idCategoria) {
		Categoria catego= new Categoria();
		catego = entity.find(Categoria.class, idCategoria);
	
		//ConexionDB.disconnect();
		return catego;
	}
	
	public List<Categoria> listarCategorias(){
		List<Categoria> categorias = new ArrayList<>();
		Query consulta = entity.createQuery("SELECT c FROM Categoria c ");
		categorias = consulta.getResultList();	
		return categorias;
	}
	
}
