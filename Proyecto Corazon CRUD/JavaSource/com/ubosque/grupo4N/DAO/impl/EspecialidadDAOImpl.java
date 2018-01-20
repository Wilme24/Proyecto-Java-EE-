package com.ubosque.grupo4N.DAO.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ubosque.grupo4N.DAO.EspecialidadDAOInterface;
import com.ubosque.grupo4N.bd.Utilidad;
import com.ubosque.grupo4N.modelo.Especialidad;

public class EspecialidadDAOImpl implements EspecialidadDAOInterface {
	/**
	 * Creación de la clase que implementa la interfaz EspecialidadDAOInterface
	 */
	/**
	 * Creación del método que permite la creación de especialidades
	 */
	@Override
	public void crearEspercialidad(Especialidad especialidadNuevo) {
		Transaction trns = null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.save(especialidadNuevo);
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
	 * Creación del método que permite la acutalización de especialidades
	 */
	@Override
	public void actualizarEspecialidad(Especialidad espercialidadAModificar) {
		// TODO Auto-generated method stub
		Transaction trns = null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.update(espercialidadAModificar);
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
	 * Creación del método que permite la eliminación de especialidades
	 */
	@Override
	public void eliminarEspecialidad(Especialidad especialidadAEliminar) {
		// TODO Auto-generated method stub
		Transaction trns = null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.update(especialidadAEliminar);
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
	 * Creación del método que permite la consulta de especialidades
	 */
	@Override
	public List<Especialidad> consultarEspecialidad() {
		List<Especialidad> especialidad = new ArrayList<Especialidad>();
		Transaction trns = null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			especialidad = session.createQuery("from Especialidad where estado=1").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return especialidad;
	}
	/**
	 * Creación del método que permite la consulta especifica de especialidades por nombre
	 */
	@Override
	public List<Especialidad> consultarEspecialidadEspecifica(String nombreEspecialidad1) {
		// TODO Auto-generated method stub
		List<Especialidad> especialidad = new ArrayList<Especialidad>();
		Transaction trns = null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			especialidad = session.createQuery("from Especialidad e where e.nombreEspecialidad like '%"+nombreEspecialidad1+"%' and estado=1").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return especialidad;

	}
	/**
	 * Creación del método que permite la consulta de especifica de especialidades para reportes
	 */
	@Override
	public List consultarEspecialidadReportes() {
		Transaction trns = null;
		List lia=null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			lia = session.createQuery("Select COUNT(es.nombreEspecialidad), es.nombreEspecialidad from Especialidad es, Empleado em"
					+ " where es.idEspecialidad = em.especialidad.idEspecialidad group by es.nombreEspecialidad").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return lia;
	}

}
