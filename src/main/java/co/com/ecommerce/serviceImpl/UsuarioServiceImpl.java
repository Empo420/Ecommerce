package co.com.ecommerce.serviceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import co.com.ecommerce.daos.FacturaDao;
import co.com.ecommerce.daos.ProductoDao;
import co.com.ecommerce.daos.UsuarioDao;
import co.com.ecommerce.entities.Producto;
import co.com.ecommerce.entities.Usuario;
import co.com.ecommerce.entities.Venta;
import co.com.ecommerce.services.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {

	
	private UsuarioDao usuarioDao;
	private ProductoDao productoDao;
	private FacturaDao facturaDao;
	private VentaServiceImpl ventaServiceImpl;

	public UsuarioServiceImpl() {
		usuarioDao = new UsuarioDao();
		productoDao = new ProductoDao();
		facturaDao = new FacturaDao();
		ventaServiceImpl = new VentaServiceImpl();
	}

	@Override
	public void crearCuenta(Usuario usuario) {
		usuarioDao.registrarUsuario(usuario);
	}

	@Override
	public void iniciarSesion(int user, String pass) {
		usuarioDao.actualizar(null);
	}

	@Override
	public void actualizarPerfil(Usuario user) {
		usuarioDao.actualizar(user);
	}

	@Override
	public boolean comprar(Venta ventas, ArrayList<Integer> idsProductos) {
		boolean compro = false;

		Collections.sort(idsProductos);
		Set<Integer> miSet = new HashSet<Integer>(idsProductos);
		for (int id : miSet) {
			int cantidadCompra = Collections.frequency(idsProductos, id);

			Producto producto = productoDao.buscarProductoPorId(id);

			if (cantidadCompra > producto.getCantidadUnidades()) {
				compro = false;
			} else {
				boolean guardo = ventaServiceImpl.vender(ventas, idsProductos);
				if (guardo == true) {
					compro = true;
				}
			}
		}
		return compro;
	}

	@Override
	public Usuario buscarUsuario(int idUsuario) {
		Usuario usuario = usuarioDao.buscar(idUsuario);
		return usuario;
	}


}
