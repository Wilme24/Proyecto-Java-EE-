package com.ubosque.grupo4N.DAO.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ubosque.grupo4N.DAO.UsuarioDAOInterface;
import com.ubosque.grupo4N.bd.Utilidad;
import com.ubosque.grupo4N.modelo.Duracion;
import com.ubosque.grupo4N.modelo.Especialidad;
import com.ubosque.grupo4N.modelo.Usuario;
public class UsuarioDAOImp implements UsuarioDAOInterface{
	/**
	 * Creación de la clase que implementa la interfaz AutorizacionDAOInterface
	 */

	/**
	 * Creación del método que permite la creación de usuarios
	 */
	@Override
	public void crearUsuario(Usuario usuarioNuevo) {
		// TODO Auto-generated method stub
		Transaction trns = null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.save(usuarioNuevo);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
		} finally {

			session.close();
		}
	}
	/**
	 * Creación del método que permite la actualización de usuarios
	 */
	@Override
	public void actualizarUsuario(Usuario usuarioAModificar) {
		// TODO Auto-generated method stub
		Transaction trns = null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.update(usuarioAModificar);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void eliminarUsuario(Usuario usuarioAEliminar) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Creación del método que permite la consulta de usuarios
	 */
	@Override
	public List<Usuario> consultarUsuario() {
		// TODO Auto-generated method stub
		List<Usuario> usuario = new ArrayList<Usuario>();
		Transaction trns = null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			usuario = session.createQuery("Select usu from Usuario usu, Rol role"
					+" where usu.rol.idRol = role.idRol ").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return usuario;
	}
	/**
	 * Creación del método que permite la consulta de usuarios y ordena por id de forma descendente
	 */
	@Override
	public List<Usuario> consultarUsuarioEspecifica() {
		List<Usuario> usuario = new ArrayList<Usuario>();
		Transaction trns = null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			usuario = session.createQuery("from Usuario ORDER BY idUsuario DESC").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return usuario;
	}
	/**
	 * Creación del método que permite la consulta de usuarios por id
	 */
	@Override
	public List<Usuario> consultarUsuarioEspecificaID(int idUsuario) {
		List<Usuario> usuario = new ArrayList<Usuario>();
		Transaction trns = null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			usuario = session.createQuery("from Usuario where idUsuario=" + idUsuario).list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return usuario;
	}
	/**
	 * Creación del método que permite la consulta de usuarios por usuario
	 */
	@Override
	public List<Usuario> consultarUsuarioU(String usuarioconsultar) {
		List<Usuario> usuario = new ArrayList<Usuario>();
		Transaction trns = null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			usuario = session.createQuery("from Usuario where usuario like '%"+usuarioconsultar+"%'").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return usuario;
	}
	
}
