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

	public Ciudad(Integer id, Departamento departamento, String ciudades ) {
	
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

}