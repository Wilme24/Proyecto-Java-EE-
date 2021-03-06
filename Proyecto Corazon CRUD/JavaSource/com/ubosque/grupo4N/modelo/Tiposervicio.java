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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Tiposervicio generated by hbm2java
 */
@Entity
@Table(name = "tiposervicio", catalog = "heartscits", uniqueConstraints = @UniqueConstraint(columnNames = "nombreTipoServicio"))
public class Tiposervicio implements java.io.Serializable {

	private Integer idTipoServicio;
	private Duracion duracion;
	private String nombreTipoServicio;
	private short estado;
	private Set<Cita> citas = new HashSet<Cita>(0);

	public Tiposervicio() {
	}

	public Tiposervicio(Duracion duracion, String nombreTipoServicio, short estado) {
		this.duracion = duracion;
		this.nombreTipoServicio = nombreTipoServicio;
		this.estado = estado;
	}

	public Tiposervicio(Duracion duracion, String nombreTipoServicio, short estado, Set<Cita> citas) {
		this.duracion = duracion;
		this.nombreTipoServicio = nombreTipoServicio;
		this.estado = estado;
		this.citas = citas;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idTipoServicio", unique = true, nullable = false)
	public Integer getIdTipoServicio() {
		return this.idTipoServicio;
	}

	public void setIdTipoServicio(Integer idTipoServicio) {
		this.idTipoServicio = idTipoServicio;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fkTipoServicioDuracion", nullable = false)
	public Duracion getDuracion() {
		return this.duracion;
	}

	public void setDuracion(Duracion duracion) {
		this.duracion = duracion;
	}

	@Column(name = "nombreTipoServicio", unique = true, nullable = false, length = 50)
	public String getNombreTipoServicio() {
		return this.nombreTipoServicio;
	}

	public void setNombreTipoServicio(String nombreTipoServicio) {
		this.nombreTipoServicio = nombreTipoServicio;
	}

	@Column(name = "estado", nullable = false)
	public short getEstado() {
		return this.estado;
	}

	public void setEstado(short estado) {
		this.estado = estado;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tiposervicio")
	public Set<Cita> getCitas() {
		return this.citas;
	}

	public void setCitas(Set<Cita> citas) {
		this.citas = citas;
	}

}
