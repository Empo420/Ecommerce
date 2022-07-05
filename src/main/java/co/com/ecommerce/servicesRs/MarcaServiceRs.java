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

import org.apache.log4j.Logger;

import co.com.ecommerce.entities.Marca;
import co.com.ecommerce.serviceImpl.MarcaServiceImpl;

@Path("/marca")
public class MarcaServiceRs {
	
	private MarcaServiceImpl marcaServiceImpl;
	private static Logger log = Logger.getLogger(MarcaServiceRs.class);
	
	public MarcaServiceRs() {
		marcaServiceImpl = new MarcaServiceImpl();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/crearMarca")
	public Response agregarMarca(Marca marca) {
		marcaServiceImpl.agregarMarca(marca);
		return Response.ok().entity(marca).build();
	}

	@PUT
	@Path("/updateCategoria")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response actualizarMarca(Marca marca) {
		marcaServiceImpl.actualizarMarca(marca);
		return Response.ok().entity(marca).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscarMarca/{idMarca}")
	public Marca buscarMarca(@PathParam("idMarca")int marca) {
		Marca marcas = marcaServiceImpl.buscarMarca(marca);
		return marcas;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listarMarcas")
	public List<Marca> listarMarcas() {
		log.info("se esta ejecuntado la consulta");
		List<Marca> marcas = marcaServiceImpl.listarMarcas();
		log.info("se  ejecuo la consulta");
		return marcas;
	}

}
