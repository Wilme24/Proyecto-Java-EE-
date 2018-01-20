package com.ubosque.grupo4N.mb;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ubosque.grupo4N.modelo.Usuario;

public class SessionUtils {
	
	/**
	 * Creacion de variable para tomarla desde cualquier punto
	 * */
	public static Usuario q;
	
	/**
	 * Metodo para obtener la session actual
	 * */
	public static HttpSession getSession(){
		return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	}
	/**
	 * Metodo para obtener el Request actual
	 * */
	public static HttpServletRequest getRequest(){
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}
	/**
	 * Metodo para obtener la variable de session
	 * */
	public static void nombre(HttpSession hs){
	    q = (Usuario)hs.getAttribute("usuario");

	}
	/**
	 * Metodo para establecer la variable de session
	 * */
	public static void usuario(HttpSession hs, Usuario usuarioLogeo){
		hs.setAttribute("usuario", usuarioLogeo);
		nombre(hs);
	}

 
}
