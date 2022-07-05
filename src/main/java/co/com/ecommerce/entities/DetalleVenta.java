package co.com.ecommerce.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the "detalleVenta" database table.
 * 
 */
@Entity
@Table(name="\"detalleVenta\"", schema = "ecommerce")
@NamedQuery(name="DetalleVenta.findAll", query="SELECT d FROM DetalleVenta d")
public class DetalleVenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idVenta;
	
	@Column(name="idUsuario")
	private Usuario idUsuario;
	
	@Column(name="idAdministrador")
	private Administrador idAdministrador;
	
	@Column(name="precioProducto")
	private double precioProducto;
	
	@Column(name="CantidadCompra")
	private Integer cantidadCompra;
	
	@Column(name="totalCompra")
	private double totalCompra;
	
	@Column(name= "nombreProducto")
	private String nombreProducto;
	
	@Column(name="nombreEmpresa")
	private String nombreEmpresa;

	@Column(name="estadoVenta")
	private Integer estadoVenta;


	@Column(name="fechaCompra")
	private String fechaCompra;

	@Column(name="nombreUsuario")
	private String nombreUsuario;

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

	public String getFechaCompra() {
		return this.fechaCompra;
	}

	public void setFechaCompra(String fechaCompra) {
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

	public double getPrecioProducto() {
		return this.precioProducto;
	}

	public void setPrecioProducto(double precioProducto) {
		this.precioProducto = precioProducto;
	}

	public double getTotalCompra() {
		return this.totalCompra;
	}

	public void setTotalCompra(double totalCompra) {
		this.totalCompra = totalCompra;
	}

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public Usuario getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Administrador getIdAdministrador() {
		return idAdministrador;
	}

	public void setIdAdministrador(Administrador idAdministrador) {
		this.idAdministrador = idAdministrador;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}