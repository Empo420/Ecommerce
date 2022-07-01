package co.com.ecommerce.daos;

import javax.persistence.EntityManager;
import co.com.ecommerce.entities.Usuario;
import co.com.ecommerce.utilities.Conexion;

public class UsuarioDao {
	EntityManager entity = Conexion.getEntityManagerFactory().createEntityManager();
	
	
	public void registrarUsuario(Usuario user) {
		entity.getTransaction().begin();
		entity.persist(user);
		entity.getTransaction().commit();
		//ConexionDB.disconnect();
	}
	
	public void actualizar(Usuario user) {
		entity.getTransaction().begin();
		if(user.getEstado() != 0) {
			entity.merge(user);
			entity.getTransaction().commit();
		}
		//ConexionDB.disconnect();
	}
	
	public Usuario buscar(int user) {
		Usuario usuario= new Usuario();
		usuario = entity.find(Usuario.class, user);
		if(usuario.getEstado() != 0) {
			return usuario;
		}
		//ConexionDB.disconnect();
		return null;
	}
	
	public void eliminar(int user) {
		Usuario usuario= new Usuario();
		entity.getTransaction().begin();
		usuario = entity.find(Usuario.class, user);
		//ConexionDB.disconnect();
		usuario.setEstado(0);
		entity.merge(usuario);
		entity.getTransaction().commit();
	}
	
}
