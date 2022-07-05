package co.com.ecommerce.serviceImpl;

import java.util.List;

import co.com.ecommerce.daos.MarcaDao;
import co.com.ecommerce.entities.Marca;
import co.com.ecommerce.services.MarcaService;

public class MarcaServiceImpl implements MarcaService {
	
	private MarcaDao marcaDao;
	
	public MarcaServiceImpl() {
		marcaDao = new MarcaDao();
	}

	@Override
	public void agregarMarca(Marca marca) {
		marcaDao.agregarNuevaMarca(marca);
	}

	@Override
	public void actualizarMarca(Marca marca) {
		marcaDao.actualizar(marca);;
	}

	@Override
	public Marca buscarMarca(int marca) {
		Marca marcas = new Marca();
		marcas = marcaDao.buscarMarca(marca);
		return marcas;
	}

	@Override
	public List<Marca> listarMarcas() {
		List<Marca> marcas = marcaDao.listarMarcas();
		return marcas;
	}

}
