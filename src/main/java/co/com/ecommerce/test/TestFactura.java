package co.com.ecommerce.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import co.com.ecommerce.daos.FacturaDao;
import co.com.ecommerce.entities.Administrador;
import co.com.ecommerce.entities.Categoria;
import co.com.ecommerce.entities.Ciudad;
import co.com.ecommerce.entities.Departamento;
import co.com.ecommerce.entities.Empresa;
import co.com.ecommerce.entities.Factura;
import co.com.ecommerce.entities.Marca;
import co.com.ecommerce.entities.Metodopago;
import co.com.ecommerce.entities.Pais;
import co.com.ecommerce.entities.Producto;
import co.com.ecommerce.entities.Rol;
import co.com.ecommerce.entities.Usuario;
import co.com.ecommerce.entities.Venta;

public class TestFactura {

	public static void main(String[] args) {
		FacturaDao controlador = new FacturaDao();
		
		/*Rol rol = new Rol(1,"usuario");
		Pais pais = new Pais(1, "COLOMBIA");
		Departamento departemento = new Departamento(5, pais, "CUNDINAMARCA");
		Ciudad ciudad = new Ciudad(4, departemento, "BOGOTA");
		Metodopago metodoPago = new Metodopago(1, "CREDITO");
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
		Date fechas = new Date();
		try {
			fechas = formato.parse("2022-06-24");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Usuario user = new Usuario(1109840,"esteban", "oyola", "cc", "321345666",
				"este@gmail", "cra 4", "hbdu73", rol,"empo112", fechas);
		
		SimpleDateFormat formatos = new SimpleDateFormat("yyyy-MM-dd"); 
		Date fechaCreacion = new Date();
		try {
			fechaCreacion = formatos.parse("2022-06-24");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		SimpleDateFormat formatox = new SimpleDateFormat("yyyy-MM-dd"); 
		Date fechaNacimientoAdmin = new Date();
		try {
			fechaNacimientoAdmin = formatox.parse("2002-11-12");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Empresa empresa = new Empresa( 123456, "PyhMarkting", "cra 4 -566", "31257648", "pyhmar@gmail.com", "marketing","empresa123", null);
		Rol rol2 = new Rol(1, "administrador");
	
		Administrador admin = new Administrador(1129, "alberto", "yara", "cc", empresa, "42638434030", "correo@gmail", "cra 5", "dubud88", rol2, "admin", fechaNacimientoAdmin );
		Categoria categoria = new Categoria(4, "ELECTRODOMESTICOS");
		Marca marca = new Marca(7, "SAMSUNG");
		
		Producto producto1 = new Producto(admin, categoria, marca, "horno", "calienta y enfria", 1000000.00, 0.19, 30, 4, 0.10, fechaCreacion, "producto.jpg");
		
		
		Venta ventaCreada = new Venta(1, user,  metodoPago, ciudad ,  "cra 9", "123@gmail",
				fechaCreacion);
		
		

		Factura factura = new Factura(producto1, ventaCreada, 100000.00, 2, fechaCreacion, 200000.00  );
		
		//controlador.agregarFactura(factura);*/
		
		
		SimpleDateFormat formatos = new SimpleDateFormat("yyyy-MM-dd"); 
		Date fechaCreacion = new Date();
		try {
			fechaCreacion = formatos.parse("2022-06-24");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println();
		System.out.println("--------buscar Factura venta------------");
		System.out.println();
		
		System.out.println(fechaCreacion);
		
		/*List<Factura> facturas = controlador.buscarFacturaVenta(1, fechaCreacion);
		Factura factura1 = null;
		for(int i = 0; i < facturas.size(); i++) {
			factura1 = facturas.get(i);
			System.out.println(factura1.toString());
		}
		
		System.out.println();
		System.out.println("--------buscar Factura venta------------");
		System.out.println();
		
		*/
		
		/*ArrayList<Object> lista = controlador.listarFacturasNoPagasAdministrador(ventaCreada, admin);
		Object listaFac = null;
		for(int i = 0; i < lista.size(); i++) {
			listaFac = lista.get(i);
			System.out.println(listaFac.toString());
		}
		
		ArrayList<Object> listaPagas = controlador.listarFacturasPagasAdministrador(ventaCreada, admin);
		Object listaFacPaga = null;
		for(int i = 0; i < listaPagas.size(); i++) {
			listaFacPaga = listaPagas.get(i);
			System.out.println(listaFacPaga.toString());
		}
		
		
		
		ArrayList<Object> listaUset = controlador.listarFacturasNoPagasUsuario(ventaCreada, user);
		Object listaFacUser = null;
		for(int i = 0; i < listaUset.size(); i++) {
			listaFacUser = listaUset.get(i);
			System.out.println(listaFacUser.toString());
		}
		
		ArrayList<Object> listaPagasUser = controlador.listarFacturasPagasUsuario(ventaCreada, user);
		Object listaFacPagaUser = null;
		for(int i = 0; i < listaPagasUser.size(); i++) {
			listaFacPagaUser = listaPagasUser.get(i);
			System.out.println(listaFacPagaUser.toString());
		}*/
	}

}
