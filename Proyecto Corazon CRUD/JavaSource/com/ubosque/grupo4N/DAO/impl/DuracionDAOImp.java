package com.ubosque.grupo4N.DAO.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ubosque.grupo4N.DAO.DuracionDAOInterface;
import com.ubosque.grupo4N.bd.Utilidad;
import com.ubosque.grupo4N.modelo.Duracion;

public class DuracionDAOImp implements DuracionDAOInterface {
	
	/**
	 * Creación de la clase que implementa la interfaz DuracionDAOInterface
	 */
	/**
	 * Creación del método que permite la creación de duraciones
	 */
	@Override
	public void crearDuracion(Duracion duracionNuevo) {
		// TODO Auto-generated method stub
		Transaction trns = null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.save(duracionNuevo);
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
	 * Creación del método que permite la actualizacion de duraciones
	 */
	@Override
	public void actualizarDuracion(Duracion duracionAModificar) {
		// TODO Auto-generated method stub
		Transaction trns = null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.update(duracionAModificar);
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
	public void eliminarDuracion(Duracion duracionAEliminar) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Creación del método que permite la consulta de duraciones
	 */
	@Override
	public List<Duracion> consultarDuracion() {
		// TODO Auto-generated method stub
		List<Duracion> duracion = new ArrayList<Duracion>();
		Transaction trns = null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			duracion = session.createQuery("from Duracion").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return duracion;
	}
	/**
	 * Creación del método que permite la consulta y las ordena por id de forma descendente
	 */
	@Override
	public List<Duracion> consultarDuracionEspecifica() {
		List<Duracion> especialidad = new ArrayList<Duracion>();
		Transaction trns = null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			especialidad = session.createQuery("from Duracion ORDER BY idDuracion DESC").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return especialidad;
	}


}
