package com.ubosque.grupo4N.mb;

import java.util.Properties;
import javax.faces.bean.ManagedBean;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.primefaces.context.RequestContext;

@ManagedBean(name = "emailMB")
public class CorreoMB {
	/**
	 * Clase managed bean 
	 * Creación de variables privadas
	 */
	private String usuario;
	private String asunto;
	private String mensaje;
	/**
	 * Métodos get y set de las variables
	 */
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	/**
	 * Métod para enviar correo en contáctenos para la clínica
	 */
	public void enviarCorreos() {
		// TODO Auto-generated method stub
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("incendine@gmail.com", "Casiman300");
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("incendine@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("incendine@gmail.com"));
			message.setSubject(getUsuario() + getAsunto());
			message.setText(getMensaje());

			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * Métod para enviar correo para el usuario 
	 */
	public void enviarCorreosUsuario() {
		// TODO Auto-generated method stub
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("incendine@gmail.com", "Casiman300");
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("incendine@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(getUsuario()));
			message.setSubject(getAsunto());
			message.setText(getMensaje());
			

			Transport.send(message);
			RequestContext.getCurrentInstance().execute("valid()");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}
}