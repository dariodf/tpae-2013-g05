package ar.edu.utn.frsf.tpae.a2013.g05.webui.controller.supervisor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlDataTable;

import ar.edu.utn.frsf.tpae.a2013.g05.model.Constantes;
import ar.edu.utn.frsf.tpae.a2013.g05.model.SolicitudDeGastos;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Supervisor;
import ar.edu.utn.frsf.tpae.a2013.g05.service.SolicitudDeGastosService;
import ar.edu.utn.frsf.tpae.a2013.g05.service.UsuarioService;

/**
 * Managed bean que actua como modelo para las vistas
 * "administrarSolicitudes.xhtml", "aprobarSolicitud.xhtml" y
 * "rechazarSolicitud.html" brindando lógica de controlador y siendo el punto de
 * contacto con la capa de servicios.
 * 
 * @author Agustin
 */
@ManagedBean(name = "administrarSolicitudesBean")
@SessionScoped
public class AdministrarSolicitudesBean implements Serializable {

	private HtmlDataTable tablaSolicitudesPendientes;
	private SolicitudDeGastos solicitudPendienteSeleccionada;
	private List<SolicitudDeGastos> listaSolicitudesPendientes;
	String comentario;

	// DI via Spring
	@ManagedProperty(value = "#{usuarioService}")
	UsuarioService usuarioService;

	// DI via Spring
	@ManagedProperty(value = "#{solicitudDeGastosService}")
	SolicitudDeGastosService solicitudDeGastosService;

	private static final long serialVersionUID = 5556010545646204323L;

	@PostConstruct
	public void init() {
		/*
		 * Inicializa las variables para que no haya punteros nulos y trae las
		 * solicitudes de gastos pendientes
		 */
		solicitudPendienteSeleccionada = new SolicitudDeGastos();
		listaSolicitudesPendientes = new ArrayList<SolicitudDeGastos>();
		listaSolicitudesPendientes = solicitudDeGastosService.listarSolicitudesPendientes();
		comentario = new String();
	}

	/**
	 * Navega a la pagina de aprobarSolicitud.xhtml y ademas obtiene la
	 * solicitud seleccionada
	 * 
	 * @return la referencia a la pagina
	 */
	public String irAprobarSolicitud() {
		solicitudPendienteSeleccionada = (SolicitudDeGastos) tablaSolicitudesPendientes.getRowData();
		return "aprobarSolicitud";
	}

	/**
	 * Navega a la pagina de rechazarSolicitud.xhtml y ademas obtiene la
	 * solicitud seleccionada
	 * 
	 * @return la referencia a la pagina
	 */
	public String irRechazarSolicitud() {
		solicitudPendienteSeleccionada = (SolicitudDeGastos) tablaSolicitudesPendientes.getRowData();
		return "rechazarSolicitud";
	}

	/**
	 * Metodo encargado de aprobar la solicitud en la base de datos
	 * 
	 * @return String indicador de la proxima pagina a la cual navegar
	 */
	public String aprobarSolicitud() {
		if (!comentario.isEmpty())
			this.solicitudPendienteSeleccionada.setComentario(this.comentario);
		this.solicitudPendienteSeleccionada.setEstado(Constantes.APROBADA.name());
		this.solicitudPendienteSeleccionada.setSupervisor((Supervisor) usuarioService.getUsuarioLogueado());
		this.solicitudPendienteSeleccionada.setFechaAprobacion(new Date());
		solicitudDeGastosService.crearSolicitudAprobacion(this.solicitudPendienteSeleccionada);
		return volverAtras();
	}

	/**
	 * Metodo encargado de rechazar la solicitud en la base de datos
	 * 
	 * @return String indicador de la proxima pagina a la cual navegar
	 */
	public String rechazarSolicitud() {
		if (!comentario.isEmpty())
			this.solicitudPendienteSeleccionada.setComentario(this.comentario);
		this.solicitudPendienteSeleccionada.setEstado(Constantes.RECHAZADA.name());
		this.solicitudPendienteSeleccionada.setSupervisor((Supervisor) usuarioService.getUsuarioLogueado());
		this.solicitudPendienteSeleccionada.setFechaAprobacion(new Date());
		solicitudDeGastosService.crearSolicitudAprobacion(this.solicitudPendienteSeleccionada);
		return volverAtras();
	}

	/**
	 * Metodo encargado de limpiar la pantalla y volver a la pantalla anterior
	 * 
	 * @return String indicador de la proxima pagina a la cual navegar
	 */
	public String volverAtras() {
		if (this.comentario != null)
			this.comentario = "";
		this.listaSolicitudesPendientes = solicitudDeGastosService.listarSolicitudesPendientes();
		this.solicitudPendienteSeleccionada = new SolicitudDeGastos();
		return "administrarSolicitudes";
	}

	/**
	 * @return the tablaSolicitudesPendientes
	 */
	public HtmlDataTable getTablaSolicitudesPendientes() {
		return tablaSolicitudesPendientes;
	}

	/**
	 * @param tablaSolicitudesPendientes
	 *            the tablaSolicitudesPendientes to set
	 */
	public void setTablaSolicitudesPendientes(HtmlDataTable tablaSolicitudesPendientes) {
		this.tablaSolicitudesPendientes = tablaSolicitudesPendientes;
	}

	/**
	 * @return the solicitudPendienteSeleccionada
	 */
	public SolicitudDeGastos getSolicitudPendienteSeleccionada() {
		return solicitudPendienteSeleccionada;
	}

	/**
	 * @param solicitudPendienteSeleccionada
	 *            the solicitudPendienteSeleccionada to set
	 */
	public void setSolicitudPendienteSeleccionada(SolicitudDeGastos solicitudPendienteSeleccionada) {
		this.solicitudPendienteSeleccionada = solicitudPendienteSeleccionada;
	}

	/**
	 * @return the listaSolicitudesPendientes
	 */
	public List<SolicitudDeGastos> getListaSolicitudesPendientes() {
		return listaSolicitudesPendientes;
	}

	/**
	 * @param listaSolicitudesPendientes
	 *            the listaSolicitudesPendientes to set
	 */
	public void setListaSolicitudesPendientes(List<SolicitudDeGastos> listaSolicitudesPendientes) {
		this.listaSolicitudesPendientes = listaSolicitudesPendientes;
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
	 * @return the comentario
	 */
	public String getComentario() {
		return comentario;
	}

	/**
	 * @param comentario
	 *            the comentario to set
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

}
