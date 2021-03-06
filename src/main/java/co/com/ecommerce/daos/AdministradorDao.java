package co.com.ecommerce.daos;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import co.com.ecommerce.entities.Administrador;
import co.com.ecommerce.entities.Empresa;
import co.com.ecommerce.utilities.Conexion;
import co.com.ecommerce.utilities.Md5Encript;



public class AdministradorDao {
	EntityManager entity = Conexion.getEntityManagerFactory().createEntityManager();
	private Md5Encript md5;
	
	public AdministradorDao() {
		md5 = new Md5Encript();
	}
	
	public void registrarAdministrador(Administrador admin) {
		String pass = admin.getContrasenia();
		String ecriptacion = md5.decode(pass);

		admin.setContrasenia(ecriptacion);
		entity.getTransaction().begin();
		entity.persist(admin);
		entity.getTransaction().commit();
		//ConexionDB.disconnect();
	}
	
	public void actualizar(Administrador admin) {
		if(admin.getEstado() != 0) {
			entity.getTransaction().begin();
			entity.merge(admin);
			entity.getTransaction().commit();
		}
		//ConexionDB.disconnect();
	}
	
	public Administrador buscar(int admin) {
		Administrador administrador= new Administrador();
		administrador = entity.find(Administrador.class, admin);
		if(administrador.getEstado() != 0) {
			String pass = administrador.getContrasenia();
			String desencriptacion = md5.decript(pass);
			administrador.setContrasenia(desencriptacion);
			return administrador;
		}
		//ConexionDB.disconnect();
		return null;
	}
	
	public Administrador buscarInicio(int admin, String pass) {
		Administrador administrador= new Administrador();
		administrador = entity.find(Administrador.class, admin);
		if(administrador.getEstado() != 0 && administrador.getContrasenia().equals(pass)) {
			return administrador;
		}
		//ConexionDB.disconnect();
		return null;
	}
	
	public void eliminar(int admin) {
		Administrador administrador= new Administrador();
		entity.getTransaction().begin();
		administrador = entity.find(Administrador.class, admin);
		
		if(administrador.getEstado() != 0) {
			administrador.setEstado(0);
			entity.merge(administrador);
			entity.getTransaction().commit();
		}
		//ConexionDB.disconnect();
	}
	
	public List<Administrador> buscarAdministradorEmpresa(int empresa) {
		List<Administrador> administradores = new ArrayList<>();
		
		Query consulta = entity.createQuery("SELECT ad FROM Administrador ad WHERE idempresa =" + empresa + " AND estado = 1");
		administradores = consulta.getResultList();	
		
		return administradores;
	}
	
}
