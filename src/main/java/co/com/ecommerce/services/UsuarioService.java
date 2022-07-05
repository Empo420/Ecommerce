package co.com.ecommerce.services;

import java.util.ArrayList;
import co.com.ecommerce.entities.Usuario;
import co.com.ecommerce.entities.Venta;

public interface UsuarioService {
	public void crearCuenta(Usuario usuario);
	public void iniciarSesion(int user, String pass);
	public void actualizarPerfil(Usuario user);
	public boolean comprar(Venta ventas, ArrayList<Integer> idsProductos );
}

