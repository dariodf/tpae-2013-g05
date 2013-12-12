package ar.edu.utn.frsf.tpae.a2013.g05.webui.controller.supervisor;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import ar.edu.utn.frsf.tpae.a2013.g05.service.UsuarioService;

/**
 * Managed bean que actua como modelo para la vista "homeSupervisor.xhtml"
 * brindando lógica de controlador y siendo el punto de contacto con la capa de
 * servicios.
 * 
 * @author Agustin
 * @author Daniela
 */
@ManagedBean(name = "supervisorBean")
@SessionScoped
public class SupervisorBean implements Serializable {

	private static final long serialVersionUID = 2417692082536975932L;

	// DI via Spring
	@ManagedProperty(value = "#{usuarioService}")
	UsuarioService usuarioService;

	/**
	 * Permite que un supervisor pueda administrar las solicitudes de gastos.
	 */
	public String administrarSolicitudes() {
		return "administrarSolicitudes";
	}

	/**
	 * Permite que un supervisor pueda consultar las solicitudes de gastos.
	 */
	public String consultar() {
		return "consultar";
	}

	// Getters y setters, utilizados por las JSF.

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

}
