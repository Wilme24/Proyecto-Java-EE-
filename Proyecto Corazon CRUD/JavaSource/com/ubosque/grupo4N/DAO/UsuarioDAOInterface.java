package com.ubosque.grupo4N.DAO;

import java.util.List;

import com.ubosque.grupo4N.modelo.Usuario;

public interface UsuarioDAOInterface {
	/**
	 * Creación de la interface que trabaja como una fachada, y tiene todos los
	 * métodos que se van a implementar en Usuario
	 */
	public void crearUsuario(Usuario usuarioNuevo);//Metodo de crear usuario
	
	public void actualizarUsuario(Usuario usuarioAModificar);//Metodo de actualizar usuario
	
	public void eliminarUsuario(Usuario usuarioAEliminar);//Metodo de eliminar usuario
	
	public List<Usuario> consultarUsuario(); //Metodo de consulta general
	
	public List<Usuario> consultarUsuarioEspecifica();//Metodo de consulta usuario especifico
	
	public List<Usuario> consultarUsuarioEspecificaID(int idUsuario);//Metodo de consulta por ID
	
	public List<Usuario> consultarUsuarioU(String usuario);//Metodo de consulta por usuario
}
