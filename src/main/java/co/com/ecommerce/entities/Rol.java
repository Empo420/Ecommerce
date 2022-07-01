package co.com.ecommerce.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the rol database table.
 * 
 */
@Entity
@Table(name = "\"rol\"", schema = "ecommerce")
@NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	@Column(name = "roles")
	private String roles;

	public Rol(Integer id, String roles) {

		this.id = id;
		this.roles = roles;
	}

	public Rol() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoles() {
		return this.roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

}