package co.com.ecommerce.servicesRs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.com.ecommerce.entities.Venta;
import co.com.ecommerce.serviceImpl.VentaServiceImpl;

@Path("/venta")
public class VentaServiceRs {

	private VentaServiceImpl ventaServiceImpl;
	
	public VentaServiceRs() {
		ventaServiceImpl = new  VentaServiceImpl();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/crearVenta")
	public Response crearVenta(Venta venta) {
		ventaServiceImpl.CrearVenta(venta);
		return Response.ok().entity(venta).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/ventasNoPagas/{idUser}")
	public List<Venta> listarVentasNoPagas(@PathParam("idUser")int user ) {
		List<Venta> venta = ventaServiceImpl.listarVentasNoPagas(user);
		return venta;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listarVentas")
	public List<Venta> listarVentas() {
		List<Venta> venta = ventaServiceImpl.listarVentas();
		return venta;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscarVenta/{idVenta}")
	public Venta buscarVenta(@PathParam("idVenta")int idVenta) {
		Venta venta = ventaServiceImpl.buscarVenta(idVenta);
		return venta;
	}
}
