package co.com.ecommerce.serviceImpl;

import java.util.List;

import co.com.ecommerce.daos.ProductoDao;
import co.com.ecommerce.entities.Administrador;
import co.com.ecommerce.entities.Producto;
import co.com.ecommerce.services.ProductoService;

public class ProductoServiceImpl implements ProductoService{
	
	private ProductoDao productoDao;
	
	public ProductoServiceImpl() {
		productoDao = new ProductoDao();
	}

	@Override
	public void agregarAlInventario(Producto producto) {
		productoDao.agregarProducto(producto);
	}

	@Override
	public void eliminarDelInventario(int idProducto, Administrador idAdministrador) {
		productoDao.eliminarProducto(idProducto, idAdministrador);
	}
	
	@Override
	public List<Producto> misProductosAdministrador(int idAdmin) {
		List<Producto> productos = productoDao.misProductosAdministrador(idAdmin);
		if(productos.size() != 0) {
			return productos;
		}
		return null;
	}

	@Override
	public List<Producto> buscarProducto(String nombre) {
		List<Producto> productos = productoDao.buscarProductoPorNombre(nombre);
		if(productos.size() != 0) {
			return productos;
		}
		return null;
	}
	
	@Override
	public List<Producto> buscarProductoAdministrador(String nombre, int idAdministrador){
		List<Producto> productos = productoDao.buscarProductoAdministrador(nombre, idAdministrador);
		if(productos.size() != 0) {
			return productos;
		}
		return null;
	}

	@Override
	public List<Producto> buscarProductoPorCategoria(int categoria) {
		List<Producto> productos = productoDao.obtenerProductosPorCategoria(categoria);
		if(productos.size() != 0) {
			return productos;
		}
		return null;
	}

	@Override
	public List<Producto> buscarProductoPorCategoriaAdministrador(int categoria, int idAdministrador) {
		List<Producto> productos = productoDao.obtenerProductosPorCategoriaAdministrador(categoria, idAdministrador);
		if(productos.size() != 0) {
			return productos;
		}
		return null;
	}

	@Override
	public List<Producto> buscarProductoPorMarcaAdministrador(int marca, int idAdministrador) {
		List<Producto> productos = productoDao.obtenerProductosPorMarcaAdministrador(marca, idAdministrador);
		if(productos.size() != 0) {
			return productos;
		}
		return null;
	}

	@Override
	public List<Producto> buscarProductoPorMarca(int marca) {
		List<Producto> productos = productoDao.obtenerProductosPorMarca(marca);
		if(productos.size() != 0) {
			return productos;
		}
		return null;
	}
	@Override
	public void actualizarProducto(Producto producto) {
		productoDao.actualizarProducto(producto);
	}

	@Override
	public void darDescuentoPorMarca(int marca, double descuento, int idAdministrador) {
		productoDao.descuentoMarca(marca, idAdministrador, descuento);
	}

	@Override
	public void darDescuentoPorCategoria(int categoria , double descuento, int idAdministrador) {
		productoDao.descuentoCategoria(categoria, idAdministrador, descuento);
	}



	@Override
	public int cantidadProductos(int admin) {
		int cantidad = productoDao.cantidadDeProducto(admin);
		return cantidad;
	}

	@Override
	public boolean abastecerProducto(int idProducto, int pCantidad) {
		boolean abastecio = productoDao.abastecer(pCantidad, idProducto);
		return abastecio;
	}

	@Override
	public List<Producto> listarProductos() {
		List<Producto> productos = productoDao.obtenerProductos();
		return productos;
	}

	@Override
	public Producto buscarProductoPorId(int id) {
		Producto producto = productoDao.buscarProductoPorId(id);
		return producto;
	}

}
