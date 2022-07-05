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

import co.com.ecommerce.entities.Ciudad;
import co.com.ecommerce.serviceImpl.CiudadServiceImpl;

@Path("/ciudad")
public class CiudadServiceRs {
	
	private CiudadServiceImpl ciudadServiceImpl;
	
	public CiudadServiceRs() {
		ciudadServiceImpl = new CiudadServiceImpl();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/crearCiudad")
	public Response agregarNuevaCiudad(Ciudad ciudad) {
		ciudadServiceImpl.agregarNuevaCiudad(ciudad);
		return Response.ok().entity(ciudad).build();
	}

	@PUT
	@Path("/updateCiudad")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response actualizar(Ciudad ciudad) {
		ciudadServiceImpl.actualizar(ciudad);
		return Response.ok().entity(ciudad).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscarCiudad/{idCiudad}")
	public Ciudad buscarCiudad(@PathParam("idCiudad") int idCiudad) {
		Ciudad ciudad = ciudadServiceImpl.buscarCiudad(idCiudad);
		return ciudad;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listarCiudades")
	public List<Ciudad> listarCiudades() {
		List<Ciudad> ciudades = ciudadServiceImpl.listarCiudades();
		return ciudades;
	}
	
}
