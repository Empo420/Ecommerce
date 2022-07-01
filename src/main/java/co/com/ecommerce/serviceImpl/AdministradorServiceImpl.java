package co.com.ecommerce.serviceImpl;

import java.util.ArrayList;
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
	public ArrayList<Object> listarFacturasPagas(int idAdministrador) {
		ArrayList<Object> facturasPagas = facturaDao.listarFacturasPagasAdministrador(idAdministrador);
		return facturasPagas;
	}
	
	@Override
	public ArrayList<Object> listarFacturasNoPagas(int idAdministrador) {
		ArrayList<Object> facturasPagas = facturaDao.listarFacturasNoPagasAdministrador(idAdministrador);
		return facturasPagas;
	}

	@Override
	public double dineroTotal(int admin) {
		ArrayList<Object> facturasPagas = facturaDao.listarFacturasPagasAdministrador(admin);
		
		double total = 0;
		for(int i = 0; i < facturasPagas.size(); i++) {
			Object[] registro = (Object []) facturasPagas.get(i);
			total += Double.parseDouble(registro[3].toString());
		}
		return total;
	}

	@Override
	public double promedio(int admin) {
		ArrayList<Object> facturasPagas = facturaDao.listarFacturasPagasAdministrador(admin);
		
		double total = 0;
		for(int i = 0; i < facturasPagas.size(); i++) {
			Object[] registro = (Object []) facturasPagas.get(i);
			total += Double.parseDouble(registro[3].toString());
		}
		return total / facturasPagas.size();
	}

}
