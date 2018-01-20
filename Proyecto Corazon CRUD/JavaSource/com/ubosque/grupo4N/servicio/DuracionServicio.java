package com.ubosque.grupo4N.servicio;

import java.util.List;

import com.ubosque.grupo4N.DAO.DuracionDAOInterface;
import com.ubosque.grupo4N.DAO.impl.DuracionDAOImp;
import com.ubosque.grupo4N.modelo.Duracion;

public class DuracionServicio {
	/**
	 * Variable interfaz que representara la fachada
	 * */
	DuracionDAOInterface durDAO;
	/**
	 * Constructor donde se instancia la interfaz quien se comportara como un implement
	 * */
	public DuracionServicio() {
		// TODO Auto-generated constructor stub
		durDAO = new DuracionDAOImp();
	}
	/**
	 * Metodo que llama al impl para crear una nueva duracion
	 * */
	public void crearDuracion(Duracion nuevaDuracion){
		durDAO.crearDuracion(nuevaDuracion);
	}
	/**
	 * Metodo que llama al impl para consultar una duracion
	 * */
	public List<Duracion> consultarDuracion (){
		return durDAO.consultarDuracion();
	}
	/**
	 * Metodo que llama al impl para actualizar una duracion
	 * */
	public void actualizarDuracion(Duracion viejaDuracion){
		durDAO.actualizarDuracion(viejaDuracion);
	}
	/**
	 * Metodo que llama al impl para consultar una duracion especifica
	 * */
	public List<Duracion> consultarDuracionEspecifica(){
		return durDAO.consultarDuracionEspecifica();
	}
	/**
	 * Metodo que llama al impl para eliminar una duracion
	 * */
	public void eliminarDuracion(Duracion viejaDuracion){
		durDAO.eliminarDuracion(viejaDuracion);
	}
	
}
