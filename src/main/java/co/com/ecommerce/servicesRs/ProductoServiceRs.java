package co.com.ecommerce.servicesRs;

import java.util.Date;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.com.ecommerce.entities.Administrador;
import co.com.ecommerce.entities.Categoria;
import co.com.ecommerce.entities.Marca;
import co.com.ecommerce.entities.Producto;
import co.com.ecommerce.serviceImpl.ProductoServiceImpl;

@Path("/producto")
public class ProductoServiceRs {

	private ProductoServiceImpl productoServiceImpl;
	
	public ProductoServiceRs() {
		productoServiceImpl = new ProductoServiceImpl();
	}
	
	/*
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void eliminarDelInventario(int idProducto, Administrador idAdministrador) {
		productoServiceImpl.eliminarDelInventario(idProducto, idAdministrador);
	}*/

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/crearProducto")
	public Response agregarAlInventario( Producto producto) {
		productoServiceImpl.agregarAlInventario(producto);
		return Response.ok().entity(producto).build();
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/buscarProducto/{nombre}")
	public List<Producto> buscarProducto(@PathParam("nombre") String nombre){
		List<Producto> productos = productoServiceImpl.buscarProducto(nombre);
		return productos;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/productoBuscarAdministrador/{nombre}/{idAdministrador}")
	public List<Producto> buscarProductoAdministrador(@PathParam("nombre") String nombre, @PathParam("idAdministrador") int idAdministrador){
		List<Producto> productos = productoServiceImpl.buscarProductoAdministrador(nombre, idAdministrador);
		return productos;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/productoPorCategoria/{categoria}")
	public List<Producto> buscarProductoPorCategoria(@PathParam("categoria") int categoria){
		List<Producto> productos = productoServiceImpl.buscarProductoPorCategoria(categoria);
		return productos;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/productoPorCategoriaAdmin/{categoria}/{idAdministrador}")
	public List<Producto> buscarProductoPorCategoriaAdministrador(@PathParam("categoria") int categoria, @PathParam("idAdministrador") int idAdministrador){
		List<Producto> productos = productoServiceImpl.buscarProductoPorCategoriaAdministrador(categoria, idAdministrador);
		return productos;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/productoPorMarcaAdmin/{marca}/{idAdministrador}")
	public List<Producto> buscarProductoPorMarcaAdministrador(@PathParam("marca") int marca, @PathParam("idAdministrador") int idAdministrador){
		List<Producto> productos = productoServiceImpl.buscarProductoPorMarcaAdministrador(marca, idAdministrador);
		return productos;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscarMarca/{marca}")
	public List<Producto> buscarProductoPorMarca(@PathParam("marca") int marca){
		List<Producto> productos = productoServiceImpl.buscarProductoPorMarca(marca);
		return productos;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listarProductos")
	public List<Producto> listarProductos(){
		List<Producto> productos = productoServiceImpl.listarProductos();
		return productos;
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscarProductoPorId/{id}")
	public Producto buscarProductoPorId(@PathParam("id") int id){
		Producto producto = productoServiceImpl.buscarProductoPorId(id);
		return producto;
	}
 	/*@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void actualizarProducto(Producto producto) {
		productoServiceImpl.actualizarProducto(producto);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{categoria}/{descuento}/{idAdministrador}")
	public void darDescuentoPorMarca(@PathParam("marca") int marca, @PathParam("descuento") double descuento, @PathParam("idAdministrador")int idAdministrador) {
		productoServiceImpl.darDescuentoPorMarca(marca, descuento, idAdministrador);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{categoria}/{descuento}/{idAdministrador}")
	public void darDescuentoPorCategoria(@PathParam("categoria") int categoria ,@PathParam("descuento") double descuento, @PathParam("idAdministrador") int idAdministrador) {
		productoServiceImpl.darDescuentoPorCategoria(categoria, descuento, idAdministrador);
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{idProducto}/{pCantidad}")
	public boolean abastecerProducto(@PathParam("idProducto") int idProducto,@PathParam("pCantidad") int pCantidad) {
		boolean abastecio = productoServiceImpl.abastecerProducto(idProducto, pCantidad);
		return abastecio;
	}*/
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/cantidadProductosAdmin/{admin}")
	public int cantidadProductos(@PathParam("admin") int admin) {
		int cantidad = productoServiceImpl.cantidadProductos(admin);
		return cantidad;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/productosAdmin/{idAdmin}")
	public List<Producto> misProductosAdministrador(@PathParam("idAdmin") int idAdmin){
		List<Producto> productos = productoServiceImpl.misProductosAdministrador(idAdmin);
		return productos;
	}
	
}
