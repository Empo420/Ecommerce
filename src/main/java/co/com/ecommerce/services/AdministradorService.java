package co.com.ecommerce.services;

import java.util.ArrayList;
import java.util.List;

import co.com.ecommerce.entities.Administrador;

public interface AdministradorService {
	public void registrase(Administrador admin);
	public void actualizar(Administrador admin);
	public Administrador iniciarSesion(int user, String pass);
	public void actuaizarAdministrador(Administrador admin);
	public double dineroTotal(int admin);
	public double promedio(int admin);
	public List<Administrador> buscarAdministradorEmpresa(int empresa);
}
