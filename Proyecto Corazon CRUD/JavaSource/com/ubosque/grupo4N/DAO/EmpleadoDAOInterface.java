package com.ubosque.grupo4N.DAO;


import java.util.Date;
import java.util.List;

import com.ubosque.grupo4N.modelo.Empleado;

public interface EmpleadoDAOInterface {
	
public void crearEmpleado(Empleado empleadoNuevo);//Metodo de crear empleado
	/**
	 * Creación de la interface que trabaja como una fachada, y tiene todos los
	 * métodos que se van a implementar en Empleado
	 */
	public void actualizarEmpleado(Empleado empleadoAModificar);//Metodo de modificar empleado
	
	public void eliminarEmpleado(Empleado empleadoAEliminar);//Metodo de eliminar empleado

	public List<Empleado> consultarEmpleado();//Metodo de consultar empleado
	
	public List<Empleado> consultarEmpleadoEspecifica(int documento);//Metodo de consultar empleado por id
	
	public List<Empleado> consultarEmpleadoEspecificaId(int id);//Metodo de consultar empleado
	
	public List<Empleado> consultarDisponibilidadEmpleado(Date fecha, String nombre);//Metodo de consiltar empleado
}
