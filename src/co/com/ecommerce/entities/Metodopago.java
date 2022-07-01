package co.com.ecommerce.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the metodopago database table.
 * 
 */
@Entity
@NamedQuery(name="Metodopago.findAll", query="SELECT m FROM Metodopago m")
public class Metodopago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String metodos;

	//bi-directional many-to-one association to Venta
	@OneToMany(mappedBy="metodopago")
	private List<Venta> ventas;

	public Metodopago() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMetodos() {
		return this.metodos;
	}

	public void setMetodos(String metodos) {
		this.metodos = metodos;
	}

	public List<Venta> getVentas() {
		return this.ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	public Venta addVenta(Venta venta) {
		getVentas().add(venta);
		venta.setMetodopago(this);

		return venta;
	}

	public Venta removeVenta(Venta venta) {
		getVentas().remove(venta);
		venta.setMetodopago(null);

		return venta;
	}

}