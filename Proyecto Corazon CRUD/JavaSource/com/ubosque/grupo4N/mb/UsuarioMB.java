package com.ubosque.grupo4N.mb;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.mail.Session;
import javax.servlet.http.HttpSession;

import com.ubosque.grupo4N.modelo.Autorizacion;
import com.ubosque.grupo4N.modelo.Cita;
import com.ubosque.grupo4N.modelo.Empleado;
import com.ubosque.grupo4N.modelo.Paciente;
import com.ubosque.grupo4N.modelo.Rol;
import com.ubosque.grupo4N.modelo.Usuario;
import com.ubosque.grupo4N.servicio.CitaServicio;
import com.ubosque.grupo4N.servicio.UsuarioServicio;
@ManagedBean (name="UsuarioMB")
@SessionScoped
public class UsuarioMB {
	/**
	 * Clase managed bean 
	 * Creación de variables privadas
	 */
	private Usuario usuarioNuevo;
	private List<Usuario> listaUsuarios;
	private Usuario usuarioViejo;
	private UsuarioServicio usuarioServ;
	private RolMB rol;
	private List<Usuario> comodin;
	private Usuario usuarioLogeo;
	private List<Autorizacion> listaAu;
	private List<Cita> listaCita;


	/**
	 * Creación del constructor donde inicializa las variables
	 */
	public UsuarioMB() {
		// TODO Auto-generated constructor stub
		usuarioNuevo = new Usuario();
		usuarioServ = new UsuarioServicio();
		usuarioViejo = new Usuario();
		listaUsuarios = usuarioServ.consultarUsuario();
		rol = new RolMB();
       if(SessionUtils.q!=null){
        usuarioLogeo= SessionUtils.q;
       }else
    	   usuarioLogeo = new Usuario();
	}
	/**
	 * Métodos get y set de las variables
	 */
	public List<Autorizacion> getListaAu() {
		return listaAu;
	}


	public void setListaAu(List<Autorizacion> listaAu) {
		this.listaAu = listaAu;
	}
	
	public Usuario getUsuarioLogeo() {
		return usuarioLogeo;
	}
	public void setUsuarioLogeo(Usuario usuarioLogeo) {
		this.usuarioLogeo = usuarioLogeo;
	}
	public Usuario getUsuarioNuevo() {
		return usuarioNuevo;
	}

	public void setUsuarioNuevo(Usuario usuarioNuevo) {
		this.usuarioNuevo = usuarioNuevo;
	}

	public List<Cita> getListaCita() {
		return listaCita;
	}
	public void setListaCita(List<Cita> listaCita) {
		this.listaCita = listaCita;
	}
	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public Usuario getUsuarioViejo() {
		return usuarioViejo;
	}

	public void setUsuarioViejo(Usuario usuarioViejo) {
		this.usuarioViejo = usuarioViejo;
	}

	public UsuarioServicio getUsuarioServ() {
		return usuarioServ;
	}

	public void setUsuarioServ(UsuarioServicio usuarioServ) {
		this.usuarioServ = usuarioServ;
	}
	/**
	 * Metodo para crear un Usuario nuevo de un empleado
	 * */
	public Usuario crearUsuario(int idRol,Empleado emp){
		Rol rolAsignado=null;
		rolAsignado=rol.consultarRolEmpleado(idRol);
		usuarioNuevo.setRol(rolAsignado);
		usuarioNuevo.setContrasena(Herramientas.encriptar(""+emp.getDocumentoEmpleado()+emp.getNombresEmpleado()));
		usuarioNuevo.setUsuario(""+emp.getDocumentoEmpleado());
		usuarioNuevo.setEmpleado(emp);
		usuarioServ.crearUsuario(usuarioNuevo); 
		return usuarioNuevo;
	}
	/**
	 * Metodo para crear un Usuario nuevo de un Paciente
	 * */
	public Usuario crearUsuario(Paciente pac){
		Rol rolAsignado=null;
		rolAsignado=rol.consultarRolPaciente();
		usuarioNuevo.setRol(rolAsignado);
		usuarioNuevo.setContrasena(Herramientas.encriptar(""+pac.getDocumentoPaciente()+pac.getNombresPaciente()));
		usuarioNuevo.setUsuario(""+pac.getDocumentoPaciente());
		usuarioNuevo.setPaciente(pac);
		usuarioServ.crearUsuario(usuarioNuevo); 
		return usuarioNuevo;
	}
	/**
	 * Metodo para actualizar un usuario
	 * */
	public String actualizarUsuario(){
		
		try {
			comodin = usuarioServ.consultarUsuarioEspecificaID(usuarioViejo.getIdUsuario());
			usuarioNuevo.setContrasena(comodin.get(0).getContrasena());
			if(!usuarioViejo.getContrasena().equals(usuarioNuevo.getContrasena())){
				usuarioViejo.setContrasena(Herramientas.encriptar(usuarioViejo.getContrasena()));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		usuarioServ.actualizarUsuario(usuarioViejo);
		return "consultarUsuario";
	}
	/**
	 * Metodo para consultar un usuario
	 * */
	public String consultarUsuario(){
		if (usuarioViejo.getUsuario().equals("")) {
			listaUsuarios = usuarioServ.consultarUsuario();
		}
		else{
			listaUsuarios = usuarioServ.consultarUsuarioUsu(usuarioViejo.getUsuario());
		}
		return "consultarUsuarios";
	}
	/**
	 * Metodo de logueo a la aplicacion
	 */
	public String Loguearse(){
		String pagina="";
		FacesMessage message = null ;
		boolean encontrado = false;
		String perfil="";
		
		
		try{
		
		for (int i = 0; i < listaUsuarios.size(); i++) {
			usuarioLogeo = listaUsuarios.get(i);
			if(usuarioNuevo.getUsuario().equals(usuarioLogeo.getUsuario())){
				String contrasenavieja = Herramientas.desencriptar(usuarioLogeo.getContrasena());
				if(usuarioNuevo.getContrasena().equals(contrasenavieja)){
					perfil = usuarioLogeo.getRol().getPerfilRol();
					HttpSession hs = SessionUtils.getSession();
					SessionUtils.usuario(hs, usuarioLogeo);
					encontrado=true;
					break;
				}
				
			}else{
				message= new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Usuario invalido");
				
			}

		}
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		if(encontrado){
			if(perfil.equals("Paciente"))
				pagina="/menus/Paciente";
			if(perfil.equals("Administrador"))
				pagina="/menus/Administrador";
			if(perfil.equals("CallCenter"))
				pagina="/menus/CallCenter";
			if(perfil.equals("Doctor"))
				pagina="/menus/Doctor";
			return pagina;
			
		}
		else{
			FacesContext.getCurrentInstance().addMessage(null, message);
			return null;
		}
		
	}
	/**
	 * Metodo para cerrar la session
	 * */
	public void cerrarSesion(){
		
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}
	/**
	 * Metodo para asignar un usuario
	 * */
	public void asignar(){
		CitaMB cit = new CitaMB();
		listaAu=cit.probar(usuarioLogeo.getPaciente().getDocumentoPaciente());
	}
	/**
	 * Metodo para consultar las citas de un empleado
	 * */
	public void consultarCitasEmpl(){
		CitaServicio sercita=new CitaServicio();
		listaCita=sercita.consultarCitasEmpl(usuarioLogeo.getEmpleado().getDocumentoEmpleado());
	}
	/**
	 * Metodo para consultar las citas de un paciente
	 * */
	public void consultarCitasPac(){
		CitaServicio sercita=new CitaServicio();
		listaCita=sercita.consultarCitasPac(usuarioLogeo.getPaciente().getDocumentoPaciente());
	}
}
