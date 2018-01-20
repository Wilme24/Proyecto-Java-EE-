package com.ubosque.grupo4N.DAO.impl;


import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;



import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.mapping.Map;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;

import com.ubosque.grupo4N.DAO.AutorizacionDAOInterface;
import com.ubosque.grupo4N.bd.Utilidad;
import com.ubosque.grupo4N.modelo.Autorizacion;
import com.ubosque.grupo4N.modelo.Cita;

import sun.security.jca.GetInstance;

public class AutorizacionesDAOImpl implements AutorizacionDAOInterface {
	/**
	 * Creación de la clase que implementa la interfaz AutorizacionDAOInterface
	 */
	private Date date;
	@Override
	/**
	 * Creación del método que permite la creación de autorizaciones
	 */
	public void crearAutorizacion(Autorizacion AutorizacionNuevo) {
		Transaction trns = null;//Transaccion vacia
		Session session = Utilidad.getSessionFactory().openSession(); //Obtener sesion de la fabrica de sesion
		try {
			trns = session.beginTransaction();//Empezar transaccion
			session.save(AutorizacionNuevo);//Insercion en la base de datos
			session.getTransaction().commit();//Realizar todas las transacciones
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();//Rollback para evitar inserciones mal
			}
			e.printStackTrace();
		} finally {

			session.close();//Cierre de conexion
		}

	}
	@Override
	/**
	 * Creación del método que permite la actualización de autorizaciones
	 */
	public void actualizarAutorizacion(Autorizacion autorizacionAModificar) {
		// TODO Auto-generated method stub
		Transaction trns = null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.update(autorizacionAModificar);//Actualizacion een la base de datos
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
	/**
	 * Creación del método que permite la eliminación de autorizaciones
	 */
	public void eliminarAutorizacion(Autorizacion autorizacionAEliminar) {
		// TODO Auto-generated method stub
		Transaction trns = null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.remove(autorizacionAEliminar);//Eliminacion de las base de datos
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
	/**
	 * Creación del método que permite la consulta general de autorizaciones
	 */
	public List<Autorizacion> consultarAutorizacion() {
		List<Autorizacion> autorizacion = new ArrayList<Autorizacion>();//Arraylist donde se guardara la consulta
		Transaction trns = null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			autorizacion = session.createQuery("from Autorizacion").list();//Consulta en la base de datos
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return autorizacion;
	}
	@Override
	/**
	 * Creación del método que permite la consulta especifica de autorizaciones por nombre
	 */
	public List<Autorizacion> consultarAutorizacionEspecifica(String nombreAutorizacion1) {
		// TODO Auto-generated method stub
		List<Autorizacion> autorizacion = new ArrayList<Autorizacion>();
		Transaction trns = null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			autorizacion = session.createQuery("from Autorizacion e where e.nitAutorizacion like '%"+nombreAutorizacion1+"%' ").list();
			//Consulta con el nit que concuerde con el enviado.
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return autorizacion;

	}
	@Override
	/**
	 * Creación del método que permite la consulta de autorizaciones por documento
	 */
	public List<Autorizacion> consultarAutorizacionEspecifica1(int documento) {
		// TODO Auto-generated method stub
		date = new Date(System.currentTimeMillis());//Obtener la fecha actual
		SimpleDateFormat formateador = new SimpleDateFormat("yyyy/MM/dd");//Establecer formato de la fecha
		String solofecha = formateador.format(date);//Formatear la fecha actual
		
		List<Autorizacion> autorizacion = new ArrayList<Autorizacion>();
		Transaction trns = null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			autorizacion = session.createQuery("Select auto from Autorizacion auto , Paciente pac"
					+ " where pac.idPaciente = auto.paciente.idPaciente "
					+ "and pac.documentoPaciente =" + documento+" and auto.fechaExpedicionAutorizacion > '"+solofecha + "'"
					+ "and auto.estado= 'Libre' group by auto.idAutorizacion " ).list();
			//Consulta multitabla donde busca el documento del paciente y que la fecha de expedicion sea mayor y su de la autorizacion sea libre
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return autorizacion;
	}
	@Override
	/**
	 * Creación del método que permite la consulta de autorizaciones por id
	 */
	public List<Autorizacion> consultarAutorizacionPorId(int idAutorizacion) {
		List<Autorizacion> autorizacion = new ArrayList<Autorizacion>();
		Transaction trns = null;
		Session session = Utilidad.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			autorizacion = session.createQuery("from Autorizacion where idAutorizacion =" + idAutorizacion).list();
			//Consulta de una autorizacion por medio del ID
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return autorizacion;
	}

	
}
