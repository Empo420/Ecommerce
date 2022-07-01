package co.com.ecommerce.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

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

	@Column(name = "direccionenvio")
	private String direccionEnvio;

	@Column(name = "correoenvio")
	private String correoEnvio;

	@Temporal(TemporalType.DATE)
	private Date fechaventa;
	@Column(name = "estadoventa")
	private Integer estadoventa;

	public Venta(Integer id, Usuario usuario, Metodopago metodopago, Ciudad ciudad, String direccionEnvio, String correoEnvio,
			Date fechaventa) {
		
		this.id = id;
		this.usuario = usuario;
		this.metodopago = metodopago;
		this.ciudad = ciudad;
		this.direccionEnvio = direccionEnvio;
		this.correoEnvio = correoEnvio;
		this.fechaventa = fechaventa;
		this.estadoventa = 1;
	}
	
	public Venta(Usuario usuario, Metodopago metodopago, Ciudad ciudad, String direccionEnvio, String correoEnvio,
			Date fechaventa) {
		
		this.usuario = usuario;
		this.metodopago = metodopago;
		this.ciudad = ciudad;
		this.direccionEnvio = direccionEnvio;
		this.correoEnvio = correoEnvio;
		this.fechaventa = fechaventa;
		this.estadoventa = 1;
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

	public Date getFechaventa() {
		return fechaventa;
	}

	public void setFechaventa(Date fechaventa) {
		this.fechaventa = fechaventa;
	}

	public Integer getEstadoventa() {
		return estadoventa;
	}

	public void setEstadoventa(Integer estadoventa) {
		this.estadoventa = estadoventa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Venta [id=" + id + ", usuario=" + usuario + ", metodopago=" + metodopago + ", ciudad=" + ciudad
				+ ", direccionEnvio=" + direccionEnvio + ", correoEnvio=" + correoEnvio + ", fechaventa=" + fechaventa
				+ ", estadoventa=" + estadoventa + "]";
	}
	
	

}