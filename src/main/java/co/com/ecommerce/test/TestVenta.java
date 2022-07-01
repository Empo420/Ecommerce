package co.com.ecommerce.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import co.com.ecommerce.daos.VentaDao;
import co.com.ecommerce.entities.Departamento;
import co.com.ecommerce.entities.Metodopago;
import co.com.ecommerce.entities.Pais;
import co.com.ecommerce.entities.Rol;
import co.com.ecommerce.entities.Usuario;
import co.com.ecommerce.entities.Venta;

public class TestVenta {

	public static void main(String[] args) {
		VentaDao  venta= new VentaDao();
		
		/*Rol rol = new Rol(1,"usuario");
		Pais pais = new Pais(1, "COLOMBIA");
		Departamento departemento = new Departamento(5, pais, "CUNDINAMARCA");
		Ciudad ciudad = new Ciudad(3, departemento, "BOGOTA");
		Metodopago metodoPago = new Metodopago(1, "CREDITO");
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
		Date fechas = new Date();
		try {
			fechas = formato.parse("2015-11-23");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Usuario user = new Usuario(1109840,"Esteban", "Pamo", "cc", "312344555",
				"esteba@gmail", "cra 6", "ikjs88", rol,"empo11", fechas);
		
		SimpleDateFormat formatos = new SimpleDateFormat("yyyy-MM-dd"); 
		Date fechaCreacion = new Date();
		try {
			fechaCreacion = formatos.parse("2022-06-24");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Venta ventaCreada = new Venta( user,  metodoPago, ciudad ,  user.getDireccion(), user.getCorreo(),
				fechaCreacion);
		
		Venta ventaActualizada = new Venta( user,  metodoPago, ciudad ,  "cra 9", "123@gmail",
				fechaCreacion);
		
		//crear venta
		venta.crearVenta(ventaCreada);
		
		
		//actualizar Venta
		venta.actualizarVenta(ventaActualizada);
		
		
		//actualizar estado Venta
		venta.actualizarEstadoVenta(2, ventaCreada);
		*/
		
		SimpleDateFormat formatos = new SimpleDateFormat("yyyy-MM-dd"); 
		Date fechaCreacion = new Date();
		try {
			fechaCreacion = formatos.parse("2022-06-24");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println();
		System.out.println("--------Ventas no pagas------------");
		System.out.println();
		
		List<Venta> ventaNoPagas = venta.buscarVentaNoPagas(1102, fechaCreacion);
		Venta venta1 = null;
		for(int i = 0; i < ventaNoPagas.size(); i++) {
			venta1 = ventaNoPagas.get(i);
			System.out.println(venta1.toString());
		}
		
		System.out.println();
		System.out.println("--------Ventas pagas------------");
		System.out.println();
		
		List<Venta> ventaPagas = venta.buscarVentaPagas(1102, fechaCreacion);
		Venta venta2 = null;
		for(int i = 0; i < ventaPagas.size(); i++) {
			venta2 = ventaPagas.get(i);
			System.out.println(venta2.toString());
		}
		
		//EliminarVenta
		//venta.eliminarVenta(ventaActualizada);
	}

}
