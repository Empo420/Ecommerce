package co.com.ecommerce.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the metodopago database table.
 * 
 */
@Entity
@Table(name="\"metodopago\"", schema = "ecommerce")
@NamedQuery(name="Metodopago.findAll", query="SELECT m FROM Metodopago m")
public class Metodopago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	@Column(name="metodos")
	private String metodos;

	public Metodopago(Integer id, String metodos) {
		
		this.id = id;
		this.metodos = metodos;
	}

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

}