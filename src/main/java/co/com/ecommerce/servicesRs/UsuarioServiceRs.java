package co.com.ecommerce.servicesRs;

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

import co.com.ecommerce.entities.Usuario;
import co.com.ecommerce.serviceImpl.UsuarioServiceImpl;

@Path("/usuario")
public class UsuarioServiceRs {

	private UsuarioServiceImpl usuarioServiceImpl;
	
	public UsuarioServiceRs() {
		usuarioServiceImpl = new UsuarioServiceImpl();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/crearUser")
	public Response crearUsuario(Usuario user) {
		usuarioServiceImpl.crearCuenta(user);
		return Response.ok().entity(user).build();
	}
	
	@PUT
	@Path("/updateUser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response actualizarDatos(Usuario user) {
		usuarioServiceImpl.actualizarPerfil(user);
		return Response.ok(user).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscarUser/{idUsuario}")
	public Usuario buscarUsuario(@PathParam("idUsuario") int idUsuario) {
		Usuario usuario = usuarioServiceImpl.buscarUsuario(idUsuario);
		return usuario;
	}
}
