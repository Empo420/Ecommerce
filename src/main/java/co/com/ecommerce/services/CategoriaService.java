package co.com.ecommerce.services;

import java.util.List;
import co.com.ecommerce.entities.Categoria;

public interface CategoriaService {

	public void agregarCategoria(Categoria catego);
	public Categoria buscarCategoria(int catego);
	public void actualizarCategoria(Categoria catego);
	public List<Categoria> listarCategorias();
}
