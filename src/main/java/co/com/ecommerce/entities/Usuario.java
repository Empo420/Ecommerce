package co.com.ecommerce.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


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
	@Temporal(TemporalType.DATE)
	private Date fechanacimiento;
	@Column(name="estado")
	private Integer estado;
	
	

	//bi-directional many-to-one association to Venta
	@OneToMany(mappedBy="usuario")
	private List<Venta> ventas;

	public Usuario() {
	}

	public Usuario(Integer identificacion, String nombre, String apellido, String tipoDeIdentificacion, String telefono,
			String correo, String direccion, String codigoPostal, Rol idRol, String contrasenia, Date fechanacimiento) {
		super();
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


	public Date getFechanacimiento() {
		return fechanacimiento;
	}


	public void setFechanacimiento(Date fechanacimiento) {
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


	public List<Venta> getVentas() {
		return this.ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	public Venta addVenta(Venta venta) {
		getVentas().add(venta);
		venta.setUsuario(this);

		return venta;
	}

	public Venta removeVenta(Venta venta) {
		getVentas().remove(venta);
		venta.setUsuario(null);

		return venta;
	}

	@Override
	public String toString() {
		return "Usuario [identificacion=" + identificacion + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", tipoDeIdentificacion=" + tipoDeIdentificacion + ", telefono=" + telefono + ", correo=" + correo
				+ ", direccion=" + direccion + ", codigoPostal=" + codigoPostal + ", idRol=" + idRol + ", contrasenia="
				+ contrasenia + ", fechanacimiento=" + fechanacimiento + ", estado=" + estado + ", ventas=" + ventas
				+ "]";
	}
	
	

}