package co.com.ecommerce.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the "detalleVenta" database table.
 * 
 */
@Entity
@Table(name="\"detalleVenta\"")
@NamedQuery(name="DetalleVenta.findAll", query="SELECT d FROM DetalleVenta d")
public class DetalleVenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="\"CantidadCompra\"")
	private Integer cantidadCompra;

	@Column(name="\"estadoVenta\"")
	private Integer estadoVenta;

	@Temporal(TemporalType.DATE)
	@Column(name="\"fechaCompra\"")
	private Date fechaCompra;

	@Column(name="\"nombreEmpresa\"")
	private String nombreEmpresa;

	@Column(name="\"nombreProducto\"")
	private String nombreProducto;

	@Column(name="\"nombreUsuario\"")
	private String nombreUsuario;

	@Column(name="\"precioProducto\"")
	private BigDecimal precioProducto;

	@Column(name="\"totalCompra\"")
	private BigDecimal totalCompra;

	public DetalleVenta() {
	}

	public Integer getCantidadCompra() {
		return this.cantidadCompra;
	}

	public void setCantidadCompra(Integer cantidadCompra) {
		this.cantidadCompra = cantidadCompra;
	}

	public Integer getEstadoVenta() {
		return this.estadoVenta;
	}

	public void setEstadoVenta(Integer estadoVenta) {
		this.estadoVenta = estadoVenta;
	}

	public Date getFechaCompra() {
		return this.fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public String getNombreEmpresa() {
		return this.nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getNombreProducto() {
		return this.nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public BigDecimal getPrecioProducto() {
		return this.precioProducto;
	}

	public void setPrecioProducto(BigDecimal precioProducto) {
		this.precioProducto = precioProducto;
	}

	public BigDecimal getTotalCompra() {
		return this.totalCompra;
	}

	public void setTotalCompra(BigDecimal totalCompra) {
		this.totalCompra = totalCompra;
	}

}