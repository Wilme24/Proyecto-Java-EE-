package com.ubosque.grupo4N.bd;

import org.hibernate.SessionFactory;//Libreria de la fabrica de sesiones
import org.hibernate.cfg.Configuration;//Librer�a para la configuraci�n

public class Utilidad {

	/**
	 * Clase utilidad que permite hacer la conexi�n a la base de datos
	 * por medio del hibernate.cfg.xml que es el que tiene toda la informaci�n
	 * para poder acceder a mysql.
	 */
    private static final SessionFactory sessionFactory = buildSessionFactory();//Creaci�n e instanciaci�n de la fabrica de sesiones

    private static SessionFactory buildSessionFactory() {//M�todo est�tico 
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure("com/ubosque/grupo4N/bd/hibernate.cfg.xml").buildSessionFactory();//Crea la fabrica de sesiones de la configuracion de hibernate
        } catch (Throwable ex) {//Excepcion
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);//Imprime la excepci�n
            throw new ExceptionInInitializerError(ex);//Lanza una excepci�n
        }
    }

    public static SessionFactory getSessionFactory() {//M�todo de retornar la fabrica de sesiones
        return sessionFactory;//retorna
    }
}