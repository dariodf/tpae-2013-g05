/**
 * 
 */
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
import javax.faces.component.html.HtmlInputTextarea;

import ar.edu.utn.frsf.tpae.a2013.g05.model.CentroDeCosto;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Empleado;
import ar.edu.utn.frsf.tpae.a2013.g05.model.SolicitudDeGastos;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Supervisor;
import ar.edu.utn.frsf.tpae.a2013.g05.service.SolicitudDeGastosService;
import ar.edu.utn.frsf.tpae.a2013.g05.service.UsuarioService;
import ar.edu.utn.frsf.tpae.a2013.g05.service.impl.SolicitudDeGastosServiceImpl;

/**
 * Managed bean que actua como modelo para la vista "administrarSolicitudes.xhtml"
 * brindando lógica de controlador y siendo el punto de contacto con la capa de
 * servicios.
 * 
 * @author Agustin
 */
@ManagedBean(name = "administrarSolicitudesBean")
@SessionScoped
public class AdministrarSolicitudesBean implements Serializable {

	private HtmlDataTable tablaSolicitudesPendientes;
	private HtmlInputTextarea comentario;
	private SolicitudDeGastos solicitudPendienteSeleccionada;
	private List<SolicitudDeGastos> listaSolicitudesPendientes;
	
	// DI via Spring
	@ManagedProperty(value = "#{usuarioService}")
	UsuarioService usuarioService;
	
	// DI via Spring
	@ManagedProperty(value = "#{solicitudDeGastosService}")
	SolicitudDeGastosService solicitudDeGastosService;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5556010545646204323L;
	
	@PostConstruct
	public void init()
	{
		solicitudPendienteSeleccionada = new SolicitudDeGastos();
		listaSolicitudesPendientes = new ArrayList<SolicitudDeGastos>();
		listaSolicitudesPendientes = solicitudDeGastosService.listarSolicitudesPendientes();
			
	}
	
	public String aprobarSolicitud(){
		solicitudPendienteSeleccionada = (SolicitudDeGastos)  tablaSolicitudesPendientes.getRowData();
		return "aprobarSolicitud";
	}

	public String rechazarSolicitud(){
		solicitudPendienteSeleccionada = (SolicitudDeGastos)  tablaSolicitudesPendientes.getRowData();
		return "rechazarSolicitud";
	}
	
	
	public void listarSolicitudes(){
		listaSolicitudesPendientes = solicitudDeGastosService.listarSolicitudesPendientes();
	}
	/**
	 * @return the tablaSolicitudesPendientes
	 */
	public HtmlDataTable getTablaSolicitudesPendientes() {
		return tablaSolicitudesPendientes;
	}

	/**
	 * @param tablaSolicitudesPendientes the tablaSolicitudesPendientes to set
	 */
	public void setTablaSolicitudesPendientes(
			HtmlDataTable tablaSolicitudesPendientes) {
		this.tablaSolicitudesPendientes = tablaSolicitudesPendientes;
	}

	/**
	 * @return the comentario
	 */
	public HtmlInputTextarea getComentario() {
		return comentario;
	}

	/**
	 * @param comentario the comentario to set
	 */
	public void setComentario(HtmlInputTextarea comentario) {
		this.comentario = comentario;
	}

	/**
	 * @return the solicitudPendienteSeleccionada
	 */
	public SolicitudDeGastos getSolicitudPendienteSeleccionada() {
		return solicitudPendienteSeleccionada;
	}

	/**
	 * @param solicitudPendienteSeleccionada the solicitudPendienteSeleccionada to set
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
	 * @param listaSolicitudesPendientes the listaSolicitudesPendientes to set
	 */
	public void setListaSolicitudesPendientes(
			List<SolicitudDeGastos> listaSolicitudesPendientes) {
		this.listaSolicitudesPendientes = listaSolicitudesPendientes;
	}

	/**
	 * @return the usuarioService
	 */
	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	/**
	 * @param usuarioService the usuarioService to set
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
	 * @param solicitudDeGastosService the solicitudDeGastosService to set
	 */
	public void setSolicitudDeGastosService(
			SolicitudDeGastosService solicitudDeGastosService) {
		this.solicitudDeGastosService = solicitudDeGastosService;
	}
	
	
}
