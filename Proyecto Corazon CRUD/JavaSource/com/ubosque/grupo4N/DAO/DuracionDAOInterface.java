package com.ubosque.grupo4N.DAO;

import java.util.List;

import com.ubosque.grupo4N.modelo.Duracion;

public interface DuracionDAOInterface {
	/**
	 * Creaci�n de la interface que trabaja como una fachada, y tiene todos los
	 * m�todos que se van a implementar en Duraci�n
	 */
	public void crearDuracion(Duracion duracionNuevo);//Metodo para crear una duracion
	
	public void actualizarDuracion(Duracion duracionAModificar);//Metodo para actualizar una duracion
	
	public void eliminarDuracion(Duracion duracionAEliminar);//Metodo para eliminar una duracion
	
	public List<Duracion> consultarDuracion();//Consulta general duracion
	
	public List<Duracion> consultarDuracionEspecifica();//Consulta especifica de las duraciones
}
