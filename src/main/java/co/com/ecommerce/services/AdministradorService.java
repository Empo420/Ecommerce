package co.com.ecommerce.services;

import java.util.ArrayList;
import co.com.ecommerce.entities.Administrador;

public interface AdministradorService {
	public void registrase(Administrador admin);
	public void actualizar(Administrador admin);
	public Administrador iniciarSesion(int user, String pass);
	public void actuaizarAdministrador(Administrador admin);
	public ArrayList<Object> listarFacturasPagas(int idAdministrador);
	public ArrayList<Object> listarFacturasNoPagas(int idAdministrador);
	public double dineroTotal(int admin);
	public double promedio(int admin);

}
