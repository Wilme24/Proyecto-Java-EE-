package com.ubosque.grupo4N.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;

import com.ubosque.grupo4N.modelo.Paciente;
import com.ubosque.grupo4N.modelo.Usuario;
import com.ubosque.grupo4N.servicio.PacienteServicio;

@ManagedBean(name = "PacienteMB")
@SessionScoped
public class PacienteMB {

	/**
	 * Clase managed bean 
	 * Creación de variables privadas
	 */
	private Paciente pacienteNuevo;
	private List<Paciente> listaPacientes;
	private Paciente pacienteViejo;
	private PacienteServicio pacienteServ;
	private UsuarioMB usuarioMB;
	private Usuario usuario;
	private CorreoMB correo;
	
	/**
	 * Creación del constructor donde inicializa las variables
	 */
	public PacienteMB() {
		pacienteNuevo = new Paciente();
		pacienteServ = new PacienteServicio();
		listaPacientes = pacienteServ.consultarPaciente();
		pacienteViejo = new Paciente();
		usuarioMB= new UsuarioMB();
		usuario = new Usuario();
		correo = new CorreoMB();
		
	}
	/**
	 * Métodos get y set de las variables
	 */
	public Paciente getPacienteNuevo() {
		return pacienteNuevo;
	}

	public void setPacienteNuevo(Paciente pacienteNuevo) {
		this.pacienteNuevo = pacienteNuevo;
	}

	public List<Paciente> getListaPacientes() {
		return listaPacientes;
	}

	public void setListaPacientes(List<Paciente> listaPacientes) {
		this.listaPacientes = listaPacientes;
	}

	public Paciente getPacienteViejo() {
		return pacienteViejo;
	}

	public void setPacienteViejo(Paciente pacienteViejo) {
		this.pacienteViejo = pacienteViejo;
	}
	
	/**
	 * Metodo para crear un nuevo Paciente
	 * */
	public String crearPaciente(){
		
		pacienteServ.crearPaciente(pacienteNuevo);
		usuario=usuarioMB.crearUsuario(pacienteNuevo);
		correo.setUsuario(pacienteNuevo.getCorreoPaciente());
		correo.setAsunto("Usuario instituto corazón");
		try {
			correo.setMensaje("Buen día \n Usted ha sido registrado en la página del Instituto corazón; para poder solicitar cualquier cita por favor ingrese a: Sus datos son: Usuario: "+usuario.getUsuario()+" Contraseña: "+Herramientas.desencriptar(usuario.getContrasena()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		correo.enviarCorreosUsuario();
		listaPacientes = pacienteServ.consultarPaciente();
		RequestContext.getCurrentInstance().execute("valid()");
		return "consultarPacientes.jsf";
	}
	/**
	 * Metodo para actualizar un Paciente
	 * */
	public String actualizarPaciente(){
		pacienteServ.actualizarPaciente(pacienteNuevo);
		listaPacientes = pacienteServ.consultarPaciente();
		return "consultarPacientes";
	}
	/**
	 * Metodo para consultar un Paciente por su documento o general
	 * */
	public String consultarEspecialidadPaciente(){
		if(pacienteViejo.getDocumentoPaciente()==0)
			listaPacientes = pacienteServ.consultarPaciente();
		else 
			listaPacientes = pacienteServ.consultarPacienteEspecifica(pacienteViejo);
		return "consultarPacientes";
	}
	/**
	 * Metodo para consultar un Paciente y sus autorizaciones
	 * */
	public Paciente consultarPacienteAutorizacion(int id){
		Paciente pac= null;
		listaPacientes = pacienteServ.consultarPaciente();
		for(int i=0;i<listaPacientes.size();i++){
			pac = listaPacientes.get(i);
			if(pac.getIdPaciente()==id){
				break;
			}
		}
		return pac;
	}
	/**
	 * Metodo para consultar un Paciente por su ID
	 * */
	public int consultarIdPaciente (int docuento){
		listaPacientes= pacienteServ.consultarPacienteEspecifica(docuento);
		pacienteViejo = listaPacientes.get(0);
		return pacienteViejo.getIdPaciente();
	}
}
