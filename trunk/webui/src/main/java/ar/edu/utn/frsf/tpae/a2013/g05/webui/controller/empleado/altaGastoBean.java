package ar.edu.utn.frsf.tpae.a2013.g05.webui.controller.empleado;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlInputText;


import ar.edu.utn.frsf.tpae.a2013.g05.model.Gasto;
import ar.edu.utn.frsf.tpae.a2013.g05.model.SolicitudDeGastos;
import ar.edu.utn.frsf.tpae.a2013.g05.service.GastoService;
import ar.edu.utn.frsf.tpae.a2013.g05.service.SolicitudDeGastosService;
import ar.edu.utn.frsf.tpae.a2013.g05.service.UsuarioService;

/**
 * Managed bean que actua como modelo para la vista "altaGasto.xhtml"
 * brindando lógica de controlador y siendo el punto de contacto con la capa de
 * servicios.
 * 
 * @author Dario
 */
@ManagedBean(name = "altaGastoBean")
@SessionScoped
public class altaGastoBean implements Serializable {

	private static final long serialVersionUID = 4060209977273827362L;
	
	// DI via Spring
	@ManagedProperty(value = "#{usuarioService}")
	UsuarioService usuarioService;
	
	// DI via Spring
	@ManagedProperty(value = "#{solicitudDeGastosService}")
	SolicitudDeGastosService solicitudDeGastosService;
	
	// DI via Spring
	@ManagedProperty(value = "#{gastoService}")
	GastoService gastoService;
	
	private HtmlDataTable tablaSolicitudAprobada;
	private HtmlInputText inputFechaRealizacionGasto;
	private HtmlInputText inputImporteGasto;
	private HtmlInputText inputNumeroTicketGasto;
	
	private Gasto gasto;
	private Date fechaRealizacionGasto;
	private float importeGasto;
	private String numeroTicketGasto;
	
	
	@PostConstruct
	public void init()
	{
		/*
		 * Inicializa las variables para que no haya punteros nulos y trae las solicitudes de gastos
		 */
		gasto = new Gasto();
		
	}
	
	public String crearGasto(){
		gasto.setFechaAlta(new Date());
		gasto.setFechaRealizacion(fechaRealizacionGasto);
		gasto.setImporte(importeGasto);
		gasto.setNroFactura(numeroTicketGasto);
		gasto.setSolicitudDeGastos((SolicitudDeGastos) tablaSolicitudAprobada.getRowData());
		
		gastoService.crearGasto(gasto);
		return volverAtras();
		
	}
	
	public String volverAtras(){
		importeGasto = 0;
		numeroTicketGasto = "";
		inputFechaRealizacionGasto.clearInitialState();
		inputFechaRealizacionGasto.resetValue();
		inputImporteGasto.clearInitialState();
		inputNumeroTicketGasto.clearInitialState();
		return "verSolicitudesPendientes";		
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
	 * @return the gastoService
	 */
	public GastoService getGastoService() {
		return gastoService;
	}

	/**
	 * @param gastoService the gastoService to set
	 */
	public void setGastoService(GastoService gastoService) {
		this.gastoService = gastoService;
	}

	/**
	 * @return the tablaSolicitudAprobada
	 */
	public HtmlDataTable getTablaSolicitudAprobada() {
		return tablaSolicitudAprobada;
	}

	/**
	 * @param tablaSolicitudAprobada the tablaSolicitudAprobada to set
	 */
	public void setTablaSolicitudAprobada(HtmlDataTable tablaSolicitudAprobada) {
		this.tablaSolicitudAprobada = tablaSolicitudAprobada;
	}

	/**
	 * @return the inputFechaRealizacionGasto
	 */
	public HtmlInputText getInputFechaRealizacionGasto() {
		return inputFechaRealizacionGasto;
	}

	/**
	 * @param inputFechaRealizacionGasto the inputFechaRealizacionGasto to set
	 */
	public void setInputFechaRealizacionGasto(
			HtmlInputText inputFechaRealizacionGasto) {
		this.inputFechaRealizacionGasto = inputFechaRealizacionGasto;
	}

	/**
	 * @return the inputImporteGasto
	 */
	public HtmlInputText getInputImporteGasto() {
		return inputImporteGasto;
	}

	/**
	 * @param inputImporteGasto the inputImporteGasto to set
	 */
	public void setInputImporteGasto(HtmlInputText inputImporteGasto) {
		this.inputImporteGasto = inputImporteGasto;
	}

	/**
	 * @return the inputNumeroTicketGasto
	 */
	public HtmlInputText getInputNumeroTicketGasto() {
		return inputNumeroTicketGasto;
	}

	/**
	 * @param inputNumeroTicketGasto the inputNumeroTicketGasto to set
	 */
	public void setInputNumeroTicketGasto(HtmlInputText inputNumeroTicketGasto) {
		this.inputNumeroTicketGasto = inputNumeroTicketGasto;
	}

	/**
	 * @return the fechaRealizacionGasto
	 */
	public Date getFechaRealizacionGasto() {
		return fechaRealizacionGasto;
	}

	/**
	 * @param fechaRealizacionGasto the fechaRealizacionGasto to set
	 */
	public void setFechaRealizacionGasto(Date fechaRealizacionGasto) {
		this.fechaRealizacionGasto = fechaRealizacionGasto;
	}

	/**
	 * @return the importeGasto
	 */
	public float getImporteGasto() {
		return importeGasto;
	}

	/**
	 * @param importeGasto the importeGasto to set
	 */
	public void setImporteGasto(float importeGasto) {
		this.importeGasto = importeGasto;
	}

	/**
	 * @return the numeroTicketGasto
	 */
	public String getNumeroTicketGasto() {
		return numeroTicketGasto;
	}

	/**
	 * @param numeroTicketGasto the numeroTicketGasto to set
	 */
	public void setNumeroTicketGasto(String numeroTicketGasto) {
		this.numeroTicketGasto = numeroTicketGasto;
	}

	/**
	 * @return the gasto
	 */
	public Gasto getGasto() {
		return gasto;
	}

	/**
	 * @param gasto the gasto to set
	 */
	public void setGasto(Gasto gasto) {
		this.gasto = gasto;
	}
	
	
	
}
