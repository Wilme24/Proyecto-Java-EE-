package com.ubosque.grupo4N.DAO.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ubosque.grupo4N.DAO.TipoServicioDAOInterface;
import com.ubosque.grupo4N.bd.Utilidad;
import com.ubosque.grupo4N.modelo.Especialidad;
import com.ubosque.grupo4N.modelo.Tiposervicio;

public class TipoServicioDAOImp implements TipoServicioDAOInterface{
	/**
	 * Creación de la clase que implementa la interfaz TipoServicioDAOInterface
	 */
	/**
	 * Creación del método que permite la creación de tipos de servicio
	 */
	@Override
	public void crearTipoServicio(Tiposervicio tipoServicioNuevo) {
		// TODO Auto-generated method stub
		Transaction trns = null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.save(tipoServicioNuevo);
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
	 * Creación del método que permite la actualizacion de tipos de servicio
	 */
	@Override
	public void actualizarTipoServicio(Tiposervicio tipoServicioAModificar) {
		// TODO Auto-generated method stub
		Transaction trns = null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.update(tipoServicioAModificar);
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
	public void eliminarTipoServicio(Tiposervicio tipoServicioAEliminar) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Creación del método que permite la consulta de tipos de servicio
	 */
	@Override
	public List<Tiposervicio> consultarTipoServicio() {
		// TODO Auto-generated method stub
		List<Tiposervicio> tipoServicio = new ArrayList<Tiposervicio>();
		Transaction trns = null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			tipoServicio = session.createQuery("from Tiposervicio").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return tipoServicio;
	}
	/**
	 * Creación del método que permite la consulta de tipos de servicio por nombre
	 */
	@Override
	public List<Tiposervicio> consultarTipoServicioEspecifica(String nombreTipoServicio1) {
		List<Tiposervicio> empleado = new ArrayList<Tiposervicio>();
		Transaction trns = null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			empleado = session.createQuery("from Tiposervicio where nombreTipoServicio like '%"+nombreTipoServicio1+"%'").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return empleado;
	}


}
