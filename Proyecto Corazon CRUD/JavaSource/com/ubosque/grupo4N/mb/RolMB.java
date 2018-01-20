package com.ubosque.grupo4N.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import org.primefaces.context.RequestContext;

import com.ubosque.grupo4N.modelo.Especialidad;
import com.ubosque.grupo4N.modelo.Rol;
import com.ubosque.grupo4N.modelo.Usuario;
import com.ubosque.grupo4N.servicio.RolServicio;

@ManagedBean(name="RolMB")
@SessionScoped
public class RolMB {
	/**
	 * Clase managed bean 
	 * Creación de variables privadas
	 */
	private Rol nuevoRol;
	private Rol viejoRol;
	private RolServicio rolServicio;
	private List<Rol> lista;
	private ArrayList<SelectItem> listaRoles;
	/**
	 * Creación del constructor donde inicializa las variables
	 */
	public RolMB() {
		viejoRol = new Rol();
		nuevoRol = new Rol();
		rolServicio = new RolServicio();
		lista = rolServicio.consultarRol();
		listaRoles = new ArrayList<SelectItem>();
		for(int i=0; i<lista.size();i++){
			Rol rol= lista.get(i);
			listaRoles.add(new SelectItem(rol.getIdRol(),rol.getPerfilRol()));
		}
	}
	/**
	 * Métodos get y set de las variables
	 */
	public ArrayList<SelectItem> getListaRoles() {
		return listaRoles;
	}

	public void setListaRoles(ArrayList<SelectItem> listaRoles) {
		this.listaRoles = listaRoles;
	}

	public Rol getNuevoRol() {
		return nuevoRol;
	}

	public void setNuevoRol(Rol nuevoRol) {
		this.nuevoRol = nuevoRol;
	}
	
	public List<Rol> getLista() {
		return lista;
	}

	public void setLista(List<Rol> lista) {
		this.lista = lista;
	}

	public Rol getViejoRol() {
		return viejoRol;
	}

	public void setViejoRol(Rol viejoRol) {
		this.viejoRol = viejoRol;
	}
	/**
	 * Metodo para crear un Rol nuevo
	 * */
	public String crearRol(){
		rolServicio.insertarRol(nuevoRol);
		setLista(rolServicio.consultarRol());
		RequestContext.getCurrentInstance().execute("valid()");
		return "consultarRoles";
	}
	/**
	 * Metodo para actualizar un Rol
	 * */
	public String actualizarRol(){
		rolServicio.actualizarRol(nuevoRol);
		setLista(rolServicio.consultarRol());
		RequestContext.getCurrentInstance().execute("valid()");
		return "consultarRoles";
	}
	/**
	 * Metodo para consultar un Rol por su nombre
	 * */
	public String consultarRolEspecifico(){
		if(viejoRol.getPerfilRol().equals(""))
			lista = rolServicio.consultarRol();
		else
			lista = rolServicio.ConsultarRolEspecifico(viejoRol);
		return "consultarRoles";
	}
	/**
	 * Metodo para consultar un Rol de un empleado
	 * */
	public Rol consultarRolEmpleado(int id){
		Rol es= null;
		lista = rolServicio.consultarRol();
		boolean entro=false;
		for(int i=0;i<lista.size();i++){
			es = lista.get(i);
			if(es.getIdRol()==id){
				entro=true;
				break;
			}
		}
		if(entro==false){
			es=null;
		}
		return es;
	}
	/**
	 * Metodo para consultar un Rol de un paciente
	 * */
	public Rol consultarRolPaciente(){
		Rol es= null;
		lista = rolServicio.consultarRol();
		boolean entro=false;
		for(int i=0;i<lista.size();i++){
			es = lista.get(i);
			if(es.getPerfilRol().equals("Paciente")){
				entro=true;
				break;
			}
		}
		if(entro==false){
			es=null;
		}
		return es;
	}
}
