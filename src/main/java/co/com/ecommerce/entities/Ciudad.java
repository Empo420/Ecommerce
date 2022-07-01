package co.com.ecommerce.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="\"ciudad\"", schema = "ecommerce")
@NamedQuery(name="Ciudad.findAll", query="SELECT c FROM Ciudad c")
public class Ciudad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	@Column(name="ciudades")
	private String ciudades;

	
	@ManyToOne
	@JoinColumn(name="iddepartamento")
	private Departamento departamento;

	//bi-directional many-to-one association to Venta
	@OneToMany(mappedBy="ciudad")
	private List<Venta> ventas;

	
	
	
	public Ciudad(Integer id, Departamento departamento, String ciudades ) {
		super();
		this.id = id;
		this.ciudades = ciudades;
		this.departamento = departamento;
	}

	public Ciudad() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCiudades() {
		return this.ciudades;
	}

	public void setCiudades(String ciudades) {
		this.ciudades = ciudades;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Venta> getVentas() {
		return this.ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	public Venta addVenta(Venta venta) {
		getVentas().add(venta);
		venta.setCiudad(this);

		return venta;
	}

	public Venta removeVenta(Venta venta) {
		getVentas().remove(venta);
		venta.setCiudad(null);

		return venta;
	}

	@Override
	public String toString() {
		return "Ciudad [id=" + id + ", ciudades=" + ciudades + ", departamento=" + departamento + ", ventas=" + ventas
				+ "]";
	}

}