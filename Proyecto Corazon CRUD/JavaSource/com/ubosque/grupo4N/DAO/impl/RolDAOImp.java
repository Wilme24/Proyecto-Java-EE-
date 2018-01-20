package com.ubosque.grupo4N.DAO.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ubosque.grupo4N.DAO.RolDAOInterface;
import com.ubosque.grupo4N.bd.Utilidad;
import com.ubosque.grupo4N.modelo.Rol;

public class RolDAOImp implements RolDAOInterface{
	/**
	 * Creación de la clase que implementa la interfaz RolDAOInterface
	 */
	/**
	 * Creación del método que permite la creación de roles
	 */
	@Override
	public void crearRol(Rol rolNuevo) {
		Transaction trns = null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.save(rolNuevo);
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
	 * Creación del método que permite la actualizacion de roles
	 */
	@Override
	public void actualizarRol(Rol rolAModificar) {
		Transaction trns = null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.update(rolAModificar);
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
	public void eliminarRol(Rol rolAEliminar) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Creación del método que permite la consulta de roles
	 */
	@Override
	public List<Rol> consultarRol() {
		List<Rol> especialidad = new ArrayList<Rol>();
		Transaction trns = null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			especialidad = session.createQuery("from Rol").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return especialidad;
	}
	/**
	 * Creación del método que permite la consulta especifica de roles 
	 */
	@Override
	public List<Rol> consultarRolEspecifica(String nombreRol1) {
		List<Rol> especialidad = new ArrayList<Rol>();
		Transaction trns = null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			especialidad = session.createQuery("from Rol e where e.perfilRol like '%"+nombreRol1+"%'").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return especialidad;
	}

	

}
