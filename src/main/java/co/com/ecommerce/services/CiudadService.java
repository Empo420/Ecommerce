package co.com.ecommerce.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import co.com.ecommerce.entities.Ciudad;

public interface CiudadService {
	public void agregarNuevaCiudad(Ciudad ciudad);
	public void actualizar(Ciudad ciudad);
	public Ciudad buscarCiudad(int idCiudad);
	public List<Ciudad> listarCiudades();
}
