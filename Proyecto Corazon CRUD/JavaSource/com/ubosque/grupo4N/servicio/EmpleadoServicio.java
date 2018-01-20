package com.ubosque.grupo4N.servicio;


import java.util.Date;
import java.util.List;

import com.ubosque.grupo4N.DAO.EmpleadoDAOInterface;
import com.ubosque.grupo4N.DAO.impl.EmpleadoDAOImp;
import com.ubosque.grupo4N.modelo.Empleado;


public class EmpleadoServicio {
	/**
	 * Variable interfaz que representara la fachada
	 * */
	EmpleadoDAOInterface empDAO;
	/**
	 * Constructor donde se instancia la interfaz quien se comportara como un implement
	 * */
	public EmpleadoServicio() {
		// TODO Auto-generated constructor stub
		empDAO = new EmpleadoDAOImp();
	}
	/**
	 * Metodo que llama al impl para crear un nuevo empleado
	 * */
	public void crearEmpleado(Empleado nuevaEmpleado){
		empDAO.crearEmpleado(nuevaEmpleado);
	}
	/**
	 * Metodo que llama al impl para consultar un empleado
	 * */
	public List<Empleado> consultarEmpleado (){
		return empDAO.consultarEmpleado();
	}
	/**
	 * Metodo que llama al impl para actualizar un empleado
	 * */
	public void actualizarEmpleado(Empleado viejaEmpleado){
		empDAO.actualizarEmpleado(viejaEmpleado);
	}
	/**
	 * Metodo que llama al impl para consultar un empleado especificamente
	 * */
	public List<Empleado> consultarEmpleadoEspecifica(Empleado viejaEmpleado){
		return empDAO.consultarEmpleadoEspecifica(viejaEmpleado.getDocumentoEmpleado());
	}
	/**
	 * Metodo que llama al impl para eliminar un empleado
	 * */
	public void eliminarEmpleado(Empleado viejaEmpleado){
		empDAO.eliminarEmpleado(viejaEmpleado);
	}
	/**
	 * Metodo que llama al impl para consultar un empleado y su usuario
	 * */
	public List<Empleado> consultarEmpleadoUsuario(int documento){
		return empDAO.consultarEmpleadoEspecifica(documento);
	}
	/**
	 * Metodo que llama al impl para consultar un empleado por Id
	 * */
	public List<Empleado> consultarEmpleadoId(int id){
		return empDAO.consultarEmpleadoEspecificaId(id);
	}
	/**
	 * Metodo que llama al impl para consultar la disponbilidad de un empleado
	 * */
	public List<Empleado> consultarDisponibilidadEmpleado(Date fecha, String nombre){
		return empDAO.consultarDisponibilidadEmpleado(fecha,nombre);
	}
	
	

}
