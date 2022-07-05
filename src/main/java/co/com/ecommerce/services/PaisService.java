package co.com.ecommerce.services;

import java.util.List;
import co.com.ecommerce.entities.Pais;

public interface PaisService {
	public void agregarNuevoPais(Pais pais);
	public void actualizar(Pais pais);
	public Pais buscarPais(int idPais);
	public List<Pais> listarPaises();
}
