package com.ubosque.grupo4N.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.primefaces.context.RequestContext;

import com.ubosque.grupo4N.modelo.Especialidad;
import com.ubosque.grupo4N.servicio.EspecialidadServicio;

@ManagedBean(name="especialidadMB")
@SessionScoped
public class EspecialidadMB {
	/**
	 * Clase managed bean 
	 * Creación de variables privadas
	 */
	Especialidad nuevaEspecialidad;
	EspecialidadServicio especialidadServicio;
	List<Especialidad> listaEspecialidad;
	Especialidad viejaEspecialidad;
	ArrayList<SelectItem> listaEspecialidades;

	/**
	 * Creación del constructor donde inicializa las variables
	 */
	public EspecialidadMB() {
		// TODO Auto-generated constructor stub
		nuevaEspecialidad = new Especialidad();
		viejaEspecialidad = new Especialidad();
		especialidadServicio = new EspecialidadServicio();
		listaEspecialidad = especialidadServicio.consultarEspecialidad();
		listaEspecialidades = new ArrayList<SelectItem>();
		for(int i=0; i<listaEspecialidad.size();i++){
			Especialidad es= listaEspecialidad.get(i);
			listaEspecialidades.add(new SelectItem(es.getIdEspecialidad(),es.getNombreEspecialidad()));
		}
		
	}
	/**
	 * Metodo para crear una nueva especialidad
	 * */
	public String crearEspecialidad(){
		RequestContext.getCurrentInstance().execute("valid()");
		nuevaEspecialidad.setEstado(Short.parseShort("1"));
		especialidadServicio.crearEspecialidad(nuevaEspecialidad);
		listaEspecialidad = especialidadServicio.consultarEspecialidad();
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Especialidad creada");
		FacesContext.getCurrentInstance().addMessage(null, message);
		return "consultarEspecialidades";
	}
	/**
	 * Metodo para actualizar una especialidad
	 * */
	public String actualizarEspecialidad(){
		RequestContext.getCurrentInstance().execute("valid()");
		especialidadServicio.actualizarEspecialidad(nuevaEspecialidad);
		listaEspecialidad = especialidadServicio.consultarEspecialidad();
		return "consultarEspecialidades";
	}
	/**
	 * Metodo para consultar una especialidad general y por nombre
	 * */

	public String consultarEspecialidadEspecifica(){
		if(viejaEspecialidad.getNombreEspecialidad().equals(""))
			listaEspecialidad = especialidadServicio.consultarEspecialidad();
		else
			listaEspecialidad = especialidadServicio.consultarEspecialidadEspecifica(viejaEspecialidad);
		return "consultarEspecialidades";
	}
	/**
	 * Métodos get y set de las variables
	 */
	public ArrayList<SelectItem> getListaEspecialidades() {
		return listaEspecialidades;
	}

	public void setListaEspecialidades(ArrayList<SelectItem> listaEspecialidades) {
		this.listaEspecialidades = listaEspecialidades;
	}
	
	public Especialidad getViejaEspecialidad() {
		return viejaEspecialidad;
	}

	public void setViejaEspecialidad(Especialidad viejaEspecialidad) {
		this.viejaEspecialidad = viejaEspecialidad;
	}

	public List<Especialidad> getListaEspecialidad() {
		return listaEspecialidad;
	}

	public void setListaEspecialidad(List<Especialidad> listaEspecialidad) {
		this.listaEspecialidad = listaEspecialidad;
	}

	public Especialidad getNuevaEspecialidad() {
		return nuevaEspecialidad;
	}

	public void setNuevaEspecialidad(Especialidad nuevaEspecialidad) {
		this.nuevaEspecialidad = nuevaEspecialidad;
	}
	/**
	 * Metodo para consultar una especialidad del empleado
	 * */
	public Especialidad consultarEspecialidadEmpleado(int id){
		Especialidad es= null;
		listaEspecialidad = especialidadServicio.consultarEspecialidad();
		for(int i=0;i<listaEspecialidad.size();i++){
			es = listaEspecialidad.get(i);
			if(es.getIdEspecialidad()==id){
				break;
			}
		}
		return es;
	}
	/**
	 * Metodo para eliminar una especialidad
	 * */
	public String eliminarEspecialidad(){
		RequestContext.getCurrentInstance().execute("valid()");
		viejaEspecialidad.setEstado(Short.parseShort("0"));
		especialidadServicio.eliminarEspecialidad(viejaEspecialidad);
		listaEspecialidad = especialidadServicio.consultarEspecialidad();
		return "consultarEspecialidades";
	}
}
