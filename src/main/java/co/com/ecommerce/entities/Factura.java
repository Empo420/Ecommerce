package co.com.ecommerce.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;



/**
 * The persistent class for the factura database table.
 * 
 */
@Entity
@Table(name = "\"factura\"", schema = "ecommerce")
@NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f")
public class Factura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "idproducto")
	private Producto producto;

	@ManyToOne
	@JoinColumn(name = "idventa")
	private Venta venta;

	@Column(name = "precio")
	private double precio;

	@Column(name = "cantidad")
	private Integer cantidad;

	@Temporal(TemporalType.DATE)
	private Date fechacompra;

	@Column(name = "total")
	private double total;

	public Factura(Producto producto, Venta venta, double precio, Integer cantidad, Date fechacompra, double total) {
	
		this.producto = producto;
		this.venta = venta;
		this.precio = precio;
		this.cantidad = cantidad;
		this.fechacompra = fechacompra;
		this.total = total;
	}

	public Factura() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFechacompra() {
		return this.fechacompra;
	}

	public void setFechacompra(Date fechacompra) {
		this.fechacompra = fechacompra;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getTotal() {
		return this.total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Venta getVenta() {
		return this.venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	@Override
	public String toString() {
		return "Factura [id=" + id + ", producto=" + producto + ", venta=" + venta + ", precio=" + precio
				+ ", cantidad=" + cantidad + ", fechacompra=" + fechacompra + ", total=" + total + "]";
	}
	
	

}