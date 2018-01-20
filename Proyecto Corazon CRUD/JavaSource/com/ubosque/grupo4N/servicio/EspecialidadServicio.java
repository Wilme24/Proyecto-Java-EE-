package com.ubosque.grupo4N.servicio;

import java.util.List;

import com.ubosque.grupo4N.DAO.EspecialidadDAOInterface;
import com.ubosque.grupo4N.DAO.impl.EspecialidadDAOImpl;
import com.ubosque.grupo4N.modelo.Especialidad;

public class EspecialidadServicio {
	/**
	 * Variable interfaz que representara la fachada
	 * */
	EspecialidadDAOInterface espDAO;
	/**
	 * Constructor donde se instancia la interfaz quien se comportara como un implement
	 * */
	public EspecialidadServicio() {
		// TODO Auto-generated constructor stub
		espDAO = new EspecialidadDAOImpl();
	}
	/**
	 * Metodo que llama al impl para crear una nueva especialidad
	 * */
	public void crearEspecialidad(Especialidad nuevaEspecialidad){
		espDAO.crearEspercialidad(nuevaEspecialidad);
	}
	/**
	 * Metodo que llama al impl para consultar una especialidad
	 * */
	public List<Especialidad> consultarEspecialidad (){
		return espDAO.consultarEspecialidad();
	}
	/**
	 * Metodo que llama al impl para actualizar una especialidad
	 * */
	public void actualizarEspecialidad(Especialidad viejaEspecialidad){
		espDAO.actualizarEspecialidad(viejaEspecialidad);
	}
	/**
	 * Metodo que llama al impl para consultar una especialidad especifica
	 * */
	public List<Especialidad> consultarEspecialidadEspecifica(Especialidad viejaEspecialidad){
		return espDAO.consultarEspecialidadEspecifica(viejaEspecialidad.getNombreEspecialidad());
	}
	/**
	 * Metodo que llama al impl para eliminar una especialidad
	 * */
	public void eliminarEspecialidad(Especialidad viejaEspecialidad){
		espDAO.eliminarEspecialidad(viejaEspecialidad);
	}
	/**
	 * Metodo que llama al impl para consultar una especialidad para los reportes
	 * */
	public List consultarEspecialidadReportes(){
		return espDAO.consultarEspecialidadReportes();
	}
	
}
