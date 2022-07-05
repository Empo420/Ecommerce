package co.com.ecommerce.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the ventas database table.
 * 
 */
@Entity
@Table(name = "\"ventas\"", schema = "ecommerce")
@NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v")
public class Venta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "idusuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "idmetodopago")
	private Metodopago metodopago;
	
	@ManyToOne
	@JoinColumn(name = "idciudad")
	private Ciudad ciudad;

	@Column(name = "correoenvio")
	private String correoEnvio;
	
	@Column(name = "direccionenvio")
	private String direccionEnvio;

	@Column(name = "fechaventa")
	private String fechaVenta;
	
	@Column(name = "estadoventa")
	private Integer estadoVenta;

	
	public Venta( Usuario usuario, Metodopago metodopago, Ciudad ciudad, String correoEnvio,
			String direccionEnvio, String fechaVenta, Integer estadoVenta) {

		this.usuario = usuario;
		this.metodopago = metodopago;
		this.ciudad = ciudad;
		this.correoEnvio = correoEnvio;
		this.direccionEnvio = direccionEnvio;
		this.fechaVenta = fechaVenta;
		this.estadoVenta = estadoVenta;
	}
	
	public Venta( Usuario usuario, Metodopago metodopago, Ciudad ciudad, String correoEnvio,
			String direccionEnvio, String fechaVenta) {

		this.usuario = usuario;
		this.metodopago = metodopago;
		this.ciudad = ciudad;
		this.correoEnvio = correoEnvio;
		this.direccionEnvio = direccionEnvio;
		this.fechaVenta = fechaVenta;
		this.estadoVenta = 1;
	}

	public Venta() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Metodopago getMetodopago() {
		return metodopago;
	}

	public void setMetodopago(Metodopago metodopago) {
		this.metodopago = metodopago;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccionEnvio() {
		return direccionEnvio;
	}

	public void setDireccionEnvio(String direccionEnvio) {
		this.direccionEnvio = direccionEnvio;
	}

	public String getCorreoEnvio() {
		return correoEnvio;
	}

	public void setCorreoEnvio(String correoEnvio) {
		this.correoEnvio = correoEnvio;
	}

	public String getFechaventa() {
		return fechaVenta;
	}

	public void setFechaventa(String fechaventa) {
		this.fechaVenta = fechaventa;
	}

	public Integer getEstadoventa() {
		return estadoVenta;
	}

	public void setEstadoventa(Integer estadoventa) {
		this.estadoVenta = estadoventa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}