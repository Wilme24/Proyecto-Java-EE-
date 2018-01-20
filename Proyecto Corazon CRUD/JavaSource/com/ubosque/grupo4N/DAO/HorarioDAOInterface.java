package com.ubosque.grupo4N.DAO;

import java.util.List;

import com.ubosque.grupo4N.modelo.Horario;

public interface HorarioDAOInterface {
	/**
	 * Creación de la interface que trabaja como una fachada, y tiene todos los
	 * métodos que se van a implementar en Horario
	 */
	public void crearHorario(Horario horarioNuevo);//Metodo de crear horario
	
	public void actualizarHorario(Horario horarioAModificar);//Metodo de actualizar horario
	
	public void eliminarHorario(Horario horarioAEliminar);//Metodo de eliminar empleado
	
	public List<Horario> consultarHorario();//Metodo de consulta general horario
	
	public List<Horario> consultarHorarioEspecifica(int doc);//Metodo de horario por id
}
