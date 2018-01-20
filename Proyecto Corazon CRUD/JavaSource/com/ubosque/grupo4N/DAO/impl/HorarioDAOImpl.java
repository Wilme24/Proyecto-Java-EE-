package com.ubosque.grupo4N.DAO.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ubosque.grupo4N.DAO.HorarioDAOInterface;
import com.ubosque.grupo4N.bd.Utilidad;
import com.ubosque.grupo4N.modelo.Empleado;
import com.ubosque.grupo4N.modelo.Horario;

public class HorarioDAOImpl implements HorarioDAOInterface {
	/**
	 * Creación de la clase que implementa la interfaz HorarioDAOInterface
	 */

	/**
	 * Creación del método que permite la creación de horario
	 */
	@Override
	public void crearHorario(Horario horarioNuevo) {
		Transaction trns = null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.save(horarioNuevo);
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
	 * Creación del método que permite la actualización de autorizaciones
	 */
	@Override
	public void actualizarHorario(Horario horarioAModificar) {
		Transaction trns = null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.update(horarioAModificar);
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
	 * Creación del método que permite la eliminación de autorizaciones
	 */
	@Override
	public void eliminarHorario(Horario horarioAEliminar) {
		// TODO Auto-generated method stub
		Transaction trns = null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.update(horarioAEliminar);
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
	 * Creación del método que permite la consulta de autorizaciones
	 */
	@Override
	public List<Horario> consultarHorario() {
		List<Horario> horario = new ArrayList<Horario>();
		Transaction trns = null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			horario = session.createQuery("from Horario").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return horario;
	}

	@Override
	public List<Horario> consultarHorarioEspecifica(int doc) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
