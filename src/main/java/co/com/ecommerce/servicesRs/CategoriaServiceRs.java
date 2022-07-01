package co.com.ecommerce.servicesRs;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/crearCategoria")
	public Response agregarCategoria( Categoria categoria) {
		categoriaServiceImpl.agregarCategoria(categoria);
		return Response.ok().entity(categoria).build();
	}
}
