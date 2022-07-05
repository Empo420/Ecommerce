package co.com.ecommerce.serviceImpl;

import java.util.List;

import co.com.ecommerce.daos.CiudadDao;
import co.com.ecommerce.entities.Ciudad;
import co.com.ecommerce.services.CiudadService;

public class CiudadServiceImpl implements CiudadService{
	
	private CiudadDao ciudadDao;
	
	public CiudadServiceImpl() {
		ciudadDao = new CiudadDao();
	}

	@Override
	public void agregarNuevaCiudad(Ciudad ciudad) {
		ciudadDao.agregarNuevaCiudad(ciudad);
	}

	@Override
	public void actualizar(Ciudad ciudad) {
		ciudadDao.actualizar(ciudad);
	}

	@Override
	public Ciudad buscarCiudad(int idCiudad) {
		Ciudad ciudad = ciudadDao.buscarCiudad(idCiudad);
		return ciudad;
	}

	@Override
	public List<Ciudad> listarCiudades() {
		List<Ciudad> ciudades = ciudadDao.listarCiudades();
		return ciudades;
	}
	
	
}
