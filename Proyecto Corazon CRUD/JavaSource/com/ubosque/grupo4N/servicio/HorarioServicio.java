package com.ubosque.grupo4N.servicio;

import java.util.List;

import com.ubosque.grupo4N.DAO.HorarioDAOInterface;
import com.ubosque.grupo4N.DAO.impl.HorarioDAOImpl;
import com.ubosque.grupo4N.modelo.Empleado;
import com.ubosque.grupo4N.modelo.Horario;

public class HorarioServicio {
	/**
	 * Variable interfaz que representara la fachada
	 * */
	HorarioDAOInterface horDAO;
	/**
	 * Constructor donde se instancia la interfaz quien se comportara como un implement
	 * */
	public HorarioServicio() {
		// TODO Auto-generated constructor stub
		horDAO = new HorarioDAOImpl();
	}
	/**
	 * Metodo que llama al impl para crear un nuevo Horario
	 * */
	public void crearEmpleado(Horario nuevoHorario){
		horDAO.crearHorario(nuevoHorario);
	}
	/**
	 * Metodo que llama al impl para consultar un Horario
	 * */
	public List<Horario> consultarHorario (){
		return horDAO.consultarHorario();
	}
	/**
	 * Metodo que llama al impl para actualizar un Horario
	 * */
	public void actualizarHorario(Horario viejoHorario){
		horDAO.actualizarHorario(viejoHorario);
	}
	
	/**
	 * Metodo que llama al impl para consultar un Horario especifico
	 * */
	public List<Horario> consultarHorarioEspecifica(int doc){
		return horDAO.consultarHorarioEspecifica(doc);
		
	}
	
	/**
	 * Metodo que llama al impl para eliminar un Horario
	 * */
	public void eliminarHorario(Horario viejoHorario){
		horDAO.eliminarHorario(viejoHorario);
	}
	/**
	 * Metodo que llama al impl para consultar un Horario por usuario
	 * */
	public List<Horario> consultarHorarioUsuario(int doc){
		return horDAO.consultarHorarioEspecifica(doc);
				
	}


}
