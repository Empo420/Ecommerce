package co.com.ecommerce.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the marca database table.
 * 
 */
@Entity
@Table(name="\"marca\"", schema = "ecommerce")
@NamedQuery(name="Marca.findAll", query="SELECT m FROM Marca m")
public class Marca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	@Column(name="marcas")
	private String marcas;

	public Marca(Integer id, String marcas) {
	
		this.id = id;
		this.marcas = marcas;
	}

	public Marca() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMarcas() {
		return this.marcas;
	}

	public void setMarcas(String marcas) {
		this.marcas = marcas;
	}

	@Override
	public String toString() {
		return "Marca [id=" + id + ", marcas=" + marcas + "]";
	}
	
	

}