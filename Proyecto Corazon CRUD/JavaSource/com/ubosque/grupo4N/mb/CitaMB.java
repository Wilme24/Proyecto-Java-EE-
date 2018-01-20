package com.ubosque.grupo4N.mb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

import com.ubosque.grupo4N.modelo.Autorizacion;
import com.ubosque.grupo4N.modelo.Cita;
import com.ubosque.grupo4N.modelo.Empleado;
import com.ubosque.grupo4N.modelo.Tiposervicio;
import com.ubosque.grupo4N.servicio.CitaServicio;

@ManagedBean(name="CitaMB")
@SessionScoped
public class CitaMB  {
	/**
	 * Clase managed bean 
	 * Creación de variables privadas
	 */
	
	private Cita citaNueva;
	private Cita citaVieja;
	private List<Cita> listaCita;
	private List<Cita> listaCita1;
	private List<Autorizacion> listaAuto;
	private CitaServicio citaServicio;
	private TipoServicioMB tipoSer;
	private EmpleadoMB emp;
	private int idTipo;
	private int idEmpleado;
	private int idAutorizacion;
	private AutorizacionMB auto;
	private int documentoPaciente;
	private List<Empleado> listaEmpleado; 
	private Tiposervicio tip;
	
	/**
	 * Creación del constructor donde inicializa las variables
	 */
	public CitaMB() {
		citaNueva = new Cita();
		citaVieja = new Cita();
		citaServicio = new CitaServicio();
		listaCita = citaServicio.consultarCita();
		tipoSer = new TipoServicioMB();
		emp= new EmpleadoMB();
		auto = new AutorizacionMB();
	}
	/**
	 * Métodos get y set de las variables
	 */
	public List<Empleado> getListaEmpleado() {
		return listaEmpleado;
	}
	public void setListaEmpleado(List<Empleado> listaEmpleado) {
		this.listaEmpleado = listaEmpleado;
	}
	public List<Cita> getListaCita1() {
		return listaCita1;
	}
	public void setListaCita1(List<Cita> listaCita1) {
		this.listaCita1 = listaCita1;
	}
	public int getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public int getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	public TipoServicioMB getTipoSer() {
		return tipoSer;
	}
	public void setTipoSer(TipoServicioMB tipoSer) {
		this.tipoSer = tipoSer;
	}
	public Cita getCitaNueva() {
		return citaNueva;
	}
	public void setCitaNueva(Cita citaNueva) {
		this.citaNueva = citaNueva;
	}
	public Cita getCitaVieja() {
		return citaVieja;
	}
	public void setCitaVieja(Cita citaVieja) {
		this.citaVieja = citaVieja;
	}
	public int getIdAutorizacion() {
		return idAutorizacion;
	}
	public void setIdAutorizacion(int idAutorizacion) {
		this.idAutorizacion = idAutorizacion;
	}
	public List<Autorizacion> getListaAuto() {
		return listaAuto;
	}
	public void setListaAuto(List<Autorizacion> listaAuto) {
		this.listaAuto = listaAuto;
	}
	public int getDocumentoPaciente() {
		return documentoPaciente;
	}
	public void setDocumentoPaciente(int documentoPaciente) {
		this.documentoPaciente = documentoPaciente;
	}
	public List<Cita> getListaCita() {
		return listaCita;
	}
	public void setListaCita(List<Cita> listaCita) {
		this.listaCita = listaCita;
	}
	public CitaServicio getCitaServicio() {
		return citaServicio;
	}
	public void setCitaServicio(CitaServicio citaServicio) {
		this.citaServicio = citaServicio;
	}
	/**
	 * Método que permite crear una cita y re direcciona a la página de consultarCitas
	 */
	public String crearCita() {
		RequestContext.getCurrentInstance().execute("valid()");
		citaNueva.setEstadoCita("Activa");
		citaNueva.setTiposervicio(tipoSer.consultarTipoServicioCita(idTipo));	
		citaNueva.setEmpleado(emp.consultarEmpleadoCita(idEmpleado));
		citaServicio.crearCita(citaNueva);
		listaCita = citaServicio.consultarCita();
		return "consultarCitas";
	}
	/**
	 * Método que permite actualización de una cita y re direcciona a la página de consultarCitas
	 */
	public String actualizarCita() {
		citaServicio.actualizarCita(citaVieja);
		return "consultarCitas";
	}
	/**
	 * Método que permite consultar una cita y re direcciona a la página de consultarCitas 
	 */
	public void consultarIdPaciente(){
		listaAuto = auto.consultarIdPaciente(documentoPaciente);
	}
	/**
	 * Método que permite consulta de una cita y re direcciona a la página de consultarCitas
	 */
	public void consultarCitaAuto(){
		RequestContext.getCurrentInstance().execute("dlg2.show()");
		listaCita1 = citaServicio.consultarCitaAtuo(idAutorizacion);
	}
	/**
	 * Método que permite asignar una cita y re direcciona a la página de consultarCitas
	 */
	public String asignarCita() {
		citaVieja.setEstadoCita("Ocupada");
		citaVieja.setAutorizacion(auto.consultarAutrizacionId(idAutorizacion).get(0));
		auto.nuevaAutorizacion = auto.consultarAutrizacionId(idAutorizacion).get(0);
		auto.nuevaAutorizacion.setEstado("Ocupado");
		auto.actualizarAutorizacion();
		citaServicio.actualizarCita(citaVieja);
		return "asignarCitas";
	}
	/**
	 * Método que permite consulta la disponibilidad del empleado para una cita y re direcciona a la página de consultarCitas
	 */
	public void consultarDisponibilidadEmpleado(){
		tip= tipoSer.consultarTipoServicioCita(idTipo);
		listaEmpleado =emp.consultarDisponibilidadEmpleado(citaNueva.getFechaCita(), tip.getNombreTipoServicio());
	}
	
	/**
	 * Método que permite actualización de una cita y re direcciona a la página de consultarCitas
	 */
	public String actualizarCitaPaciente() {
		java.util.Date fecha3 = new Date();
		java.util.Date fecha = citaVieja.getFechaCita();
		java.util.Date fecha2 = new Date();
		SimpleDateFormat parseador = new SimpleDateFormat("yyyy/MM/dd");
		String fechaSting = parseador.format(fecha2);
		try {
			 fecha3 = parseador.parse(fechaSting);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		if(fecha3.before(fecha)){
			citaVieja.setEstadoCita("Cancelada");
			citaServicio.actualizarCita(citaVieja);
		}else{
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No sé puede cancelar la cita");
			FacesContext.getCurrentInstance().addMessage(null, message);
        } 
		return "consultarCitasPacientes";
	}
	/**
	 * Método que permite la consulta del paciente activo
	 */
	public List<Autorizacion> probar(int documentoPaciente){
		return listaAuto = auto.consultarIdPaciente(documentoPaciente);
	}
	/**
	 * Método que asigna cita a un paciente
	 */
	public String asignarCitaPaciente() {
		citaVieja.setEstadoCita("Ocupada");
		citaVieja.setAutorizacion(auto.consultarAutrizacionId(idAutorizacion).get(0));
		auto.nuevaAutorizacion = auto.consultarAutrizacionId(idAutorizacion).get(0);
		auto.nuevaAutorizacion.setEstado("Ocupado");
		auto.actualizarAutorizacion();
		citaServicio.actualizarCita(citaVieja);
		return "asignarCitasPaciente";
	}
}
