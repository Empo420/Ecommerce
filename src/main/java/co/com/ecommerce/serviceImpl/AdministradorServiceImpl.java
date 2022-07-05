package co.com.ecommerce.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import co.com.ecommerce.daos.AdministradorDao;
import co.com.ecommerce.daos.FacturaDao;
import co.com.ecommerce.entities.Administrador;
import co.com.ecommerce.services.AdministradorService;


public class AdministradorServiceImpl implements AdministradorService{


	private AdministradorDao administradorDao;
	private FacturaDao facturaDao;
	
	public AdministradorServiceImpl () {
		administradorDao = new AdministradorDao();
		facturaDao = new FacturaDao();
	}

	@Override
	public void registrase(Administrador admin) {
		administradorDao.registrarAdministrador(admin);
	}
	
	@Override
	public void actualizar(Administrador admin) {
		administradorDao.actualizar(admin);
	}

	@Override
	public Administrador iniciarSesion(int user, String pass) {
		Administrador admin =administradorDao.buscarInicio(user, pass);
		return admin;
	}

	@Override
	public void actuaizarAdministrador(Administrador admin) {
		administradorDao.actualizar(admin);
	}
	

	@Override
	public List<Administrador> buscarAdministradorEmpresa(int empresa) {
		List<Administrador> admins = administradorDao.buscarAdministradorEmpresa(empresa);
		return admins;
	}

	@Override
	public double dineroTotal(int admin) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double promedio(int admin) {
		// TODO Auto-generated method stub
		return 0;
	}

}
