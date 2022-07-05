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

import co.com.ecommerce.entities.Pais;
import co.com.ecommerce.serviceImpl.PaisServiceImpl;

@Path("/pais")
public class PaisServiceRs {
	private PaisServiceImpl paisServiceImpl;
	
	public PaisServiceRs() {
		paisServiceImpl = new PaisServiceImpl();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/crearPais")
	public Response agregarNuevoPais(Pais pais) {
		paisServiceImpl.agregarNuevoPais(pais);
		return Response.ok().entity(pais).build();
	}

	@PUT
	@Path("/updatePais")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response actualizar(Pais pais) {
		paisServiceImpl.actualizar(pais);
		return Response.ok().entity(pais).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscarPais/{idPais}")
	public Pais buscarPais(@PathParam("idPais") int idPais) {
		Pais pais = paisServiceImpl.buscarPais(idPais);
		return pais;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listarPaises")
	public List<Pais> listarPaises() {
		List<Pais> paises = paisServiceImpl.listarPaises();
		return paises;
	}
}
