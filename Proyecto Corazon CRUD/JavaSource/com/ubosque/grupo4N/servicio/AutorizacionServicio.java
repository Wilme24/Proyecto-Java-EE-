package com.ubosque.grupo4N.servicio;

import java.util.List;

import com.ubosque.grupo4N.DAO.AutorizacionDAOInterface;
import com.ubosque.grupo4N.DAO.impl.AutorizacionesDAOImpl;
import com.ubosque.grupo4N.modelo.Autorizacion;

public class AutorizacionServicio {

	/**
	 * Variable interfaz que representara la fachada
	 * */
	AutorizacionDAOInterface espDAO;
	
	/**
	 * Constructor donde se instancia la interfaz quien se comportara como un implement
	 * */
	public AutorizacionServicio() {
		espDAO = new AutorizacionesDAOImpl();
	}
	/**
	 * Metodo que llama al impl para crear una nueva autorizacion
	 * */
	public void crearTipoServicio(Autorizacion nuevaAutorizacion){
		espDAO.crearAutorizacion(nuevaAutorizacion);
	}
	/**
	 * Metodo que llama al impl para crear una nueva autorizacion
	 * */
	public void crearAutorizacion(Autorizacion nuevaAutorizacion){
		espDAO.crearAutorizacion(nuevaAutorizacion);
	}
	/**
	 * Metodo que llama al impl para consultar 
	 * */
	public List<Autorizacion> consultarAutorizacion (){
		return espDAO.consultarAutorizacion();
	}
	/**
	 * Metodo que llama al impl para actualizar autorizacion 
	 * */
	public void actualizarAutorizacion(Autorizacion viejaAutorizacion){
		espDAO.actualizarAutorizacion(viejaAutorizacion);
	}
	/**
	 * Metodo que llama al impl para consultar autorizaciones especificas
	 * */
	public List<Autorizacion> consultarAutorizacionEspecifica(Autorizacion viejaAutorizacion){
		return espDAO.consultarAutorizacionEspecifica(viejaAutorizacion.getNitAutorizacion());
	}
	/**
	 * Metodo que llama al impl para eliminar autorizaciones 
	 * */
	public void eliminarAutorizacion(Autorizacion viejaAutorizacion){
		espDAO.eliminarAutorizacion(viejaAutorizacion);
	}
	/**
	 * Metodo que llama al impl para consultar  autorizaciones de un paciente por id
	 * */
	public List<Autorizacion> consultarAutorizacionEspecifica1(Autorizacion viejaAutorizacion){
		return espDAO.consultarAutorizacionEspecifica1(viejaAutorizacion.getPaciente().getIdPaciente());
	}
	/**
	 * Metodo que llama al impl para consultar  autorizaciones por id de la autorizacion
	 * */
	public List<Autorizacion>consultarAutorizacionEspecifica1(int doc){
		return espDAO.consultarAutorizacionEspecifica1(doc);
	}
	/**
	 * Metodo que llama al impl para consultar autorizaciones por asignar
	 * */
	public List<Autorizacion>consultarAutorizacionAsignar(int id){
		return espDAO.consultarAutorizacionPorId(id);
	}
}

