package co.com.ecommerce.serviceImpl;

import java.util.List;

import co.com.ecommerce.daos.PaisDao;
import co.com.ecommerce.entities.Pais;
import co.com.ecommerce.services.PaisService;

public class PaisServiceImpl implements PaisService{
	private PaisDao paisDao;
	
	public PaisServiceImpl() {
		paisDao = new PaisDao();
	}

	@Override
	public void agregarNuevoPais(Pais pais) {
		paisDao.agregarNuevoPais(pais);
	}

	@Override
	public void actualizar(Pais pais) {
		paisDao.actualizar(pais);
	}

	@Override
	public Pais buscarPais(int idPais) {
		Pais pais = paisDao.buscarPais(idPais);
		return pais;
	}

	@Override
	public List<Pais> listarPaises() {
		List<Pais> paises = paisDao.listarPaises();
		return paises;
	}
	
}
