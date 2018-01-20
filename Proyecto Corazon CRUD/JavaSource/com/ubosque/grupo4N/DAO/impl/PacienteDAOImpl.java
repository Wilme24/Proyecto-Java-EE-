package com.ubosque.grupo4N.DAO.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ubosque.grupo4N.DAO.PacienteDAOInterface;
import com.ubosque.grupo4N.bd.Utilidad;
import com.ubosque.grupo4N.modelo.Especialidad;
import com.ubosque.grupo4N.modelo.Paciente;
import com.ubosque.grupo4N.modelo.Tiposervicio;

public class PacienteDAOImpl implements PacienteDAOInterface {
	/**
	 * Creaci�n de la clase que implementa la interfaz PacienteDAOInterface
	 */
	/**
	 * Creaci�n del m�todo que permite la creaci�n de pacientes
	 */
	@Override
	public void crearPaciente(Paciente pacienteNuevo) {
		Transaction trns = null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.save(pacienteNuevo);
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
	 * Creaci�n del m�todo que permite la actualizaci�n de pacientes
	 */
	@Override
	public void actualizarPaciente(Paciente pacientedAModificar) {
		Transaction trns = null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.update(pacientedAModificar);
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
	 * Creaci�n del m�todo que permite la creaci�n de pacientes
	 */
	@Override
	public List<Paciente> consultarPaciente() {
		List<Paciente> pacientes = new ArrayList<Paciente>();
		Transaction trns = null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			pacientes = session.createQuery("from Paciente").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return pacientes;
	}
	/**
	 * Creaci�n del m�todo que permite la consulta especifica de pacientes
	 */
	@Override
	public List<Paciente> consultarPacienteEspecifica(int documento) {
		// TODO Auto-generated method stub
		List<Paciente> paciente = new ArrayList<Paciente>();
		Transaction trns = null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			paciente = session.createQuery("from Paciente e where e.documentoPaciente like '%"	+ documento + "%'").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return paciente;
	}
	/**
	 * Creaci�n del m�todo que permite la consulta especifica de pacientes por nombre
	 */
	@Override
	public List<Paciente> consultarPacienteEspecifica(String nombrePaciente1) {
		// TODO Auto-generated method stub
		List<Paciente> paciente = new ArrayList<Paciente>();
		Transaction trns = null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			paciente = session.createQuery("from Paciente e where e.nombresPaciente like '%"	+ nombrePaciente1 + "%'").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return paciente;
	}

}
