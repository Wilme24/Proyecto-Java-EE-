package com.ubosque.grupo4N.mb;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.primefaces.context.RequestContext;

import com.ubosque.grupo4N.modelo.Empleado;
import com.ubosque.grupo4N.modelo.Empleado;
import com.ubosque.grupo4N.modelo.Especialidad;
import com.ubosque.grupo4N.modelo.Usuario;
import com.ubosque.grupo4N.servicio.EmpleadoServicio;
import com.ubosque.grupo4N.servicio.EmpleadoServicio;


@ManagedBean(name="empleadoMB")
@SessionScoped
public class EmpleadoMB {

	/**
	 * Clase managed bean 
	 * Creación de variables privadas
	 */
	Empleado nuevaEmpleado;
	EmpleadoServicio empleadoServicio;
	List<Empleado> listaEmpleado;
	List<SelectItem> listaEmpleados;
	Empleado viejaEmpleado;
	int idEspecialidad;
	EspecialidadMB es;
	int idRol;
	CorreoMB correo;
	Usuario usuario;
	/**
	 * Métodos get y set de las variables
	 */
	public List<SelectItem> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(List<SelectItem> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	public int getIdEspecialidad() {
		return idEspecialidad;
	}

	public void setIdEspecialidad(int idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	UsuarioMB us;
	/**
	 * Creación del constructor donde inicializa las variables
	 */
	public EmpleadoMB() {
		// TODO Auto-generated constructor stub
		nuevaEmpleado = new Empleado();
		viejaEmpleado = new Empleado();
		empleadoServicio = new EmpleadoServicio();
		listaEmpleado = empleadoServicio.consultarEmpleado();
		es = new EspecialidadMB();
		us = new UsuarioMB();
		correo = new CorreoMB();
		usuario = new Usuario();
		listaEmpleados = new ArrayList<SelectItem>();
		for(int i=0; i<listaEmpleado.size();i++){
			Empleado es= listaEmpleado.get(i);
			listaEmpleados.add(new SelectItem(es.getIdEmpleado(),es.getApellidosEmpleado()));
		}
	}
	
	public Empleado getNuevaEmpleado() {
		return nuevaEmpleado;
	}
	public void setNuevaEmpleado(Empleado nuevaEmpleado) {
		this.nuevaEmpleado = nuevaEmpleado;
	}
	public EmpleadoServicio getEmpleadoServicio() {
		return empleadoServicio;
	}
	public void setEmpleadoServicio(EmpleadoServicio empleadoServicio) {
		this.empleadoServicio = empleadoServicio;
	}
	public List<Empleado> getListaEmpleado() {
		return listaEmpleado;
	}
	public void setListaEmpleado(List<Empleado> listaEmpleado) {
		this.listaEmpleado = listaEmpleado;
	}
	public Empleado getViejaEmpleado() {
		return viejaEmpleado;
	}
	public void setViejaEmpleado(Empleado viejaEmpleado) {
		this.viejaEmpleado = viejaEmpleado;
	}

	/**
	 * Metodo para crear un nuevo empleado
	 * */
	public String crearEmpleado(){
		nuevaEmpleado.setEstado(Short.parseShort("1"));
		nuevaEmpleado.setEspecialidad(es.consultarEspecialidadEmpleado(idEspecialidad));
		empleadoServicio.crearEmpleado(nuevaEmpleado);
		correo.setUsuario(nuevaEmpleado.getCorreoEmpleado());
		correo.setAsunto("Usuario instituto corazón");
		
		usuario=us.crearUsuario(idRol,empleadoServicio.consultarEmpleadoUsuario(nuevaEmpleado.getDocumentoEmpleado()).get(0));
		try {
			correo.setMensaje("Buen día </br> Usted ha sido registrado en la página del Instituto corazón; por favor ingrese a: . Sus datos son: Usuario: "+usuario.getUsuario()+" Contraseña: "+Herramientas.desencriptar(usuario.getContrasena()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
		correo.enviarCorreosUsuario();
		listaEmpleado = empleadoServicio.consultarEmpleado();
		RequestContext.getCurrentInstance().execute("valid()");
		return "consultarEmpleados";
	}
	/**
	 * Metodo para actualizar un nuevo empleado existente
	 * */
	public String actualizarEmpleado(){
		empleadoServicio.actualizarEmpleado(nuevaEmpleado);
		listaEmpleado = empleadoServicio.consultarEmpleado();
		RequestContext.getCurrentInstance().execute("valid()");
		return "consultarEmpleadoes";
	}
	/**
	 * Metodo para consultar un nuevo empleado por su documento
	 * */
	public String consultarEmpleadoEspecifica(){
		if(viejaEmpleado.getDocumentoEmpleado() == 0)
			listaEmpleado = empleadoServicio.consultarEmpleado();
		else
			listaEmpleado = empleadoServicio.consultarEmpleadoEspecifica(viejaEmpleado);
		return "consultarEmpleadoes";
	}
	/**
	 * Metodo para eliminar un empleado
	 * */
	public String eliminarEmpleado(){
		viejaEmpleado.setEstado(Short.parseShort("0"));
		empleadoServicio.eliminarEmpleado(viejaEmpleado);
		listaEmpleado = empleadoServicio.consultarEmpleado();
		viejaEmpleado.setDocumentoEmpleado(0);
		RequestContext.getCurrentInstance().execute("valid()");
		return "consultarEmpleadoes";
	}
	/**
	 * Metodo para consultar un  empleado por el usuario
	 * */
	public Empleado consultarEmpleadoUsuario(int documento){
		return empleadoServicio.consultarEmpleadoUsuario(documento).get(0);
	}
	/**
	 * Metodo para consultar un empleado por su ID
	 * */
	public Empleado consultarEmpleadoId(int id){
		return empleadoServicio.consultarEmpleadoId(id).get(0);
	}
	/**
	 * Metodo para consultar la cita de un empleado por su ID
	 * */

	public Empleado consultarEmpleadoCita(int id){
		Empleado em= null;
		listaEmpleado = empleadoServicio.consultarEmpleado();
		for(int i=0;i<listaEmpleado.size();i++){
			em = listaEmpleado.get(i);
			if(em.getIdEmpleado()==id){
				break;
			}
		}
		return em;
	}
	/**
	 * Metodo para consultar la disponibilidad de un empleado
	 * */
	public List<Empleado> consultarDisponibilidadEmpleado(Date fecha, String nombre){
		return empleadoServicio.consultarDisponibilidadEmpleado(fecha, nombre);
	}
}
