package com.ubosque.grupo4N.modelo;
// Generated 12/05/2017 11:19:54 AM by Hibernate Tools 5.2.1.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Horario generated by hbm2java
 */
@Entity
@Table(name = "horario", catalog = "heartscits")
public class Horario implements java.io.Serializable {

	private Integer idHorario;
	private Empleado empleado;
	private Date fechaInicialHorario;
	private Date fechaFinalHorario;
	private Date horaInicialHorario;
	private Date horaFinalHorario;

	public Horario() {
	}

	public Horario(Empleado empleado, Date fechaInicialHorario, Date fechaFinalHorario, Date horaInicialHorario,
			Date horaFinalHorario) {
		this.empleado = empleado;
		this.fechaInicialHorario = fechaInicialHorario;
		this.fechaFinalHorario = fechaFinalHorario;
		this.horaInicialHorario = horaInicialHorario;
		this.horaFinalHorario = horaFinalHorario;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idHorario", unique = true, nullable = false)
	public Integer getIdHorario() {
		return this.idHorario;
	}

	public void setIdHorario(Integer idHorario) {
		this.idHorario = idHorario;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fkHorarioEmpleado", nullable = false)
	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fechaInicialHorario", nullable = false, length = 10)
	public Date getFechaInicialHorario() {
		return this.fechaInicialHorario;
	}

	public void setFechaInicialHorario(Date fechaInicialHorario) {
		this.fechaInicialHorario = fechaInicialHorario;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fechaFinalHorario", nullable = false, length = 10)
	public Date getFechaFinalHorario() {
		return this.fechaFinalHorario;
	}

	public void setFechaFinalHorario(Date fechaFinalHorario) {
		this.fechaFinalHorario = fechaFinalHorario;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "horaInicialHorario", nullable = false, length = 8)
	public Date getHoraInicialHorario() {
		return this.horaInicialHorario;
	}

	public void setHoraInicialHorario(Date horaInicialHorario) {
		this.horaInicialHorario = horaInicialHorario;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "horaFinalHorario", nullable = false, length = 8)
	public Date getHoraFinalHorario() {
		return this.horaFinalHorario;
	}

	public void setHoraFinalHorario(Date horaFinalHorario) {
		this.horaFinalHorario = horaFinalHorario;
	}

}
