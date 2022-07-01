package co.com.ecommerce.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ventas database table.
 * 
 */
@Entity
@Table(name="ventas")
@NamedQuery(name="Venta.findAll", query="SELECT v FROM Venta v")
public class Venta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String correoenvio;

	private String direccionenvio;

	private Integer estadoventa;

	@Temporal(TemporalType.DATE)
	private Date fechaventa;

	//bi-directional many-to-one association to Factura
	@OneToMany(mappedBy="venta")
	private List<Factura> facturas;

	//bi-directional many-to-one association to Ciudad
	@ManyToOne
	@JoinColumn(name="idciudad")
	private Ciudad ciudad;

	//bi-directional many-to-one association to Metodopago
	@ManyToOne
	@JoinColumn(name="idmetodopago")
	private Metodopago metodopago;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public Venta() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCorreoenvio() {
		return this.correoenvio;
	}

	public void setCorreoenvio(String correoenvio) {
		this.correoenvio = correoenvio;
	}

	public String getDireccionenvio() {
		return this.direccionenvio;
	}

	public void setDireccionenvio(String direccionenvio) {
		this.direccionenvio = direccionenvio;
	}

	public Integer getEstadoventa() {
		return this.estadoventa;
	}

	public void setEstadoventa(Integer estadoventa) {
		this.estadoventa = estadoventa;
	}

	public Date getFechaventa() {
		return this.fechaventa;
	}

	public void setFechaventa(Date fechaventa) {
		this.fechaventa = fechaventa;
	}

	public List<Factura> getFacturas() {
		return this.facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public Factura addFactura(Factura factura) {
		getFacturas().add(factura);
		factura.setVenta(this);

		return factura;
	}

	public Factura removeFactura(Factura factura) {
		getFacturas().remove(factura);
		factura.setVenta(null);

		return factura;
	}

	public Ciudad getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public Metodopago getMetodopago() {
		return this.metodopago;
	}

	public void setMetodopago(Metodopago metodopago) {
		this.metodopago = metodopago;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}