package com.ubosque.grupo4N.DAO;

import java.util.List;

import com.ubosque.grupo4N.modelo.Cita;

public interface CitaDAOInterface {
	/**
	 * Creaci�n de la interface que trabaja como una fachada, y tiene todos los
	 * m�todos que se van a implementar en cita
	 */
	public void crearCita(Cita citaNueva);//M�todo de crear cita
	
	public void actualizarCita(Cita citaAModificar);//M�todo de modificar cita
	
	public void eliminarCita(Cita citaAEliminar);//M�todo de eliminar cita
	
	public List<Cita> consultarcita();//M�todo de consultar cita
	
	public List<Cita> consultarcitaEspecifica(String nombrecita1);//M�todo de consultar cita por nombre
	
	public List<Cita> consultarcitaAutorizacion(int idAuto);//M�todo de consultar por id
	
	public List consultarcitaReportesTipoSer();//M�todo de reportes
	
	public List<Cita> consultarCitasEmpl(int documento);//M�todo de consultar citas de los empleados
	
	public List<Cita> consultarCitasPac(int documento);//M�todo de consultar citas de los pacientes
	
	public List consultarCitaReportesMensual();//M�todo de consultar citas de los pacientes
}
