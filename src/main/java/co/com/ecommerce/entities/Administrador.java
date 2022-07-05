package co.com.ecommerce.entities;

import java.io.Serializable;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="\"administrador\"", schema = "ecommerce")
@NamedQuery(name="Administrador.findAll", query="SELECT a FROM Administrador a")
public class Administrador implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer identificacion;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellido")
	private String apellido;
	@Column(name="tipoidentificacion")
	private String tipoIdentificacion;
	
	@ManyToOne
	@JoinColumn(name="idempresa")
	private Empresa idEmpresa;
	
	@Column(name="telefono")
	private String telefono;
	@Column(name="correo")
	private String correo;
	@Column(name="direccion")
	private String direccion;
	@Column(name="codigopostal")
	private String codigoPostal;
	
	@ManyToOne
	@JoinColumn(name="idrol")
	private Rol idRol;
	
	@Column(name="contrasenia")
	private String contrasenia;
	
	@Column(name="fechanacimiento")
	private String fechaDeNacimiento;
	@Column(name="estado")
	private int estado;

	

	public Administrador(Integer identificacion, String nombre, String apellido, String tipoIdentificacion,
			Empresa idEmpresa, String telefono, String correo, String direccion, String codigoPostal, Rol idRol,
			String contrasenia, String fechaDeNacimiento) {
		
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoIdentificacion = tipoIdentificacion;
		this.idEmpresa = idEmpresa;
		this.telefono = telefono;
		this.correo = correo;
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		this.idRol = idRol;
		this.contrasenia = contrasenia;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.estado = 1;
	}
	
	public Administrador(Integer identificacion, String nombre, String apellido, String tipoIdentificacion,
			Empresa idEmpresa, String telefono, String correo, String direccion, String codigoPostal, Rol idRol,
			String contrasenia, String fechaDeNacimiento, int estado) {
		
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoIdentificacion = tipoIdentificacion;
		this.idEmpresa = idEmpresa;
		this.telefono = telefono;
		this.correo = correo;
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		this.idRol = idRol;
		this.contrasenia = contrasenia;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.estado = estado;
	}



	public Administrador() {
	}

	

	public int getIdentificacion() {
		return identificacion;
	}



	public void setIdentificacion(int identificacion) {
		this.identificacion = identificacion;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}



	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}



	public Empresa getIdEmpresa() {
		return idEmpresa;
	}



	public void setIdEmpresa(Empresa idEmpresa) {
		this.idEmpresa = idEmpresa;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public String getCorreo() {
		return correo;
	}



	public void setCorreo(String correo) {
		this.correo = correo;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public String getCodigoPostal() {
		return codigoPostal;
	}



	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}



	public Rol getIdRol() {
		return idRol;
	}



	public void setIdRol(Rol idRol) {
		this.idRol = idRol;
	}



	public String getContrasenia() {
		return contrasenia;
	}



	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}



	public String getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}



	public void setFechaDeNacimiento(String fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}



	public int getEstado() {
		return estado;
	}



	public void setEstado(int estado) {
		this.estado = estado;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String toString() {
		return "Administrador [identificacion=" + identificacion + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", tipoIdentificacion=" + tipoIdentificacion + ", idEmpresa=" + idEmpresa + ", telefono=" + telefono
				+ ", correo=" + correo + ", direccion=" + direccion + ", codigoPostal=" + codigoPostal + ", idRol="
				+ idRol + ", contrasenia=" + contrasenia + ", fechaDeNacimiento=" + fechaDeNacimiento + ", estado="
				+ estado + "]";
	}



	

}