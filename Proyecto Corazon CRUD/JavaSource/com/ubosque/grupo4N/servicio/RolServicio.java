package com.ubosque.grupo4N.servicio;

import java.util.List;

import com.ubosque.grupo4N.DAO.RolDAOInterface;
import com.ubosque.grupo4N.DAO.impl.RolDAOImp;
import com.ubosque.grupo4N.modelo.Rol;

public class RolServicio {
	/**
	 * Variable interfaz que representara la fachada
	 * */
	private RolDAOInterface rolDAO;
	/**
	 * Constructor donde se instancia la interfaz quien se comportara como un implement
	 * */
	public RolServicio() {
		rolDAO = new RolDAOImp();
	}
	/**
	 * Metodo que llama al impl para crear un nuevo rol
	 * */
	public void insertarRol(Rol nuevoRol){
		rolDAO.crearRol(nuevoRol);
	}
	/**
	 * Metodo que llama al impl para actualizar un rol
	 * */
	public void actualizarRol(Rol actualizarRol){
		rolDAO.actualizarRol(actualizarRol);
	}
	/**
	 * Metodo que llama al impl para consultar un rol
	 * */
	public List<Rol> consultarRol(){
		return rolDAO.consultarRol();
	}
	/**
	 * Metodo que llama al impl para actualizar un rol en especifico
	 * */
	public List<Rol> ConsultarRolEspecifico(Rol viejoRol){
		return rolDAO.consultarRolEspecifica(viejoRol.getPerfilRol());
	}

}
