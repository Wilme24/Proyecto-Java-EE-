package com.ubosque.grupo4N.servicio;

import java.util.List;

import com.ubosque.grupo4N.DAO.CitaDAOInterface;
import com.ubosque.grupo4N.DAO.impl.CitaDAOImp;
import com.ubosque.grupo4N.modelo.Cita;

public class CitaServicio {
	/**
	 * Creación de la interface que trabaja como una fachada, y tiene todos los
	 * métodos que se van a implementar en Autorización
	 */
	private CitaDAOInterface dao;
	/**
	 * Constructor donde se instancia la interfaz quien se comportara como un implement
	 * */
	public CitaServicio() {
		// TODO Auto-generated constructor stub
		dao = new CitaDAOImp(); 
	}
	/**
	 * Metodo que llama al impl para crear una nueva cita
	 * */
	public void crearCita(Cita nuevaCita){
		dao.crearCita(nuevaCita);
	}
	/**
	 * Metodo que llama al impl para actualizar una cita
	 * */
	public void actualizarCita(Cita viejaCita){
		dao.actualizarCita(viejaCita);
	}
	/**
	 * Metodo que llama al impl para consultar una cita
	 * */
	public List<Cita> consultarCita(){
		return dao.consultarcita();
	}
	/**
	 * Metodo que llama al impl para consultar una cita por autorizacion
	 * */
	public List<Cita> consultarCitaAtuo(int idAuto){
		return dao.consultarcitaAutorizacion(idAuto);
	}
	/**
	 * Metodo que llama al impl para consultar una cita para reportes
	 * */
	public List consultarCitaReportes(){
		return dao.consultarcitaReportesTipoSer();
	}
	/**
	 * Metodo que llama al impl para consultar una cita mensual
	 * */
	public List consultarCitaReportesMensual(){
		return dao.consultarCitaReportesMensual();
	}
	/**
	 * Metodo que llama al impl para consultar una cita por empleado
	 * */
	public List<Cita> consultarCitasEmpl(int documento) {
		return dao.consultarCitasEmpl(documento);
	}
	/**
	 * Metodo que llama al impl para consultar una cita por paciente
	 * */
	public List<Cita> consultarCitasPac(int documento) {
		return dao.consultarCitasPac(documento);
	}

}
