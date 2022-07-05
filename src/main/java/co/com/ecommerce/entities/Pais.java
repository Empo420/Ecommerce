package co.com.ecommerce.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the pais database table.
 * 
 */
@Entity
@Table(name = "\"pais\"", schema = "ecommerce")
@NamedQuery(name = "Pais.findAll", query = "SELECT p FROM Pais p")
public class Pais implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	@Column(name = "paises")
	private String paises;

	// bi-directional many-to-one association to Departamento

	public Pais() {
	}

	public Pais(Integer id, String paises) {

		this.id = id;
		this.paises = paises;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPaises() {
		return this.paises;
	}

	public void setPaises(String paises) {
		this.paises = paises;
	}

}