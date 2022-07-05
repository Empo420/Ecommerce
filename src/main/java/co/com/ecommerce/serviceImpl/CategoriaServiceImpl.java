package co.com.ecommerce.serviceImpl;

import java.util.List;
import co.com.ecommerce.daos.CategoriaDao;
import co.com.ecommerce.entities.Categoria;
import co.com.ecommerce.services.CategoriaService;

public class CategoriaServiceImpl implements CategoriaService{

	private CategoriaDao categoriaDao;
	
	public CategoriaServiceImpl() {
		categoriaDao = new CategoriaDao();
	}
	
	@Override
	public void agregarCategoria(Categoria catego) {
		categoriaDao.agregarNuevaCategoria(catego);
		
	}

	@Override
	public Categoria buscarCategoria(int catego) {
		Categoria categoria = categoriaDao.buscarCategoria(catego);
		return categoria;
	}

	@Override
	public void actualizarCategoria(Categoria catego) {
		categoriaDao.actualizar(catego);
	}

	@Override
	public List<Categoria> listarCategorias() {
		List<Categoria> categorias = categoriaDao.listarCategorias();
		return categorias;
	}

}
