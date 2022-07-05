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
import co.com.ecommerce.entities.Factura;
import co.com.ecommerce.serviceImpl.FacturaServiceImpl;

@Path("/factura")
public class FacturaServiceRs {

	private FacturaServiceImpl facturaServiceImpl;
	
	public FacturaServiceRs() {
		facturaServiceImpl = new FacturaServiceImpl();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/crearFacturar")
	public Response agregarFactura(Factura factura) {
		facturaServiceImpl.agregarFactura(factura);
		return Response.ok().entity(factura).build();
	}

	@PUT
	@Path("/updateFactura")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response actualizarFactura(Factura factura) {
		facturaServiceImpl.actualizarFactura(factura);
		return Response.ok().entity(factura).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscarFactura/{idFactura}")
	public Factura buscarFactura(@PathParam("idFactura") int idFactura) {
		Factura factura = facturaServiceImpl.buscarFactura(idFactura);
		return factura;
	}

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listarFacturas")
	public List<Factura> listarFacturas() {
		List<Factura> facturas = facturaServiceImpl.listarFacturas();
		return facturas;
	}
}
