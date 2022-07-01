package co.com.ecommerce.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import co.com.ecommerce.daos.AdministradorDao;
import co.com.ecommerce.entities.Administrador;
import co.com.ecommerce.entities.Empresa;
import co.com.ecommerce.entities.Rol;

public class TestAdministrador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdministradorDao controlador = new AdministradorDao();
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
		Date fechas = new Date();
		try {
			fechas = formato.parse("2002-11-12");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Empresa empresa = new Empresa( 123456, "PyhMarkting", "cra 4 -566", "31257648", "pyhmar@gmail.com", "marketing","empresa123", "empresa.jpg");

		Rol rol2 = new Rol(1, "administrador");
	
		Administrador admin = new Administrador(1129, "alberto", "yara", "cc", empresa, "42638434030", "correo@gmail", "cra 5", "dubud88", rol2, "admin", fechas );
		Administrador adminActualizado = new Administrador(1129, "alberto", "Oyola", "cc", empresa, "8819883", "admin@gmail", "cra 6", "dubud88", rol2, "admin", fechas );
		
		//crear administrador
		controlador.registrarAdministrador(admin);
		
		
		//actualizar Administrador
		controlador.actualizar(adminActualizado);
		
		//buscar dministrador
		Administrador adminBuscar = controlador.buscar(1129);
		
		System.out.println(adminBuscar.toString());
		
		
		List<Administrador> administradoresEmpresa = controlador.buscarAdministradorEmpresa(empresa);
		Administrador admin1 = null;
		
		
		System.out.println();
		System.out.println("--------Listar administradores por Empresa------------");
		System.out.println();
		for(int i = 0; i < administradoresEmpresa.size(); i++) {
			admin1 = administradoresEmpresa.get(i);
			System.out.println(admin1.toString());
		}
		
		controlador.eliminar(1129);
	}

}
