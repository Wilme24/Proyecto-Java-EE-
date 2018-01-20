package com.ubosque.grupo4N.servicio;

import java.util.List;

import com.ubosque.grupo4N.DAO.TipoServicioDAOInterface;
import com.ubosque.grupo4N.DAO.impl.TipoServicioDAOImp;
import com.ubosque.grupo4N.modelo.Tiposervicio;

public class TipoServicioServicio {
	/**
	 * Variable interfaz que representara la fachada
	 * */
	TipoServicioDAOInterface desDAO;
	/**
	 * Constructor donde se instancia la interfaz quien se comportara como un implement
	 * */
	public TipoServicioServicio() {
		// TODO Auto-generated constructor stub
		desDAO = new TipoServicioDAOImp();
	}
	/**
	 * Metodo que llama al impl para crear una nuevo tipo de servicio
	 * */
	public void crearTiposervicio(Tiposervicio nuevaTiposervicio){
		desDAO.crearTipoServicio(nuevaTiposervicio);
	}
	/**
	 * Metodo que llama al impl para consultar una tipo de servicio
	 * */
	public List<Tiposervicio> consultarTiposervicio (){
		return desDAO.consultarTipoServicio();
	}
	/**
	 * Metodo que llama al impl para actualizar una tipo de servicio
	 * */
	public void actualizarTiposervicio(Tiposervicio viejaEspecialidad){
		desDAO.actualizarTipoServicio(viejaEspecialidad);
	}
	/**
	 * Metodo que llama al impl para consultar una tipo de servicio especifico
	 * */
	public List<Tiposervicio> consultarTiposervicioEspecifica(String nombreTipoServicio){
		return desDAO.consultarTipoServicioEspecifica(nombreTipoServicio);
	}
	/**
	 * Metodo que llama al impl para eliminar una tipo de servicio
	 * */
	public void eliminarEspecialidad(Tiposervicio viejaEspecialidad){
		//desDAO.eliminarEspecialidad(viejaEspecialidad);
	}

}
