/**
 * 
 */
package ar.edu.utn.frsf.tpae.a2013.g05.webui.controller.supervisor;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlSelectOneMenu;


import ar.edu.utn.frsf.tpae.a2013.g05.model.CentroDeCosto;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Empleado;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Gasto;
import ar.edu.utn.frsf.tpae.a2013.g05.service.CentroDeCostoService;
import ar.edu.utn.frsf.tpae.a2013.g05.service.GastoService;
import ar.edu.utn.frsf.tpae.a2013.g05.service.UsuarioService;

/**
 * Managed bean que actua como modelo para la vista "supervisor/consultar.xhtml" brindando
 * lógica de controlador y siendo el punto de contacto con la capa de servicios.
 * 
 * @author Dario
 */
@ManagedBean(name = "consultarGastosBean")
@SessionScoped
public class ConsultarGastosBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2621590729713912608L;

	List<Gasto> listaDeGastos;
	
	private List<CentroDeCosto> centrosDeCosto;
	private String centroDeCostoSeleccionado;
	
	private List<Empleado> empleados;
	private String empleadoSeleccionado;
	
	private HtmlSelectOneMenu centroDeCosto;
	private HtmlSelectOneMenu empleado;
	
	// DI via Spring
	@ManagedProperty(value = "#{usuarioService}")
	UsuarioService usuarioService;

	// DI via Spring
	@ManagedProperty(value = "#{centroDeCostoService}")
	CentroDeCostoService centroDeCostoService;
	
	// DI via Springs
	@ManagedProperty(value = "#{gastoService}")
	GastoService gastoService;
	
	@PostConstruct
	public void init()
	{
		centrosDeCosto = centroDeCostoService.listarCentrosDeCosto();		
		empleados = usuarioService.listarEmpleados();
	}

	public void consultar() {
		CentroDeCosto centroSel = null;
		if (centroDeCostoSeleccionado != "")
			for(CentroDeCosto centro : centrosDeCosto)
				if (centro.getId() == Integer.parseInt(centroDeCostoSeleccionado)) centroSel=centro;
		
		Empleado empleadoSel = null;
		if (empleadoSeleccionado!= "")
			for(Empleado empleado : empleados)
				if (empleado.getId() == Integer.parseInt(empleadoSeleccionado)) empleadoSel=empleado;
		
		listaDeGastos = gastoService.listarGastos(centroSel, empleadoSel);

	}
	
	/**
	 * @return the centrosDeCosto
	 */
	public List<CentroDeCosto> getCentrosDeCosto() {
		return centrosDeCosto;
	}

	/**
	 * @param centrosDeCosto the centrosDeCosto to set
	 */
	public void setCentrosDeCosto(List<CentroDeCosto> centrosDeCosto) {
		this.centrosDeCosto = centrosDeCosto;
	}

	/**
	 * @return the centroDeCostoSeleccionado
	 */
	public String getCentroDeCostoSeleccionado() {
		return centroDeCostoSeleccionado;
	}

	/**
	 * @param centroDeCostoSeleccionado the centroDeCostoSeleccionado to set
	 */
	public void setCentroDeCostoSeleccionado(String centroDeCostoSeleccionado) {
		this.centroDeCostoSeleccionado = centroDeCostoSeleccionado;
	}

	/**
	 * @return the centroDeCosto
	 */
	public HtmlSelectOneMenu getCentroDeCosto() {
		return centroDeCosto;
	}

	/**
	 * @param centroDeCosto the centroDeCosto to set
	 */
	public void setCentroDeCosto(HtmlSelectOneMenu centroDeCosto) {
		this.centroDeCosto = centroDeCosto;
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
	 * @return the centroDeCostoService
	 */
	public CentroDeCostoService getCentroDeCostoService() {
		return centroDeCostoService;
	}

	/**
	 * @param centroDeCostoService the centroDeCostoService to set
	 */
	public void setCentroDeCostoService(CentroDeCostoService centroDeCostoService) {
		this.centroDeCostoService = centroDeCostoService;
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
	 * @return the empleados
	 */
	public List<Empleado> getEmpleados() {
		return empleados;
	}

	/**
	 * @param empleados the empleados to set
	 */
	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	/**
	 * @return the empleadoSeleccionado
	 */
	public String getEmpleadoSeleccionado() {
		return empleadoSeleccionado;
	}

	/**
	 * @param empleadoSeleccionado the empleadoSeleccionado to set
	 */
	public void setEmpleadoSeleccionado(String empleadoSeleccionado) {
		this.empleadoSeleccionado = empleadoSeleccionado;
	}

	/**
	 * @return the empleado
	 */
	public HtmlSelectOneMenu getEmpleado() {
		return empleado;
	}

	/**
	 * @param empleado the empleado to set
	 */
	public void setEmpleado(HtmlSelectOneMenu empleado) {
		this.empleado = empleado;
	}

	/**
	 * @return the listaDeGastos
	 */
	public List<Gasto> getListaDeGastos() {
		return listaDeGastos;
	}

	/**
	 * @param listaDeGastos the listaDeGastos to set
	 */
	public void setListaDeGastos(List<Gasto> listaDeGastos) {
		this.listaDeGastos = listaDeGastos;
	}
	
	

	
}
