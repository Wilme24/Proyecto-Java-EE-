package com.ubosque.grupo4N.mb;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="imagesView")
@SessionScoped
public class InicioMB {
	
	/**
	 * Clase managed bean 
	 * Creación de variables privadas
	 */
	private List<String> images;
	private java.util.Date fecha = new java.util.Date();
	
	/**
	 * Metodo para controlar el carrusel del inicio
	 * */
	@PostConstruct
	public void init() {
        images = new ArrayList<String>();
        for (int i = 1; i <= 8; i++) {
            images.add("imagen" + i + ".jpg");
        }
    }
	/**
	 * Métodos get y set de las variables
	 */
    public List<String> getImages() {
        return images;
    }
    
    public java.util.Date getFecha() {
		return fecha;
	}
}
