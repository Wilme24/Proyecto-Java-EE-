package com.ubosque.grupo4N.servicio;

import java.util.List;

import com.ubosque.grupo4N.DAO.PacienteDAOInterface;
import com.ubosque.grupo4N.DAO.impl.PacienteDAOImpl;
import com.ubosque.grupo4N.modelo.Paciente;

public class PacienteServicio {

	/**
	 * Variable interfaz que representara la fachada
	 * */
	private PacienteDAOInterface pacDAO;
	/**
	 * Constructor donde se instancia la interfaz quien se comportara como un implement
	 * */
	public PacienteServicio() {
		// TODO Auto-generated constructor stub
		pacDAO = new PacienteDAOImpl();
	}
	/**
	 * Metodo que llama al impl para crear un nuevo Paciente
	 * */
	public void crearPaciente(Paciente nuevoPaciente){
		pacDAO.crearPaciente(nuevoPaciente);
	}
	/**
	 * Metodo que llama al impl para actualizar un Paciente
	 * */
	public void actualizarPaciente(Paciente pacienteaModificar){
		pacDAO.actualizarPaciente(pacienteaModificar);
	}
	/**
	 * Metodo que llama al impl para consultar un Paciente
	 * */
	public List<Paciente> consultarPaciente(){
		return pacDAO.consultarPaciente();
	}
	/**
	 * Metodo que llama al impl para consultar un Paciente especifico
	 * */
	public List<Paciente> consultarPacienteEspecifica(Paciente viejaPaciente){
		return pacDAO.consultarPacienteEspecifica(viejaPaciente.getDocumentoPaciente());
	}
	/**
	 * Metodo que llama al impl para consultar un Paciente por documento
	 * */
	public List<Paciente> consultarPacienteEspecifica(int documento){
		return pacDAO.consultarPacienteEspecifica(documento);
	}
}
