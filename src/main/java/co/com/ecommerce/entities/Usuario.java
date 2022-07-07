package co.com.ecommerce.entities;

import java.io.Serializable;
import javax.persistence.*;
/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name="\"usuario\"", schema = "ecommerce")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer identificacion;

	@Column(name="nombre")
	private String nombre;
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="tipoidentificacion")
	private String tipoDeIdentificacion;
	
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
	private String fechanacimiento;
	@Column(name="estado")
	private Integer estado;
	

	public Usuario() {
	}

	public Usuario(Integer identificacion, String nombre, String apellido, String tipoDeIdentificacion, String telefono,
			String correo, String direccion, String codigoPostal, Rol idRol, String contrasenia, String fechanacimiento) {
		
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDeIdentificacion = tipoDeIdentificacion;
		this.telefono = telefono;
		this.correo = correo;
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		this.idRol = idRol;
		this.contrasenia = contrasenia;
		this.fechanacimiento = fechanacimiento;
		this.estado = 1;
	}

	public Usuario(Integer identificacion, String nombre, String apellido, String tipoDeIdentificacion, String telefono,
			String correo, String direccion, String codigoPostal, Rol idRol, String contrasenia, String fechanacimiento,
			Integer estado) {
	
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDeIdentificacion = tipoDeIdentificacion;
		this.telefono = telefono;
		this.correo = correo;
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		this.idRol = idRol;
		this.contrasenia = contrasenia;
		this.fechanacimiento = fechanacimiento;
		this.estado = estado;
	}

	public Integer getIdentificacion() {
		return identificacion;
	}


	public void setIdentificacion(Integer identificacion) {
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


	public String getTipoDeIdentificacion() {
		return tipoDeIdentificacion;
	}


	public void setTipoDeIdentificacion(String tipoDeIdentificacion) {
		this.tipoDeIdentificacion = tipoDeIdentificacion;
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


	public String getFechanacimiento() {
		return fechanacimiento;
	}


	public void setFechanacimiento(String fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}


	public Integer getEstado() {
		return estado;
	}


	public void setEstado(Integer estado) {
		this.estado = estado;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}