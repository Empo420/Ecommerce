package co.com.ecommerce.servicesRs;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.com.ecommerce.entities.Categoria;
import co.com.ecommerce.serviceImpl.CategoriaServiceImpl;

@Path("/categoria")
public class CategoriaServiceRs {

	private CategoriaServiceImpl categoriaServiceImpl;
	
	public CategoriaServiceRs() {
		categoriaServiceImpl = new CategoriaServiceImpl();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/crearCategoria")
	public Response agregarCategoria( Categoria categoria) {
		categoriaServiceImpl.agregarCategoria(categoria);
		return Response.ok().entity(categoria).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscarCategoria/{idCategoria}")
	public Categoria buscarCategoria(@PathParam("idCategoria") int catego) {
		Categoria categoria = categoriaServiceImpl.buscarCategoria(catego);
		return categoria;
	}

	@PUT
	@Path("/updateCategoria")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response actualizarCategoria(Categoria catego) {
		categoriaServiceImpl.actualizarCategoria(catego);
		return Response.ok().entity(catego).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listarCategorias")
	public List<Categoria> listarCategorias() {
		List<Categoria> categorias = categoriaServiceImpl.listarCategorias();
		return categorias;
	}

}
