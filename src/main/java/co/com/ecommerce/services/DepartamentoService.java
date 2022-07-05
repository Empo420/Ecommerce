package co.com.ecommerce.services;

import java.util.List;
import co.com.ecommerce.entities.Departamento;

public interface DepartamentoService {
	public void agregarNuevoDepartamento(Departamento departamento); 
	public void actualizar(Departamento departamento);
	public Departamento buscarDepartamento(int idDepartamento);
	public List<Departamento> listarDepartamentos();
}
