package com.ubosque.grupo4N.DAO;

import java.util.List;

import com.ubosque.grupo4N.modelo.Especialidad;

public interface EspecialidadDAOInterface {
	/**
	 * Creación de la interface que trabaja como una fachada, y tiene todos los
	 * métodos que se van a implementar en Especialidad
	 */
	public void crearEspercialidad(Especialidad especialidadNuevo);//Metodo de crear especialidad
	
	public void actualizarEspecialidad(Especialidad especialidadAModificar);//Metodo de actualizar empleado
	
	public void eliminarEspecialidad(Especialidad especialidadAEliminar);//Metodo de eliminar empleado

	public List<Especialidad> consultarEspecialidad();//Metodo de consulta general
	
	public List<Especialidad> consultarEspecialidadEspecifica(String nombreEspecialidad1); //Metodo de consulta especifica por nombre
	
	public List consultarEspecialidadReportes();//Metodo de consulta para reportes
}
