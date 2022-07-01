package co.com.ecommerce.services;

import java.util.List;
import co.com.ecommerce.entities.Administrador;
import co.com.ecommerce.entities.Producto;

public interface ProductoService {

	public void agregarAlInventario(Producto producto);
	public void eliminarDelInventario(int idProducto, Administrador idAdministrador);
	public Producto buscarProductoPorId(int id);
	public List<Producto> buscarProducto(String nombre);
	public List<Producto> buscarProductoAdministrador(String nombre, int idAdministrador);
	public List<Producto> buscarProductoPorCategoria(int categoria);
	public List<Producto> buscarProductoPorCategoriaAdministrador(int categoria, int idAdministrador);
	public List<Producto> buscarProductoPorMarcaAdministrador(int marca, int idAdministrador);
	public List<Producto> buscarProductoPorMarca(int marca);
	public List<Producto> listarProductos();
	public void actualizarProducto(Producto producto);
	public void darDescuentoPorMarca(int marca, double descuento, int idAdministrador);
	public void darDescuentoPorCategoria(int categoria , double descuento, int idAdministrador);
	public int cantidadProductos(int admin);
	public boolean abastecerProducto(int idProducto, int pCantidad);
	public List<Producto> misProductosAdministrador(int idAdmin);
}
