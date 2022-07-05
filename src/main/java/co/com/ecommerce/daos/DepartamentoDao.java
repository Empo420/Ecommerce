package co.com.ecommerce.daos;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import co.com.ecommerce.entities.Departamento;
import co.com.ecommerce.utilities.Conexion;

public class DepartamentoDao {

	EntityManager entity = Conexion.getEntityManagerFactory().createEntityManager();
	
	public void agregarNuevoDepartamento(Departamento departamento) {
		entity.getTransaction().begin();
		entity.persist(departamento);
		entity.getTransaction().commit();
	}
	
	public void actualizar(Departamento departamento) {
		entity.getTransaction().begin();
		entity.merge(departamento);
		entity.getTransaction().commit();
		//ConexionDB.disconnect();
	}
	
	public Departamento buscarDepartamento(int idDepartamento) {
		Departamento departamento = new Departamento();
		departamento = entity.find(Departamento.class, idDepartamento);
	
		//ConexionDB.disconnect();
		return departamento;
	}
	
	public List<Departamento> listarDepartamentos(){
		List<Departamento> ciudades = new ArrayList<>();
		Query consulta = entity.createQuery("SELECT d FROM Departamento d ");
		ciudades = consulta.getResultList();	
		return ciudades;
	}
}
