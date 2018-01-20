package com.ubosque.grupo4N.servicio;

import java.util.List;

import com.ubosque.grupo4N.DAO.UsuarioDAOInterface;
import com.ubosque.grupo4N.DAO.impl.UsuarioDAOImp;
import com.ubosque.grupo4N.modelo.Cita;
import com.ubosque.grupo4N.modelo.Usuario;

public class UsuarioServicio {
	/**
	 * Variable interfaz que representara la fachada
	 * */
	private UsuarioDAOInterface usDAO;
	/**
	 * Constructor donde se instancia la interfaz quien se comportara como un implement
	 * */
	public UsuarioServicio() {
		// TODO Auto-generated constructor stub
		usDAO= new UsuarioDAOImp();
	}
	/**
	 * Metodo que llama al impl para crear un nuevo usuario
	 * */
	public void crearUsuario(Usuario nuevoUsuario){
		usDAO.crearUsuario(nuevoUsuario);
	}
	/**
	 * Metodo que llama al impl para actualizar un usuario
	 * */
	public void actualizarUsuario(Usuario viejoUsuario){
		usDAO.actualizarUsuario(viejoUsuario);
	}
	/**
	 * Metodo que llama al impl para loguear al usuario
	 * */
	public List<Usuario> login(){
		return usDAO.consultarUsuario();
	}
	/**
	 * Metodo que llama al impl para consultar un usuario
	 * */
	public List<Usuario> consultarUsuario(){

		return usDAO.consultarUsuario();
	}
	/**
	 * Metodo que llama al impl para consultar un  usuario especifico
	 * */
	public List<Usuario> consultarUsuarioEspecifica(){
		return usDAO.consultarUsuarioEspecifica();
	}
	/**
	 * Metodo que llama al impl para consultar un usuario por Id
	 * */
	public List<Usuario> consultarUsuarioEspecificaID(int idUsuario){
		return usDAO.consultarUsuarioEspecificaID(idUsuario);
	}
	/**
	 * Metodo que llama al impl para consultar un usuario por nombre de usuario
	 * */
	public List<Usuario> consultarUsuarioUsu(String usuario){
		return usDAO.consultarUsuarioU(usuario);
	}
	
	
}
