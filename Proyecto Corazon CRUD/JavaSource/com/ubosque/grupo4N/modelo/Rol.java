package com.ubosque.grupo4N.modelo;
// Generated 12/05/2017 11:19:54 AM by Hibernate Tools 5.2.1.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Rol generated by hbm2java
 */
@Entity
@Table(name = "rol", catalog = "heartscits", uniqueConstraints = @UniqueConstraint(columnNames = "perfilRol"))
public class Rol implements java.io.Serializable {

	private Integer idRol;
	private String perfilRol;
	private Set<Usuario> usuarios = new HashSet<Usuario>(0);

	public Rol() {
	}

	public Rol(String perfilRol) {
		this.perfilRol = perfilRol;
	}

	public Rol(String perfilRol, Set<Usuario> usuarios) {
		this.perfilRol = perfilRol;
		this.usuarios = usuarios;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idRol", unique = true, nullable = false)
	public Integer getIdRol() {
		return this.idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	@Column(name = "perfilRol", unique = true, nullable = false, length = 50)
	public String getPerfilRol() {
		return this.perfilRol;
	}

	public void setPerfilRol(String perfilRol) {
		this.perfilRol = perfilRol;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "rol")
	public Set<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
