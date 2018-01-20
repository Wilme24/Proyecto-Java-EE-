package com.ubosque.grupo4N.DAO;

import java.util.List;

import com.ubosque.grupo4N.modelo.Rol;

public interface RolDAOInterface {
	/**
	 * Creación de la interface que trabaja como una fachada, y tiene todos los
	 * métodos que se van a implementar en Rol
	 */
	public void crearRol(Rol rolAInsertar);//Metodo de crear rol
	
	public void actualizarRol(Rol rolAModificar);//Metodo de actualizar rol
	
	public void eliminarRol(Rol rolAEliminar);//Metodo de eliminar rol
	
	public List<Rol> consultarRol();//Metodo de consultar general rol
	
	public List<Rol> consultarRolEspecifica(String nombreRol1);//Metodo de consultar rol por nombre
}
