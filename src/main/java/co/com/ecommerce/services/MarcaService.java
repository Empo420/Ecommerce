package co.com.ecommerce.services;

import java.util.List;

import co.com.ecommerce.entities.Marca;

public interface MarcaService {

	public void agregarMarca(Marca marca);
	public void actualizarMarca(Marca marca);
	public Marca buscarMarca(int marca);
	public List<Marca> listarMarcas();
}
