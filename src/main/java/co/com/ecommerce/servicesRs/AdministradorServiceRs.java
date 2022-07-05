package co.com.ecommerce.servicesRs;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.com.ecommerce.entities.Administrador;
import co.com.ecommerce.serviceImpl.AdministradorServiceImpl;

@Path("/admin")
public class AdministradorServiceRs {

	private AdministradorServiceImpl administradorServiceImpl;
	
	public AdministradorServiceRs() {
		administradorServiceImpl = new AdministradorServiceImpl();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/crearAdmin")
	public Response registrarAdmin(Administrador admin) {
		administradorServiceImpl.registrase(admin);
		return Response.ok().entity(admin).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listarAdmins/{id}")
	public List<Administrador> buscarAdministradorEmpresa(@PathParam("id")int empresa) {
		List<Administrador> admins = administradorServiceImpl.buscarAdministradorEmpresa(empresa);
		return admins;
	}

}
