package co.com.ecommerce.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "\"departamento\"", schema = "ecommerce")
@NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM Departamento d")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	@Column(name = "departamentos")
	private String departamentos;

	@ManyToOne
	@JoinColumn(name = "idpais")
	private Pais pai;

	public Departamento(Integer id, Pais pai, String departamentos) {
		this.id = id;
		this.pai = pai;
		this.departamentos = departamentos;
	}

	public Departamento() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepartamentos() {
		return this.departamentos;
	}

	public void setDepartamentos(String departamentos) {
		this.departamentos = departamentos;
	}

	public Pais getPai() {
		return this.pai;
	}

	public void setPai(Pais pai) {
		this.pai = pai;
	}

}