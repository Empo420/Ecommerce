package co.com.ecommerce.entities;

import java.io.Serializable;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@Table(name = "\"producto\"", schema = "ecommerce")
@NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "idadministrador")
	private Administrador idAdministrador;
	@ManyToOne
	@JoinColumn(name = "idcategoria")
	private Categoria idCategoria;
	@ManyToOne
	@JoinColumn(name = "idmarca")
	private Marca idMarca;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "caracteristicas")
	private String caracteristicas;
	@Column(name = "valor")
	private double valor;
	@Column(name = "iva")
	private double iva;
	@Column(name = "unidadesvendidas")
	private Integer unidadesVendidas;
	@Column(name = "cantidadunidades")
	private Integer cantidadUnidades;
	@Column(name = "cantidadminima")
	private Integer cantidadMinima;
	@Column(name = "descuento")
	private double descuento;
	
	@Temporal(TemporalType.DATE)
	@JsonbDateFormat(value = "yyyy-MM-dd")
	private Date fechacreacion;
	@Column(name = "estado")
	private Integer estado;
	@Column(name = "imagen")
	private String imagen;

	public Producto(Administrador idAdministrador,Marca idMarca, Categoria idCategoria,  String nombre,
			String caracteristicas, double valor, double iva, Integer unidadesVendidas, Integer cantidadUnidades, Integer cantidadMinima,
			double descuento, Date fechacreacion, String imagen) {

		this.idAdministrador = idAdministrador;
		this.idCategoria = idCategoria;	
		this.idMarca = idMarca;
		this.nombre = nombre;
		this.caracteristicas = caracteristicas;
		this.valor = valor;
		this.iva = iva;
		this.unidadesVendidas = unidadesVendidas;
		this.cantidadUnidades = cantidadUnidades;
		this.cantidadMinima = cantidadMinima;
		this.descuento = descuento;
		this.fechacreacion = fechacreacion;
		this.imagen = imagen;
		this.estado = 1;
	}

	public Producto(Integer id, Administrador idAdministrador, Categoria idCategoria, Marca idMarca, String nombre,
			String caracteristicas, double valor, double iva, Integer unidadesVendidas, Integer cantidadUnidades,
			Integer cantidadMinima, double descuento, Date fechacreacion, String imagen, int estado) {

		this.id = id;
		this.idAdministrador = idAdministrador;
		this.idCategoria = idCategoria;
		this.idMarca = idMarca;
		this.nombre = nombre;
		this.caracteristicas = caracteristicas;
		this.valor = valor;
		this.iva = iva;
		this.unidadesVendidas = unidadesVendidas;
		this.cantidadUnidades = cantidadUnidades;
		this.cantidadMinima = cantidadMinima;
		this.descuento = descuento;
		this.fechacreacion = fechacreacion;
		this.imagen = imagen;
		this.estado = estado;
	}

	public Producto() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Administrador getIdAdministrador() {
		return idAdministrador;
	}

	public void setIdAdministrador(Administrador idAdministrador) {
		this.idAdministrador = idAdministrador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public Integer getUnidadesVendidas() {
		return unidadesVendidas;
	}

	public void setUnidadesVendidas(Integer unidadesVendidas) {
		this.unidadesVendidas = unidadesVendidas;
	}

	public Integer getCantidadUnidades() {
		return cantidadUnidades;
	}

	public void setCantidadUnidades(Integer cantidadUnidades) {
		this.cantidadUnidades = cantidadUnidades;
	}

	public Integer getCantidadMinima() {
		return cantidadMinima;
	}

	public void setCantidadMinima(Integer cantidadMinima) {
		this.cantidadMinima = cantidadMinima;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public Date getFechacreacion() {
		return fechacreacion;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Administrador getAdministrador() {
		return this.idAdministrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.idAdministrador = administrador;
	}

	public Categoria getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Categoria idCategoria) {
		this.idCategoria = idCategoria;
	}

	public Marca getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(Marca idMarca) {
		this.idMarca = idMarca;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", idAdministrador=" + idAdministrador + ", idCategoria=" + idCategoria
				+ ", idMarca=" + idMarca + ", nombre=" + nombre + ", caracteristicas=" + caracteristicas + ", valor="
				+ valor + ", iva=" + iva + ", unidadesVendidas=" + unidadesVendidas + ", cantidadUnidades="
				+ cantidadUnidades + ", cantidadMinima=" + cantidadMinima + ", descuento=" + descuento
				+ ", fechacreacion=" + fechacreacion + ", estado=" + estado + ", imagen=" + imagen + "]";
	}

}