package co.com.ecommerce.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import co.com.ecommerce.daos.ProductoDao;
import co.com.ecommerce.entities.Administrador;
import co.com.ecommerce.entities.Categoria;
import co.com.ecommerce.entities.Empresa;
import co.com.ecommerce.entities.Marca;
import co.com.ecommerce.entities.Producto;
import co.com.ecommerce.entities.Rol;

public class testProducto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductoDao controlador = new ProductoDao();
		Calendar fecha = Calendar.getInstance();
         //Convierto Calendar al tipo sql.date.
		Date fechaCreacion = new Date(fecha.getTimeInMillis());
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
		Date fechas = new Date();
		try {
			fechas = formato.parse("23-11-2015");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Empresa empresa = new Empresa( 123456, "PyhMarkting", "cra 4 -566", "31257648", "pyhmar@gmail.com", "marketing","empresa123", "empresa.jpg");
		Rol rol = new Rol(1, "usuario");
		Rol rol2 = new Rol(1, "administrador");
	
		Administrador admin = new Administrador(1129, "alberto", "yara", "cc", empresa, "42638434030", "correo@gmail", "cra 5", "dubud88", rol2, "admin", fechas );
		Categoria categoria = new Categoria(4, "ELECTRODOMESTICOS");
		Marca marca = new Marca(7, "SAMSUNG");
		

		//Producto producto1 = new Producto(admin, categoria, marca, "horno", "calienta y enfria", 100000.00, 0.19, 40, 4, 0.10, fechaCreacion, "producto.jpg");
		//Producto productoActualizado = new Producto(admin, categoria, marca, "horno microHondas", "calienta y enfria", 1000000.00, 0.19, 30, 4, 0.10, fechaCreacion, "producto.jpg");
		
		//crear producto 
		//controlador.agregarProducto(producto1);
		
		//actualizar Producto
		//controlador.actualizarProducto(productoActualizado);
		
		
		//buscarProductpo
		//Producto produc = controlador.buscarProductoPorId(1);
		//System.out.println(produc.toString());
		
		List<Producto> productos = controlador.obtenerProductos();
		Producto producto = null;
		for(int i = 0; i < productos.size(); i++) {
			producto = productos.get(i);
			System.out.println(producto.toString());
		}
		
		System.out.println();
		System.out.println("--------Listar Por categoria------------");
		System.out.println();
		
		List<Producto> productosCatego = controlador.obtenerProductosPorCategoria(4);
		Producto categoriaProducto = null;
		for(int i = 0; i < productosCatego.size(); i++) {
			categoriaProducto = productosCatego.get(i);
			System.out.println(categoriaProducto.toString());
		}
		
		
		System.out.println();
		System.out.println("--------Listar Por Marca------------");
		System.out.println();
		
		List<Producto> productosMarcat = controlador.obtenerProductosPorMarca(7);
		Producto marcaProducto = null;
		for(int i = 0; i < productosMarcat.size(); i++) {
			marcaProducto = productosMarcat.get(i);
			System.out.println(marcaProducto.toString());
		}
		
		System.out.println();
		System.out.println("--------Listar Por Administrador categoria------------");
		System.out.println();
		
		
		List<Producto> productosAdmin = controlador.obtenerProductosPorCategoriaAdministrador(5, 1129);
		Producto adminProducto = null;
		for(int i = 0; i < productosAdmin.size(); i++) {
			adminProducto = productosAdmin.get(i);
			System.out.println(adminProducto.toString());
		}
		
		System.out.println();
		System.out.println("--------Listar Por Administrador marca------------");
		System.out.println();
		
		List<Producto> productosAdminMarca = controlador.obtenerProductosPorMarcaAdministrador(7, 1129);
		Producto adminProductoMarca = null;
		for(int i = 0; i < productosAdminMarca.size(); i++) {
			adminProductoMarca = productosAdminMarca.get(i);
			System.out.println(adminProductoMarca.toString());
		}
		
		System.out.println();
		System.out.println("--------buscar Producto por id------------");
		System.out.println();
		
		Producto productoBuscado = controlador.buscarProductoPorId(1);
		
		System.out.println(productoBuscado.toString());
		
		System.out.println();
		System.out.println("--------Listar Producto por nombre------------");
		System.out.println();
		
		List<Producto> productoNombre = controlador.buscarProductoPorNombre("horno");
		Producto productoNombres = null;
		for(int i = 0; i < productoNombre.size(); i++) {
			productoNombres = productoNombre.get(i);
			System.out.println(productoNombres.toString());
		}
		
		System.out.println();
		System.out.println("--------buscar producto NOMBRE administrador------------");
		System.out.println();
		
		List<Producto> productosAdminNombre = controlador.buscarProductoAdministrador("Air", 1129);
		Producto adminProductoNombre = null;
		for(int i = 0; i < productosAdminNombre.size(); i++) {
			adminProductoNombre = productosAdminNombre.get(i);
			System.out.println(adminProductoNombre.toString());
		}
		
	}

}
