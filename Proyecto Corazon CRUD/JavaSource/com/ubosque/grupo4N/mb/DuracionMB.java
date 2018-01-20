package com.ubosque.grupo4N.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;

import com.ubosque.grupo4N.modelo.Duracion;
import com.ubosque.grupo4N.servicio.DuracionServicio;
@ManagedBean(name="duracionMB")
@SessionScoped
public class DuracionMB {
	/**
	 * Clase managed bean 
	 * Creación de variables privadas
	 */
	Duracion nuevaDuracion;
	private DuracionServicio duracionServicio;
	private List<Duracion> listaDuracion;
	private Duracion viejaDuracion;
	/**
	 * Creación del constructor donde inicializa las variables
	 */
	public DuracionMB() {
		// TODO Auto-generated constructor stub
		nuevaDuracion = new Duracion();
		viejaDuracion = new Duracion();
		duracionServicio = new DuracionServicio();
		listaDuracion = duracionServicio.consultarDuracion();
	}
	/**
	 * Métodos get y set de las variables
	 */
	public Duracion getNuevaDuracion() {
		return nuevaDuracion;
	}
	public void setNuevaDuracion(Duracion nuevaDuracion) {
		this.nuevaDuracion = nuevaDuracion;
	}
	public DuracionServicio getDuracionServicio() {
		return duracionServicio;
	}
	public void setDuracionServicio(DuracionServicio duracionServicio) {
		this.duracionServicio = duracionServicio;
	}
	public List<Duracion> getListaDuracion() {
		return listaDuracion;
	}
	public void setListaDuracion(List<Duracion> listaDuracion) {
		this.listaDuracion = listaDuracion;
	}
	public Duracion getViejaDuracion() {
		return viejaDuracion;
	}
	public void setViejaDuracion(Duracion viejaDuracion) {
		this.viejaDuracion = viejaDuracion;
	}
	/**
	 * Método que permite crear una duracion y viejaDuracion
	 */
	public Duracion crearDuracion(){
		RequestContext.getCurrentInstance().execute("valid()");
		duracionServicio.crearDuracion(nuevaDuracion);
		listaDuracion = duracionServicio.consultarDuracionEspecifica();
		viejaDuracion = listaDuracion.get(0);
		return viejaDuracion;
	}
	/**
	 * Método que permite crear una duracion y re direcciona a la página de viejaDuracion
	 */
	public String actualizarDuracion(){
		duracionServicio.actualizarDuracion(nuevaDuracion);
		listaDuracion = duracionServicio.consultarDuracion();
		return "consultarDuraciones";
	}
	/**
	 * Método que permite crear una duracion y re direcciona a la página de viejaDuracion
	 */
	public Duracion consultarDuracion (){
		listaDuracion=duracionServicio.consultarDuracion();
		Duracion dur=null;
		Boolean iguales = false;
		for(int i=0; i<listaDuracion.size();i++){
			dur=listaDuracion.get(i);
			if(dur.getTiempo().equals(nuevaDuracion.getTiempo())){
				iguales = true;
				break;
			}
		}
		if(iguales == false){
			dur=new Duracion();
			dur.setIdDuracion(0);
		}
		return dur;
	}
	
}
