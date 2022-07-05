package co.com.ecommerce.entities;

import java.io.Serializable;
import javax.persistence.*;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@Column(name = "fechacompra")
	private String fechaCompra;

	@Column(name = "total")
	private double total;

	public Factura(Producto producto, Venta venta, double precio, Integer cantidad, String fechacompra, double total) {
	
		this.producto = producto;
		this.venta = venta;
		this.precio = precio;
		this.cantidad = cantidad;
		this.fechaCompra = fechacompra;
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

	public String getFechacompra() {
		return this.fechaCompra;
	}

	public void setFechacompra(String fechacompra) {
		this.fechaCompra = fechacompra;
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
				+ ", cantidad=" + cantidad + ", fechacompra=" + fechaCompra + ", total=" + total + "]";
	}
	
	

}