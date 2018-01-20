package com.ubosque.grupo4N.mb;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.ubosque.grupo4N.modelo.Empleado;
import com.ubosque.grupo4N.modelo.Horario;
import com.ubosque.grupo4N.servicio.HorarioServicio;



@ManagedBean(name="horarioMB")
@SessionScoped

public class HorarioMB {
	/**
	 * Clase managed bean 
	 * Creación de variables privadas
	 */
	Horario nuevoHorario;
	HorarioServicio horarioServicio;
	List<Horario> listaHorario;
	Horario viejoHorario;
	int idHor1;
	int idHorario;
	EmpleadoMB emple;
	/**
	 * Métodos get y set de las variables
	 */
	public Horario getNuevoHorario() {
		return nuevoHorario;
	}


	public void setNuevoHorario(Horario nuevoHorario) {
		this.nuevoHorario = nuevoHorario;
	}


	public List<Horario> getListaHorario() {
		return listaHorario;
	}


	public void setListaHorario(List<Horario> listaHorario) {
		this.listaHorario = listaHorario;
	}


	public Horario getViejoHorario() {
		return viejoHorario;
	}


	public void setViejoHorario(Horario viejoHorario) {
		this.viejoHorario = viejoHorario;
	}


	public int getIdHorario() {
		return idHorario;
	}


	public void setIdHorario(int idHorario) {
		this.idHorario = idHorario;
	}


	public EmpleadoMB getEmple() {
		return emple;
	}


	public void setEmple(EmpleadoMB emple) {
		this.emple = emple;
	}


	public int getIdHor1() {
		return idHor1;
	}


	public void setIdHor1(int idHor1) {
		this.idHor1 = idHor1;
	}


	
	/**
	 * Creación del constructor donde inicializa las variables
	 */
	public HorarioMB() {
		nuevoHorario = new Horario();
		viejoHorario = new Horario();
		horarioServicio = new HorarioServicio();
		listaHorario = horarioServicio.consultarHorario();
		emple = new EmpleadoMB();
	}
	
	/**
	 * Metodo para crear un nuevo Horario
	 * */
	public String crearHorario(){
		RequestContext.getCurrentInstance().execute("valid()");
		nuevoHorario.setEmpleado(emple.consultarEmpleadoId(idHorario));
		horarioServicio.crearEmpleado(nuevoHorario);
		
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Horario creado");
		FacesContext.getCurrentInstance().addMessage(null, message);
		listaHorario = horarioServicio.consultarHorario();
		return "consultarHorarios";
	}
	/**
	 * Metodo para actualizar un Horario
	 * */
	public String actualizarHorario(){
		RequestContext.getCurrentInstance().execute("valid()");
		horarioServicio.actualizarHorario(nuevoHorario);
		listaHorario = horarioServicio.consultarHorario();
		return "consultarHorarios";
	}
	/**
	 * Metodo para consultar un Horario
	 * */
	public String consultarHorario(){
		listaHorario = horarioServicio.consultarHorario();
		return "consultarEmpleados";
	}

	
	

}
