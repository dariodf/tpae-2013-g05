package ar.edu.utn.frsf.tpae.a2013.g05.webui.controller.empleado;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import ar.edu.utn.frsf.tpae.a2013.g05.model.CentroDeCosto;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Constantes;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Empleado;
import ar.edu.utn.frsf.tpae.a2013.g05.model.SolicitudDeGastos;
import ar.edu.utn.frsf.tpae.a2013.g05.service.CentroDeCostoService;
import ar.edu.utn.frsf.tpae.a2013.g05.service.SolicitudDeGastosService;
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
	@ManagedProperty(value = "#{solicitudDeGastosService}")
	SolicitudDeGastosService solicitudDeGastosService;

	@ManagedProperty(value = "#{usuarioService}")
	UsuarioService usuarioService;

	@ManagedProperty(value = "#{centroDeCostoService}")
	CentroDeCostoService centroDeCostoService;

	/** Los centros de costo que se obtienen en "solicitarAprobacion.xhtml". */
	private List<CentroDeCosto> centrosDeCosto;

	private String centroDeCostoSeleccionado;

	/** La solicitud de gasto que se edita en "solicitarAprobacion.xhtml". */
	private SolicitudDeGastos solicitudDeGastos;

	@PostConstruct
	public void init() {
		// Inicialización de variables usadas en las JSP, para evitar punteros
		// nulos.
		centrosDeCosto = new ArrayList<CentroDeCosto>();
		solicitudDeGastos = new SolicitudDeGastos();

		List<CentroDeCosto> listaCentrosDeCosto = centroDeCostoService.listarCentrosDeCosto();

		for (int i = 0; i < listaCentrosDeCosto.size(); i++)
			centrosDeCosto.add(listaCentrosDeCosto.get(i));
	}

	/**
	 * Permite que un usuario pueda solicitar la aprobación de sus gastos.
	 */
	public String solicitarAprobacion() {
		return "solicitarAprobacion.xhtml";
	}

	/**
	 * Permite que un empleado solicite una aprobación de un gasto.
	 * 
	 * @return <code>null</code> para permanecer en la misma página.
	 */
	public String aceptaSolicitarAprobacion(ActionEvent actionEvent) {
		// Se setean las propiedades faltantes en la solicitudDeGastos
		solicitudDeGastos.setEmpleado((Empleado) usuarioService.getUsuarioLogueado());
		solicitudDeGastos.setEstado(Constantes.PENDIENTE.name());
		solicitudDeGastos.setFechaCreacion(new Date());

		for (CentroDeCosto cco : this.centrosDeCosto) {
			if (centroDeCostoSeleccionado.length() == 0) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage("Debe seleccionar un Centro de Costo."));
				break;
			} else {
				if (cco.getNombre().equals(centroDeCostoSeleccionado)) {
					solicitudDeGastos.setCentroDeCosto(cco);
					break;
				}
			}
		}

		solicitudDeGastosService.crearSolicitudAprobacion(solicitudDeGastos);

		FacesContext
				.getCurrentInstance()
				.addMessage(
						null,
						new FacesMessage(
								"La solicitud de aprobación del gasto ha sido creada. En el transcurso de 5 días será revisada para su aprobación."));

		// Se limpian los campos para una nueva carga de solicitud de gasto.
		this.init();
		return this.solicitarAprobacion();
	}

	/**
	 * Permite que un usuario pueda ver las solicitudes pendientes de aprobación
	 * de sus gastos.
	 */
	public String verSolicitudesPendientes() {
		return "verSolicitudesPendientes";
	}

	// Getters y setters, utilizados por las JSF.

	/**
	 * @return the solicitudDeGastos
	 */
	public SolicitudDeGastos getSolicitudDeGastos() {
		return solicitudDeGastos;
	}

	/**
	 * @return the centrosDeCosto
	 */
	public List<CentroDeCosto> getCentrosDeCosto() {
		return centrosDeCosto;
	}

	/**
	 * @param centrosDeCosto
	 *            the centrosDeCosto to set
	 */
	public void setCentrosDeCosto(List<CentroDeCosto> centrosDeCosto) {
		this.centrosDeCosto = centrosDeCosto;
	}

	/**
	 * @param solicitudDeGastos
	 *            the solicitudDeGastos to set
	 */
	public void setSolicitudDeGastos(SolicitudDeGastos solicitudDeGastos) {
		this.solicitudDeGastos = solicitudDeGastos;
	}

	/**
	 * @return the solicitudDeGastosService
	 */
	public SolicitudDeGastosService getSolicitudDeGastosService() {
		return solicitudDeGastosService;
	}

	/**
	 * @param solicitudDeGastosService
	 *            the solicitudDeGastosService to set
	 */
	public void setSolicitudDeGastosService(SolicitudDeGastosService solicitudDeGastosService) {
		this.solicitudDeGastosService = solicitudDeGastosService;
	}

	/**
	 * @return the usuarioService
	 */
	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	/**
	 * @param usuarioService
	 *            the usuarioService to set
	 */
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	/**
	 * @return the centroDeCostoService
	 */
	public CentroDeCostoService getCentroDeCostoService() {
		return centroDeCostoService;
	}

	/**
	 * @param centroDeCostoService
	 *            the centroDeCostoService to set
	 */
	public void setCentroDeCostoService(CentroDeCostoService centroDeCostoService) {
		this.centroDeCostoService = centroDeCostoService;
	}

	/**
	 * @return the centroDeCostoSeleccionado
	 */
	public String getCentroDeCostoSeleccionado() {
		return centroDeCostoSeleccionado;
	}

	/**
	 * @param centroDeCostoSeleccionado
	 *            the centroDeCostoSeleccionado to set
	 */
	public void setCentroDeCostoSeleccionado(String centroDeCostoSeleccionado) {
		this.centroDeCostoSeleccionado = centroDeCostoSeleccionado;
	}

}
