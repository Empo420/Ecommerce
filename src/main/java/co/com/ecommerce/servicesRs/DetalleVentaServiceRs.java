package co.com.ecommerce.servicesRs;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.com.ecommerce.entities.DetalleVenta;
import co.com.ecommerce.serviceImpl.DetellaVentaServiceImpl;

@Path("/detalle")
public class DetalleVentaServiceRs {

	private DetellaVentaServiceImpl detellaVentaServiceImpl;

	public DetalleVentaServiceRs() {
		detellaVentaServiceImpl =  new DetellaVentaServiceImpl();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/detalleNoPagoUser/{idUsuario}")
	public List<DetalleVenta> listarFacturasNoPagasUsuario(@PathParam("idUsuario")int user) {
		List<DetalleVenta> detalle = detellaVentaServiceImpl.listarFacturasNoPagasUsuario(user);
		return detalle;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/detallePagoUser/{idUsuario}")
	public List<DetalleVenta> listarFacturasPagasUsuario(@PathParam("idAdministrador")int user) {
		List<DetalleVenta> detalle = detellaVentaServiceImpl.listarFacturasPagasUsuario(user);
		return detalle;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/detalleNoPagoAdmin/{idAdministrador}")
	public List<DetalleVenta> listarFacturasNoPagasAdministrador(@PathParam("idAdministrador")int admin) {
		List<DetalleVenta> detalle = detellaVentaServiceImpl.listarFacturasNoPagasAdministrador(admin);
		return detalle;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/detallePagoAdmin/{idAdministrador}")
	public List<DetalleVenta> listarFacturasPagasAdministrador(@PathParam("idAdministrador")int admin) {
		List<DetalleVenta> detalle = detellaVentaServiceImpl.listarFacturasPagasAdministrador(admin);
		return detalle;
	}

}
