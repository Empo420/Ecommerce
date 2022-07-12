package co.com.ecommerce.daos;

import java.security.MessageDigest;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.EntityManager;

import org.apache.commons.codec.binary.Base64;

import co.com.ecommerce.entities.Usuario;
import co.com.ecommerce.utilities.Conexion;
import co.com.ecommerce.utilities.Md5Encript;

public class UsuarioDao {
	EntityManager entity = Conexion.getEntityManagerFactory().createEntityManager();
	private Md5Encript md5;

	public UsuarioDao() {
		md5 = new Md5Encript();
	}

	public void registrarUsuario(Usuario user) {
		String pass = user.getContrasenia();
		String ecriptacion = md5.decode(pass);

		user.setContrasenia(ecriptacion);
		entity.getTransaction().begin();
		entity.persist(user);
		entity.getTransaction().commit();
		// ConexionDB.disconnect();
	}

	public void actualizar(Usuario user) {
		entity.getTransaction().begin();
		if (user.getEstado() != 0) {
			entity.merge(user);
			entity.getTransaction().commit();
		}
		// ConexionDB.disconnect();
	}

	public Usuario buscar(int user) {
		Usuario usuario = new Usuario();
		usuario = entity.find(Usuario.class, user);

		String pass = usuario.getContrasenia();

		if (usuario.getEstado() != 0) {
			String desencriptacion = md5.decript(pass);
			usuario.setContrasenia(desencriptacion);
			return usuario;
		}
		return null;
	}

	public void eliminar(int user) {
		Usuario usuario = new Usuario();
		entity.getTransaction().begin();
		usuario = entity.find(Usuario.class, user);
		// ConexionDB.disconnect();
		usuario.setEstado(0);
		entity.merge(usuario);
		entity.getTransaction().commit();
	}

}
