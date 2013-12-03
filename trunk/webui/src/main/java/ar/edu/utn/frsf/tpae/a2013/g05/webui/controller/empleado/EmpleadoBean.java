package ar.edu.utn.frsf.tpae.a2013.g05.webui.controller.empleado;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import ar.edu.utn.frsf.tpae.a2013.g05.model.Usuario;
import ar.edu.utn.frsf.tpae.a2013.g05.service.UsuarioService;

/**
 * Managed bean que actua como modelo para la vista "homeEmpleado.xhtml"
 * brindando lógica de controlador y siendo el punto de contacto con la capa de
 * servicios.
 * 
 * @author Daniela
 */
@ManagedBean(name = "empleadoBean")
@SessionScoped
public class EmpleadoBean implements Serializable {

	private static final long serialVersionUID = 9134710162192460157L;

	// DI via Spring
	@ManagedProperty(value = "#{usuarioService}")
	UsuarioService usuarioService;

	/** El usuario que se edita en "homeEmpleado.xhtml". */
	private Usuario usuario;

	// @PostConstruct
	// public void init() {
	// // Inicialización de variables usadas en las JSP, para evitar punteros
	// // nulos.
	// usuario = new Empleado();
	// }

	/**
	 * Permite que un usuario pueda solicitar la aprobación de sus gastos.
	 */
	public String solicitarAprobacion() {
		return "solicitarAprobacion";
	}

	/**
	 * Permite que un usuario pueda ver las solicitudes pendientes de aprobación
	 * de sus gastos.
	 */
	public String verSolicitudesPendientes() {
		return "verSolicitudesPendientes";
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
