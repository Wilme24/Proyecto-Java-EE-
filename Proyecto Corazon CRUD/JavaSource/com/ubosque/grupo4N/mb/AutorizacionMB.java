package com.ubosque.grupo4N.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import com.ubosque.grupo4N.modelo.Autorizacion;
import com.ubosque.grupo4N.servicio.AutorizacionServicio;

@ManagedBean(name="AutorizacionMB")
@SessionScoped
public class AutorizacionMB {
	
	/**
	 * Clase managed bean 
	 * Creación de variables privadas
	 */
	Autorizacion nuevaAutorizacion;
	private AutorizacionServicio autorizacionServicio;
	private List<Autorizacion> listaAutorizacion;
	private Autorizacion viejaAutorizacion;
	private TipoServicioMB tipServ;
	private String nombreTipoServicio;
	private PacienteMB paciente;
	private int documento;
	
	/**
	 * Creación del constructor donde inicializa las variables
	 */
	public AutorizacionMB() {
		nuevaAutorizacion = new Autorizacion();
		viejaAutorizacion = new Autorizacion();
		autorizacionServicio = new AutorizacionServicio();
		listaAutorizacion = autorizacionServicio.consultarAutorizacion();
		tipServ = new TipoServicioMB();
		paciente = new PacienteMB();
	}
	/**
	 * Métodos get y set de las variables
	 */
	public PacienteMB getPaciente() {
		return paciente;
	}
	public void setPaciente(PacienteMB paciente) {
		this.paciente = paciente;
	}
	public int getDocumento() {
		return documento;
	}
	public void setDocumento(int documento) {
		this.documento = documento;
	}
	public String getNombreTipoServicio() {
		return nombreTipoServicio;
	}
	public void setNombreTipoServicio(String nombreTipoServicio) {
		this.nombreTipoServicio = nombreTipoServicio;
	}
	public Autorizacion getNuevaAutorizacion() {
		return nuevaAutorizacion;
	}
	public void setNuevaAutorizacion(Autorizacion nuevaAutorizacion) {
		this.nuevaAutorizacion = nuevaAutorizacion;
	}
	public AutorizacionServicio getAutorizacionServicio() {
		return autorizacionServicio;
	}
	public void setAutorizacionServicio(AutorizacionServicio autorizacionServicio) {
		this.autorizacionServicio = autorizacionServicio;
	}
	public List<Autorizacion> getListaAutorizacion() {
		return listaAutorizacion;
	}
	public void setListaAutorizacion(List<Autorizacion> listaAutorizacion) {
		this.listaAutorizacion = listaAutorizacion;
	}
	public void setViejaAutorizacion(Autorizacion viejaAutorizacion) {
		this.viejaAutorizacion = viejaAutorizacion;
	}
	public Autorizacion getViejaAutorizacion() {
		return viejaAutorizacion;
	}
	public TipoServicioMB getTipServ() {
		return tipServ;
	}
	public void setTipServ(TipoServicioMB tipServ) {
		this.tipServ = tipServ;
	}
	/**
	 * Método que permite crear una autorización y re direcciona a la página de consultarAutorización
	 */
	public String crearAutorizacion(){
		RequestContext.getCurrentInstance().execute("valid()");
		nuevaAutorizacion.setDescripcionAutorizacion(tipServ.consultarTipoServicio(nombreTipoServicio));
		nuevaAutorizacion.setPaciente(paciente.consultarPacienteAutorizacion(documento));
		autorizacionServicio.crearAutorizacion(nuevaAutorizacion);
		listaAutorizacion = autorizacionServicio.consultarAutorizacion();
		return "consultarAutorizacion";		
	}
	/**
	 * Método que permite actualizar una autorización y re direcciona a la página de consultarAutorización
	 */
	public String actualizarAutorizacion(){
		autorizacionServicio.actualizarAutorizacion(nuevaAutorizacion);
		listaAutorizacion = autorizacionServicio.consultarAutorizacion();
		return "consultarAutorizacion";
	}
	/**
	 * Método que permite consultar una autorización y re direcciona a la página de consultarAutorización
	 */
	public String consultarAutorizacionEspecifica(){
		if(viejaAutorizacion.getNitAutorizacion().equals(null))
			listaAutorizacion = autorizacionServicio.consultarAutorizacion();
		else
			listaAutorizacion = autorizacionServicio.consultarAutorizacionEspecifica(viejaAutorizacion);
		return "consultarAutorizacion";
	}
	/**
	 * Método que permite eliminación de una autorización y re direcciona a la página de consultarAutorización
	 */
	public String eliminarEspecialidad(){
		autorizacionServicio.eliminarAutorizacion(viejaAutorizacion);
		listaAutorizacion = autorizacionServicio.consultarAutorizacion();
		return "consultarAutorizacion";
	}
	/**
	 * Método que permite consulta una autorización por paciente y re direcciona a la página de consultarAutorización
	 */
	public String consultarEmpleadoEspecifica(){
		if(nuevaAutorizacion.getPaciente().getDocumentoPaciente() == 0)
			listaAutorizacion = autorizacionServicio.consultarAutorizacion();
		else
			listaAutorizacion = autorizacionServicio.consultarAutorizacionEspecifica(viejaAutorizacion);
		return "consultarAutorizacion";
	}
	/**
	 * Método que permite consultar una autorización ppor paciente y re direcciona a la página de consultarAutorización
	 */
	public String consultarPacientepac(){
		
		if(documento == 0)
			listaAutorizacion = autorizacionServicio.consultarAutorizacion();
		else
			listaAutorizacion = autorizacionServicio.consultarAutorizacionEspecifica1(viejaAutorizacion);
		return "consultarAutorizacion";
	}
	/**
	 * Método que permite crear una autorización y re direcciona a la página de consultarAutorización
	 */
	public List<Autorizacion> consultarAutorizacionEspecifica1(int id){
		return listaAutorizacion= autorizacionServicio.consultarAutorizacionEspecifica1(id);
	}
	/**
	 * Método que permite consulta una autorización por el id del paciente y re direcciona a la página de consultarAutorización
	 */
	public List<Autorizacion> consultarIdPaciente (int docuemtno){
		return autorizacionServicio.consultarAutorizacionEspecifica1(docuemtno);
	}
	/**
	 * Método que permite consulta de una autorización por el id y re direcciona a la página de consultarAutorización
	 */
	public List<Autorizacion> consultarAutrizacionId (int idAuto){
		return autorizacionServicio.consultarAutorizacionAsignar(idAuto);
	}
	
}

