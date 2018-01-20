package com.ubosque.grupo4N.DAO;

import java.util.List;

import com.ubosque.grupo4N.modelo.Tiposervicio;

public interface TipoServicioDAOInterface {
	/**
	 * Creación de la interface que trabaja como una fachada, y tiene todos los
	 * métodos que se van a implementar en Tipo de servicio
	 */
	public void crearTipoServicio(Tiposervicio tipoServicioNuevo);//Metodo de crear tipo servicio
	
	public void actualizarTipoServicio(Tiposervicio tipoServicioAModificar);//Metodo de actualizar Tipo servicio
	
	public void eliminarTipoServicio(Tiposervicio tipoServicioAEliminar);//Metodo de eliminar Tipo Servicio
	
	public List<Tiposervicio> consultarTipoServicio();//Metodo de consultar Tipo servicio 
	
	public List<Tiposervicio> consultarTipoServicioEspecifica(String nombreTipoServicio1); //Metodo de consultar Tipo por nombre
}