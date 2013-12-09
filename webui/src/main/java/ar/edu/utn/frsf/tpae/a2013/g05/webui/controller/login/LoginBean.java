package ar.edu.utn.frsf.tpae.a2013.g05.webui.controller.login;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import ar.edu.utn.frsf.tpae.a2013.g05.model.Empleado;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Usuario;
import ar.edu.utn.frsf.tpae.a2013.g05.service.UsuarioService;

/**
 * Managed bean que actua como modelo para la vista "login.xhtml" brindando
 * lógica de controlador y siendo el punto de contacto con la capa de servicios.
 * 
 * @author Daniela
 */
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = -8202726216981729177L;

	// DI via Spring
	@ManagedProperty(value = "#{usuarioService}")
	UsuarioService usuarioService;

	/** El usuario que se edita en "login.xhtml". */
	private Usuario usuario;

	@PostConstruct
	public void init() {
		// Inicialización de variables usadas en las JSP, para evitar punteros
		// nulos.
		usuario = new Empleado();
	}

	/**
	 * Permite que un usuario existente en la base de datos pueda loguearse al
	 * sistema de gestión de operaciones.
	 * 
	 * @return <code>null</code> para permanecer en la misma página.
	 */
	public String ingresar() {
		Usuario usuario = usuarioService.ingresar(this.usuario.getUsuario(), this.usuario.getPassword());

		if (usuario == null) {
			// Se retorna null para permanecer en la misma página.
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puede ingresar al sistema, los datos ingresados son inválidos."));
			return null;
		} else {
			// Si el usuario existe en el sistema se lo redirije a la página
			// correspondiente a su rol
			if (usuario.getClass() == Empleado.class) {
				return "homeEmpleado";
			} else {
				return "homeSupervisor";
			}
		}
	}

	// Getters y setters, utilizados por las JSF.

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

}
