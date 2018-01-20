package com.ubosque.grupo4N.DAO;

import java.util.List;

import com.ubosque.grupo4N.modelo.Autorizacion;

public interface AutorizacionDAOInterface {
	/**
	 * Creaci�n de la interface que trabaja como una fachada, y tiene todos los
	 * m�todos que se van a implementar en Autorizaci�n
	 */
	public void crearAutorizacion(Autorizacion AutorizacionNuevo);//Metodo de interfaz para crear Autorizacion
	
	public void actualizarAutorizacion(Autorizacion autorizacionAModificar);//Metodo para actualizar la Autorizacion
	
	public void eliminarAutorizacion(Autorizacion autorizacionAEliminar);//Metodo para eliminar la Autorizacion

	public List<Autorizacion> consultarAutorizacion();//Consulta general de Autorizacion
	
	public List<Autorizacion> consultarAutorizacionEspecifica(String nombreAutorizacion1);//Consultar autorizacion por el nombre
	
	public List<Autorizacion> consultarAutorizacionEspecifica1(int documento);//Consulta especifica por documento paciente
	
	public List<Autorizacion> consultarAutorizacionPorId(int idAutorizacion);//Consulta especifica por id de autorizacion
	
}
