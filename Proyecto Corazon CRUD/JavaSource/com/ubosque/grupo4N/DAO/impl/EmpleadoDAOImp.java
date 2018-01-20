package com.ubosque.grupo4N.DAO.impl;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ubosque.grupo4N.DAO.EmpleadoDAOInterface;
import com.ubosque.grupo4N.bd.Utilidad;
import com.ubosque.grupo4N.modelo.Duracion;
import com.ubosque.grupo4N.modelo.Empleado;
import com.ubosque.grupo4N.modelo.Especialidad;

public class EmpleadoDAOImp implements EmpleadoDAOInterface {
	/**
	 * Creación de la clase que implementa la interfaz DuracionDAOInterface
	 */
	/**
	 * Creación del método que permite la creación de empleados
	 */
	@Override
	public void crearEmpleado(Empleado empleadoNuevo) {
		// TODO Auto-generated method stub
		Transaction trns = null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.save(empleadoNuevo);
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
	 * Creación del método que permite la actualización de empleados
	 */
	@Override
	public void actualizarEmpleado(Empleado empleadoAModificar) {
		// TODO Auto-generated method stub
				Transaction trns = null;
				Session session = Utilidad.getSessionFactory().openSession();
				try {
					trns = session.beginTransaction();
					session.update(empleadoAModificar);
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
	 * Creación del método que permite la eliminación de empleados
	 */
	@Override
	public void eliminarEmpleado(Empleado empleadoAEliminar) {
		// TODO Auto-generated method stub
				Transaction trns = null;
				Session session = Utilidad.getSessionFactory().openSession();
				try {
					trns = session.beginTransaction();
					session.update(empleadoAEliminar);
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
	 * Creación del método que permite la consulta de empleados
	 */
	@Override
	public List<Empleado> consultarEmpleado() {
		List<Empleado> empleado = new ArrayList<Empleado>();
		Transaction trns = null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			empleado = session.createQuery("from Empleado where estado=1").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return empleado;
	}
	/**
	 * Creación del método que permite la consulta específica de empleados por documento
	 */
	@Override
	public List<Empleado> consultarEmpleadoEspecifica(int documento) {
		List<Empleado> empleado = new ArrayList<Empleado>();
		Transaction trns = null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			empleado = session.createQuery("from Empleado where documentoEmpleado like '%"+documento+"%' and estado=1").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return empleado;
	}
	/**
	 * Creación del método que permite la consulta especifica de empleados
	 */
	@Override
	public List<Empleado> consultarDisponibilidadEmpleado(Date fecha, String nombre) {
		String hora = fecha.getHours() + ":"+fecha.getMinutes() + "";
		SimpleDateFormat formateador = new SimpleDateFormat("yyyy/MM/dd");
		String solofecha = formateador.format(fecha);
		List<Empleado> empleado = new ArrayList<Empleado>();
		Transaction trns = null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			empleado = session.createQuery("Select emp from Empleado emp, Horario hor, Especialidad es"
					+ " where hor.empleado.idEmpleado = emp.idEmpleado "
					+ " and emp.especialidad.idEspecialidad = es.idEspecialidad "
					+ " and es.nombreEspecialidad='"+ nombre+"'"
					+ " and hor.fechaInicialHorario <= '"+solofecha+ "'"
					+ " and hor.fechaFinalHorario >= '"+solofecha+ "'"
					+ " and hor.horaInicialHorario <= '"+hora+ "'"
					+ " and hor.horaFinalHorario >= '"+hora+ "'" ).list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return empleado;
	}
	/**
	 * Creación del método que permite la consulta especifica de empleados por id
	 */
	@Override
	public List<Empleado> consultarEmpleadoEspecificaId(int id) {
		List<Empleado> empleado = new ArrayList<Empleado>();
		Transaction trns = null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			empleado = session.createQuery("from Empleado where idEmpleado = "+id+" and estado=1").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return empleado;
	}
}
