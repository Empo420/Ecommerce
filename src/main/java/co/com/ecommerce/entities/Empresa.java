package co.com.ecommerce.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the empresa database table.
 * 
 */
@Entity
@Table(name = "\"empresa\"", schema = "ecommerce")
@NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer nit;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "direccion")
	private String direccion;
	@Column(name = "telefono")
	private String telefono;
	@Column(name = "correo")
	private String correo;
	@Column(name = "razonsocial")
	private String razonSocial;

	@Column(name = "contrasenia")
	private String contrasenia;
	@Column(name = "imagen")
	private String imagen;
	private int estado;

	
	
	
	public Empresa(Integer nit, String nombre, String direccion, String telefono, String correo, String razonSocial,
			String contrasenia, String imagen) {
		super();
		this.nit = nit;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
		this.razonSocial = razonSocial;
		this.contrasenia = contrasenia;
		this.imagen = imagen;
		this.estado = 1;
	}
	
	public Empresa(Integer nit, String nombre, String direccion, String telefono, String correo, String razonSocial,
			String contrasenia, String imagen, int estado) {
		super();
		this.nit = nit;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
		this.razonSocial = razonSocial;
		this.contrasenia = contrasenia;
		this.imagen = imagen;
		this.estado = estado;
	}

	public Empresa() {
	}

	public Integer getNit() {
		return nit;
	}

	public void setNit(Integer nit) {
		this.nit = nit;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
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
		return "Empresa [nit=" + nit + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono
				+ ", correo=" + correo + ", razonSocial=" + razonSocial + ", imagen=" + imagen + ", estado=" + estado
				+ "]";
	}

}