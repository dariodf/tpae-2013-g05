/**
 * 
 */
package ar.edu.utn.frsf.tpae.a2013.g05.webui.controller.empleado;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlDataTable;

import ar.edu.utn.frsf.tpae.a2013.g05.model.Constantes;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Empleado;
import ar.edu.utn.frsf.tpae.a2013.g05.model.SolicitudDeGastos;
import ar.edu.utn.frsf.tpae.a2013.g05.service.SolicitudDeGastosService;
import ar.edu.utn.frsf.tpae.a2013.g05.service.UsuarioService;

/**
 * Managed bean que actua como modelo para la vista "verSolicitudesPendientes.xhtml"
 * brindando lógica de controlador y siendo el punto de contacto con la capa de
 * servicios.
 * 
 * @author Agustín
 *
 */
@ManagedBean(name = "solicitudesEmpleadoBean")
@SessionScoped
public class SolicitudesEmpleadoBean implements Serializable {

	private static final long serialVersionUID = 4791121292514415811L;

	// DI via Spring
	@ManagedProperty(value = "#{usuarioService}")
	UsuarioService usuarioService;
	
	// DI via Spring
	@ManagedProperty(value = "#{solicitudDeGastosService}")
	SolicitudDeGastosService solicitudDeGastosService;
	
	private HtmlDataTable tablaSolicitudesPendientes;
	private HtmlDataTable tablaSolicitudesAprobadas;
	private HtmlDataTable tablaSolicitudesRechazadas;
	private List<SolicitudDeGastos> listaSolicitudesPendientes;
	private List<SolicitudDeGastos> listaSolicitudesAprobadas;
	private List<SolicitudDeGastos> listaSolicitudesRechazadas;
	private SolicitudDeGastos solicitudAprobadaSeleccionada;
	
	
	@PostConstruct
	public void init()
	{
		/*
		 * Inicializa las variables para que no haya punteros nulos y trae las solicitudes de gastos
		 */
		solicitudAprobadaSeleccionada = new SolicitudDeGastos();
		listaSolicitudesPendientes = new ArrayList<SolicitudDeGastos>();
		listaSolicitudesAprobadas =  new ArrayList<SolicitudDeGastos>();
		listaSolicitudesRechazadas =  new ArrayList<SolicitudDeGastos>();
		
		
		Empleado usuarioLogueado = (Empleado) usuarioService.getUsuarioLogueado();
		
		List<SolicitudDeGastos> solicitudesEmpleado = solicitudDeGastosService.listarSolicitudes(usuarioLogueado.getId());
		
		// Separa las solicitudes en tres listas distintas dependiendo su tipo
		for (SolicitudDeGastos solicitudDeGastos : solicitudesEmpleado){
			if(solicitudDeGastos.getEstado().compareTo(Constantes.PENDIENTE.name()) == 0)
				listaSolicitudesPendientes.add(solicitudDeGastos);
			else if(solicitudDeGastos.getEstado().compareTo(Constantes.APROBADA.name()) == 0)
				listaSolicitudesAprobadas.add(solicitudDeGastos);
			else
				listaSolicitudesRechazadas.add(solicitudDeGastos);
		}
	}
	
	public String irDarAlta(){
		solicitudAprobadaSeleccionada = (SolicitudDeGastos) tablaSolicitudesAprobadas.getRowData();
		return "altaGasto";
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
	 * @return the tablaSolicitudesAprobadas
	 */
	public HtmlDataTable getTablaSolicitudesAprobadas() {
		return tablaSolicitudesAprobadas;
	}

	/**
	 * @param tablaSolicitudesAprobadas the tablaSolicitudesAprobadas to set
	 */
	public void setTablaSolicitudesAprobadas(HtmlDataTable tablaSolicitudesAprobadas) {
		this.tablaSolicitudesAprobadas = tablaSolicitudesAprobadas;
	}

	/**
	 * @return the tablaSolicitudesRechazadas
	 */
	public HtmlDataTable getTablaSolicitudesRechazadas() {
		return tablaSolicitudesRechazadas;
	}

	/**
	 * @param tablaSolicitudesRechazadas the tablaSolicitudesRechazadas to set
	 */
	public void setTablaSolicitudesRechazadas(
			HtmlDataTable tablaSolicitudesRechazadas) {
		this.tablaSolicitudesRechazadas = tablaSolicitudesRechazadas;
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
	 * @return the listaSolicitudesAprobadas
	 */
	public List<SolicitudDeGastos> getListaSolicitudesAprobadas() {
		return listaSolicitudesAprobadas;
	}

	/**
	 * @param listaSolicitudesAprobadas the listaSolicitudesAprobadas to set
	 */
	public void setListaSolicitudesAprobadas(
			List<SolicitudDeGastos> listaSolicitudesAprobadas) {
		this.listaSolicitudesAprobadas = listaSolicitudesAprobadas;
	}

	/**
	 * @return the listaSolicitudesRechazadas
	 */
	public List<SolicitudDeGastos> getListaSolicitudesRechazadas() {
		return listaSolicitudesRechazadas;
	}

	/**
	 * @param listaSolicitudesRechazadas the listaSolicitudesRechazadas to set
	 */
	public void setListaSolicitudesRechazadas(
			List<SolicitudDeGastos> listaSolicitudesRechazadas) {
		this.listaSolicitudesRechazadas = listaSolicitudesRechazadas;
	}

	/**
	 * @return the solicitudAprobadaSeleccionada
	 */
	public SolicitudDeGastos getSolicitudAprobadaSeleccionada() {
		return solicitudAprobadaSeleccionada;
	}

	/**
	 * @param solicitudAprobadaSeleccionada the solicitudAprobadaSeleccionada to set
	 */
	public void setSolicitudAprobadaSeleccionada(
			SolicitudDeGastos solicitudAprobadaSeleccionada) {
		this.solicitudAprobadaSeleccionada = solicitudAprobadaSeleccionada;
	}
	
	
}
