package com.ubosque.grupo4N.DAO.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ubosque.grupo4N.DAO.CitaDAOInterface;
import com.ubosque.grupo4N.bd.Utilidad;
import com.ubosque.grupo4N.modelo.Autorizacion;
import com.ubosque.grupo4N.modelo.Cita;
import com.ubosque.grupo4N.modelo.Duracion;
import com.ubosque.grupo4N.modelo.Empleado;

public class CitaDAOImp implements CitaDAOInterface {
	/**
	 * Creación de la clase que implementa la interfaz CitaDAOInterface
	 */
	/**
	 * Creación del método que permite la creación de citas
	 */
	@Override
	public void crearCita(Cita citaNueva) {
		// TODO Auto-generated method stub
		Transaction trns = null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.save(citaNueva);
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
	 * Creación del método que permite la actualización de citas
	 */
	@Override
	public void actualizarCita(Cita citaAModificar) {
		// TODO Auto-generated method stub
		Transaction trns = null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.update(citaAModificar);
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
	public void eliminarCita(Cita citaAEliminar) {
		// TODO Auto-generated method stub

	}

	/**
	 * Creación del método que permite la consulta de citas
	 */
	@Override
	public List<Cita> consultarcita() {
		List<Cita> duracion = new ArrayList<Cita>();
		Transaction trns = null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			duracion = session.createQuery("from Cita").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return duracion;
	}

	@Override
	public List<Cita> consultarcitaEspecifica(String nombrecita1) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Creación del método que permite la consulta de citas por id de autorización
	 */
	@Override
	public List<Cita> consultarcitaAutorizacion(int idAuto) {
		List<Cita> duracion = new ArrayList<Cita>();
		List<Autorizacion> autorizacion = new ArrayList<Autorizacion>();
		Transaction trns = null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			autorizacion = session.createQuery("Select auto from Autorizacion auto"
					+ " where auto.idAutorizacion =" + idAuto).list();
			Autorizacion autor= autorizacion.get(0);
			duracion = session.createQuery("Select ci from Cita ci, Autorizacion auto, Tiposervicio tipo"
					+ " where ci.tiposervicio.idTipoServicio = tipo.idTipoServicio "
					+ "and tipo.nombreTipoServicio='"+autor.getDescripcionAutorizacion()+"'"
					+ " and (ci.estadoCita = 'Activa' or ci.estadoCita = 'Cancelada') "
					+ "and ci.fechaCita <= '" + autor.getFechaExpedicionAutorizacion() + "' "
					+ " group by ci.idCita").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return duracion;
	}
	
	/**
	 * Creación del método que permite la consulta de citas por para generar reportes
	 */
	@Override
	public List consultarcitaReportesTipoSer() {
		Transaction trns = null;
		List lia=null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			lia = session.createQuery("Select COUNT(tipo.nombreTipoServicio), tipo.nombreTipoServicio from Cita ci, Tiposervicio tipo"
					+ " where ci.tiposervicio.idTipoServicio = tipo.idTipoServicio group by tipo.nombreTipoServicio").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return lia;
	}
	/**
	 * Creación del método que permite la consulta de citas por documento empleado
	 */
	@Override
	public List<Cita> consultarCitasEmpl(int documento) {
		Transaction trns = null;
		List<Cita> lia=new ArrayList<Cita>();
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			lia = session.createQuery("select ci from Cita ci, Autorizacion auto, Empleado emp, Paciente pac "
					+ "where auto.paciente.idPaciente = pac.idPaciente and "
					+ "ci.autorizacion.idAutorizacion = auto.idAutorizacion and "
					+ "ci.empleado.idEmpleado = emp.idEmpleado and "
					+ "emp.documentoEmpleado = " + documento).list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return lia;
	}
	/**
	 * Creación del método que permite la consulta de citas por documento paciente
	 */
	@Override
	public List<Cita> consultarCitasPac(int documento) {
		Transaction trns = null;
		List<Cita> lia=new ArrayList<Cita>();
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			lia = session.createQuery("select ci from Cita ci, Autorizacion auto, Empleado emp, Paciente pac "
					+ "where auto.paciente.idPaciente = pac.idPaciente and "
					+ "ci.autorizacion.idAutorizacion = auto.idAutorizacion and "
					+ "ci.empleado.idEmpleado = emp.idEmpleado and "
					+ "pac.documentoPaciente = " + documento).list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return lia;
	}
	
	/**
	 * Creación del método que permite la consulta de citas por para generar reportes por mes
	 */
	@Override
	public List consultarCitaReportesMensual() {
		Transaction trns = null;
		List lia=null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			lia = session.createQuery("Select COUNT(ci.fechaCita), month(ci.fechaCita) from Cita ci "
					+ " where ci.estadoCita = 'Ocupada' group by month(ci.fechaCita)  ").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return lia;
	}
	
	

}
