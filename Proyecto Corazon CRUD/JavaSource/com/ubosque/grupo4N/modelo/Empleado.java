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
 * Empleado generated by hbm2java
 */
@Entity
@Table(name = "empleado", catalog = "heartscits", uniqueConstraints = @UniqueConstraint(columnNames = "documentoEmpleado"))
public class Empleado implements java.io.Serializable {

	private Integer idEmpleado;
	private Especialidad especialidad;
	private String nombresEmpleado;
	private String apellidosEmpleado;
	private int documentoEmpleado;
	private String direccionEmpleado;
	private Integer telefonoEmpleado;
	private String correoEmpleado;
	private short estado;
	private Set<Horario> horarios = new HashSet<Horario>(0);
	private Set<Cita> citas = new HashSet<Cita>(0);
	private Set<Usuario> usuarios = new HashSet<Usuario>(0);

	public Empleado() {
	}

	public Empleado(String nombresEmpleado, String apellidosEmpleado, int documentoEmpleado, String correoEmpleado,
			short estado) {
		this.nombresEmpleado = nombresEmpleado;
		this.apellidosEmpleado = apellidosEmpleado;
		this.documentoEmpleado = documentoEmpleado;
		this.correoEmpleado = correoEmpleado;
		this.estado = estado;
	}

	public Empleado(Especialidad especialidad, String nombresEmpleado, String apellidosEmpleado, int documentoEmpleado,
			String direccionEmpleado, Integer telefonoEmpleado, String correoEmpleado, short estado,
			Set<Horario> horarios, Set<Cita> citas, Set<Usuario> usuarios) {
		System.out.println("Entro al modelo");
		this.especialidad = especialidad;
		this.nombresEmpleado = nombresEmpleado;
		this.apellidosEmpleado = apellidosEmpleado;
		this.documentoEmpleado = documentoEmpleado;
		this.direccionEmpleado = direccionEmpleado;
		this.telefonoEmpleado = telefonoEmpleado;
		this.correoEmpleado = correoEmpleado;
		this.estado = estado;
		this.horarios = horarios;
		this.citas = citas;
		this.usuarios = usuarios;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idEmpleado", unique = true, nullable = false)
	public Integer getIdEmpleado() {
		return this.idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fkEmpleadoEspecialidad")
	public Especialidad getEspecialidad() {
		return this.especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	@Column(name = "nombresEmpleado", nullable = false, length = 50)
	public String getNombresEmpleado() {
		return this.nombresEmpleado;
	}

	public void setNombresEmpleado(String nombresEmpleado) {
		this.nombresEmpleado = nombresEmpleado;
	}

	@Column(name = "apellidosEmpleado", nullable = false, length = 50)
	public String getApellidosEmpleado() {
		return this.apellidosEmpleado;
	}

	public void setApellidosEmpleado(String apellidosEmpleado) {
		this.apellidosEmpleado = apellidosEmpleado;
	}

	@Column(name = "documentoEmpleado", unique = true, nullable = false)
	public int getDocumentoEmpleado() {
		return this.documentoEmpleado;
	}

	public void setDocumentoEmpleado(int documentoEmpleado) {
		this.documentoEmpleado = documentoEmpleado;
	}

	@Column(name = "direccionEmpleado", length = 50)
	public String getDireccionEmpleado() {
		return this.direccionEmpleado;
	}

	public void setDireccionEmpleado(String direccionEmpleado) {
		this.direccionEmpleado = direccionEmpleado;
	}

	@Column(name = "telefonoEmpleado")
	public Integer getTelefonoEmpleado() {
		return this.telefonoEmpleado;
	}

	public void setTelefonoEmpleado(Integer telefonoEmpleado) {
		this.telefonoEmpleado = telefonoEmpleado;
	}

	@Column(name = "correoEmpleado", nullable = false, length = 100)
	public String getCorreoEmpleado() {
		return this.correoEmpleado;
	}

	public void setCorreoEmpleado(String correoEmpleado) {
		this.correoEmpleado = correoEmpleado;
	}

	@Column(name = "estado", nullable = false)
	public short getEstado() {
		return this.estado;
	}

	public void setEstado(short estado) {
		this.estado = estado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "empleado")
	public Set<Horario> getHorarios() {
		return this.horarios;
	}

	public void setHorarios(Set<Horario> horarios) {
		this.horarios = horarios;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "empleado")
	public Set<Cita> getCitas() {
		return this.citas;
	}

	public void setCitas(Set<Cita> citas) {
		this.citas = citas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "empleado")
	public Set<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
