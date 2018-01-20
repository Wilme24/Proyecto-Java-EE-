package com.ubosque.grupo4N.DAO;

import java.util.List;
import com.ubosque.grupo4N.modelo.Paciente;

public interface PacienteDAOInterface {
	/**
	 * Creación de la interface que trabaja como una fachada, y tiene todos los
	 * métodos que se van a implementar en Paciente
	 */
	public void crearPaciente(Paciente pacienteNuevo);//Metodo de crear paciente
	
	public void actualizarPaciente(Paciente pacientedAModificar);//Metodo de actualizar paciente
	
	public List<Paciente> consultarPaciente();//Metodo de consulta general paciente
	
	public List<Paciente> consultarPacienteEspecifica(int documento);//Metodo de consulta especifica por documento
	
	public List<Paciente> consultarPacienteEspecifica(String nombrePaciente1);//Metodo de consulta por nombre paciente
}
