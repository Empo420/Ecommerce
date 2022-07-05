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
import co.com.ecommerce.entities.Departamento;
import co.com.ecommerce.serviceImpl.DepartamentoServiceImpl;

@Path("/departamento")
public class DepartamentoServiceRs {
	
	private DepartamentoServiceImpl departamentoServiceImpl;
	
	public DepartamentoServiceRs() {
		departamentoServiceImpl = new DepartamentoServiceImpl();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/crearDepartamento")
	public void agregarNuevoDepartamento(Departamento departamento) {
		departamentoServiceImpl.agregarNuevoDepartamento(departamento);
	}


	@PUT
	@Path("/updateDepartamento")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void actualizar(Departamento departamento) {
		departamentoServiceImpl.actualizar(departamento);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscarDepartamento/{idDepartamento}")
	public Departamento buscarDepartamento(@PathParam("idDepartamento") int idDepartamento) {
		Departamento departamento = departamentoServiceImpl.buscarDepartamento(idDepartamento);
		return departamento;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listarDepartamentos")
	public List<Departamento> listarDepartamentos() {
		List<Departamento> departamentos = departamentoServiceImpl.listarDepartamentos();
		return departamentos;
	}
}
