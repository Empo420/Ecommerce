package co.com.ecommerce.serviceImpl;

import java.util.List;

import co.com.ecommerce.daos.DepartamentoDao;
import co.com.ecommerce.entities.Departamento;
import co.com.ecommerce.services.DepartamentoService;

public class DepartamentoServiceImpl implements DepartamentoService{
	
	private DepartamentoDao departamentoDao;
	
	public DepartamentoServiceImpl() {
		departamentoDao = new DepartamentoDao();
	}

	@Override
	public void agregarNuevoDepartamento(Departamento departamento) {
		departamentoDao.agregarNuevoDepartamento(departamento);
	}

	@Override
	public void actualizar(Departamento departamento) {
		departamentoDao.actualizar(departamento);
	}

	@Override
	public Departamento buscarDepartamento(int idDepartamento) {
		Departamento departamento = departamentoDao.buscarDepartamento(idDepartamento);
		return departamento;
	}

	@Override
	public List<Departamento> listarDepartamentos() {
		List<Departamento> departamentos = departamentoDao.listarDepartamentos();
		return departamentos;
	}
}
