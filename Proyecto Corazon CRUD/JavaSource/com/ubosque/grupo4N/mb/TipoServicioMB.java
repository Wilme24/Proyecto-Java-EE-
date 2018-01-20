package com.ubosque.grupo4N.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import com.ubosque.grupo4N.modelo.Duracion;
import com.ubosque.grupo4N.modelo.Empleado;
import com.ubosque.grupo4N.modelo.Especialidad;
import com.ubosque.grupo4N.modelo.Tiposervicio;
import com.ubosque.grupo4N.servicio.DuracionServicio;
import com.ubosque.grupo4N.servicio.TipoServicioServicio;

import org.primefaces.context.RequestContext;

@ManagedBean(name="TipoServicioMB")
@SessionScoped
public class TipoServicioMB {

	/**
	 * Clase managed bean 
	 * Creación de variables privadas
	 */
	Tiposervicio nuevaTipoServicio;
	TipoServicioServicio tipoServicioServicio;
	List<Tiposervicio> listaTipoServicio;
	List<SelectItem> listaTipos;
	Tiposervicio viejaTipoServicio;
	
	/**
	 * Métodos get y set de las variables
	 */
	public List<SelectItem> getListaTipos() {
		return listaTipos;
	}

	public void setListaTipos(List<SelectItem> listaTipos) {
		this.listaTipos = listaTipos;
	}

	DuracionMB durMB;
	
	public DuracionMB getDurMB() {
		return durMB;
	}

	public void setDurMB(DuracionMB durMB) {
		this.durMB = durMB;
	}

	public Tiposervicio getNuevaTipoServicio() {
		return nuevaTipoServicio;
	}
	
	public void setNuevaTipoServicio(Tiposervicio nuevaTipoServicio) {
		this.nuevaTipoServicio = nuevaTipoServicio;
	}

	public TipoServicioServicio getTipoServicioServicio() {
		return tipoServicioServicio;
	}

	public void setTipoServicioServicio(TipoServicioServicio tipoServicioServicio1) {
		tipoServicioServicio = tipoServicioServicio1;
	}

	public List<Tiposervicio> getListaTipoServicio() {
		return listaTipoServicio;
	}

	public void setListaTipoServicio(List<Tiposervicio> listaTipoServicio) {
		this.listaTipoServicio = listaTipoServicio;
	}

	public Tiposervicio getViejaTipoServicio() {
		return viejaTipoServicio;
	}

	public void setViejaTipoServicio(Tiposervicio viejaTipoServicio) {
		this.viejaTipoServicio = viejaTipoServicio;
	}
	/**
	 * Creación del constructor donde inicializa las variables
	 */
	public TipoServicioMB() {
		// TODO Auto-generated constructor stub
		nuevaTipoServicio = new Tiposervicio();
		viejaTipoServicio = new Tiposervicio();
		tipoServicioServicio = new TipoServicioServicio();
	    listaTipoServicio = tipoServicioServicio.consultarTiposervicio();
		durMB = new DuracionMB();
		listaTipos = new ArrayList<SelectItem>();
		for(int i=0; i<listaTipoServicio.size();i++){
			Tiposervicio es= listaTipoServicio.get(i);
			listaTipos.add(new SelectItem(es.getIdTipoServicio(),es.getNombreTipoServicio()));
		}
	}
	/**
	 * Metodo para crear un nuevo tipo de servicio	
	 * */
	public String crearTipoServicio(){
		RequestContext.getCurrentInstance().execute("valid()");
		nuevaTipoServicio.setEstado(Short.parseShort("1"));
		System.out.println(durMB.nuevaDuracion.getTiempo());
		Duracion d =durMB.consultarDuracion();
		
		if(d.getIdDuracion()==0){
			nuevaTipoServicio.setDuracion(durMB.crearDuracion());
		}else{
			nuevaTipoServicio.setDuracion(d);
		}
		tipoServicioServicio.crearTiposervicio(nuevaTipoServicio);
		listaTipoServicio = tipoServicioServicio.consultarTiposervicio();
		return "consultarTipoServicio";
	}
	/**
	 * Metodo para actualizar un tipo de servicio
	 * */
	public String actualizarTipoServicio(){

		durMB.setNuevaDuracion(nuevaTipoServicio.getDuracion());
		Duracion d =durMB.consultarDuracion();
		if(d.getIdDuracion()==0){
			nuevaTipoServicio.setDuracion(durMB.crearDuracion());
		}else{
			nuevaTipoServicio.setDuracion(d);
		}
		tipoServicioServicio.actualizarTiposervicio(nuevaTipoServicio);
		listaTipoServicio = tipoServicioServicio.consultarTiposervicio();
		return "consultarTipoServicio";
	}
	
	/**
	 * Metodo para consultar un tipo de servicio por su nombre
	 * */
	public String consultarTipoServicio(String nombreTipoServicio){
		return tipoServicioServicio.consultarTiposervicioEspecifica(nombreTipoServicio).get(0).getNombreTipoServicio();
	
	}
	/**
	 * Metodo para actualizar un tipo de servicio de una cita
	 * */
	public Tiposervicio consultarTipoServicioCita(int id){
		Tiposervicio ts= null;
		listaTipoServicio = tipoServicioServicio.consultarTiposervicio();
		for(int i=0;i<listaTipoServicio.size();i++){
			ts = listaTipoServicio.get(i);
			if(ts.getIdTipoServicio()==id){
				break;
			}
		}
		return ts;
	}
	/**
	 * Metodo para actualizar un tipo de servicio por su nombre
	 * */
	public String consultarTipoEspecifica(){
		if(viejaTipoServicio.getNombreTipoServicio().equals(""))
			listaTipoServicio = tipoServicioServicio.consultarTiposervicio();
		else
			listaTipoServicio = tipoServicioServicio.consultarTiposervicioEspecifica(viejaTipoServicio.getNombreTipoServicio());
		return "consultarTipoServicio";
	}
	
	
}
