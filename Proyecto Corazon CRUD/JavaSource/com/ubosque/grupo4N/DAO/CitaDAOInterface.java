package com.ubosque.grupo4N.DAO;

import java.util.List;

import com.ubosque.grupo4N.modelo.Cita;

public interface CitaDAOInterface {
	/**
	 * Creación de la interface que trabaja como una fachada, y tiene todos los
	 * métodos que se van a implementar en cita
	 */
	public void crearCita(Cita citaNueva);//Método de crear cita
	
	public void actualizarCita(Cita citaAModificar);//Método de modificar cita
	
	public void eliminarCita(Cita citaAEliminar);//Método de eliminar cita
	
	public List<Cita> consultarcita();//Método de consultar cita
	
	public List<Cita> consultarcitaEspecifica(String nombrecita1);//Método de consultar cita por nombre
	
	public List<Cita> consultarcitaAutorizacion(int idAuto);//Método de consultar por id
	
	public List consultarcitaReportesTipoSer();//Método de reportes
	
	public List<Cita> consultarCitasEmpl(int documento);//Método de consultar citas de los empleados
	
	public List<Cita> consultarCitasPac(int documento);//Método de consultar citas de los pacientes
	
	public List consultarCitaReportesMensual();//Método de consultar citas de los pacientes
}
