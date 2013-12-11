package ar.edu.utn.frsf.tpae.a2013.g05.webui.controller.supervisor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import ar.edu.utn.frsf.tpae.a2013.g05.model.CentroDeCosto;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Empleado;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Gasto;
import ar.edu.utn.frsf.tpae.a2013.g05.service.CentroDeCostoService;
import ar.edu.utn.frsf.tpae.a2013.g05.service.GastoService;
import ar.edu.utn.frsf.tpae.a2013.g05.service.UsuarioService;

/**
 * Managed bean que actua como modelo para la vista "supervisor/consultar.xhtml"
 * brindando lógica de controlador y siendo el punto de contacto con la capa de
 * servicios.
 * 
 * @author Dario
 */
@ManagedBean(name = "consultarGastosBean")
@SessionScoped
public class ConsultarGastosBean implements Serializable {

	private static final long serialVersionUID = -2621590729713912608L;

	private List<SelectItem> centrosDeCosto;
	private List<SelectItem> empleados;
	private List<Gasto> listaDeGastos;
	CentroDeCosto centroDeCostoSeleccionado;
	Empleado empleadoSeleccionado;
	Object nulo;

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
	public void init() {
		nulo = null;
		centrosDeCosto = new ArrayList<SelectItem>();
		empleados = new ArrayList<SelectItem>();
		listaDeGastos = new ArrayList<Gasto>();

		List<CentroDeCosto> listaCentrosDeCosto = centroDeCostoService.listarCentrosDeCosto();
		List<Empleado> listaEmpleados = usuarioService.listarEmpleados();

		for (int i = 0; i < listaEmpleados.size(); i++)
			empleados.add(new SelectItem(listaEmpleados.get(i), listaEmpleados.get(i).getNombre() + " "
					+ listaEmpleados.get(i).getApellido()));

		for (int i = 0; i < listaCentrosDeCosto.size(); i++)
			centrosDeCosto.add(new SelectItem(listaCentrosDeCosto.get(i), listaCentrosDeCosto.get(i).getNombre()));
	}

	public void consultar() {
		listaDeGastos = gastoService.listarGastos(centroDeCostoSeleccionado, empleadoSeleccionado);
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
	 * @return the gastoService
	 */
	public GastoService getGastoService() {
		return gastoService;
	}

	/**
	 * @param gastoService
	 *            the gastoService to set
	 */
	public void setGastoService(GastoService gastoService) {
		this.gastoService = gastoService;
	}

	/**
	 * @return the centrosDeCosto
	 */
	public List<SelectItem> getCentrosDeCosto() {
		return centrosDeCosto;
	}

	/**
	 * @param centrosDeCosto
	 *            the centrosDeCosto to set
	 */
	public void setCentrosDeCosto(ArrayList<SelectItem> centrosDeCosto) {
		this.centrosDeCosto = centrosDeCosto;
	}

	/**
	 * @return the empleados
	 */
	public List<SelectItem> getEmpleados() {
		return empleados;
	}

	/**
	 * @param empleados
	 *            the empleados to set
	 */
	public void setEmpleados(ArrayList<SelectItem> empleados) {
		this.empleados = empleados;
	}

	/**
	 * @return the listaDeGastos
	 */
	public List<Gasto> getListaDeGastos() {
		return listaDeGastos;
	}

	/**
	 * @param listaDeGastos
	 *            the listaDeGastos to set
	 */
	public void setListaDeGastos(List<Gasto> listaDeGastos) {
		this.listaDeGastos = listaDeGastos;
	}

	/**
	 * @return the centroDeCostoSeleccionado
	 */
	public CentroDeCosto getCentroDeCostoSeleccionado() {
		return centroDeCostoSeleccionado;
	}

	/**
	 * @param centroDeCostoSeleccionado
	 *            the centroDeCostoSeleccionado to set
	 */
	public void setCentroDeCostoSeleccionado(CentroDeCosto centroDeCostoSeleccionado) {
		this.centroDeCostoSeleccionado = centroDeCostoSeleccionado;
	}

	/**
	 * @return the empleadoSeleccionado
	 */
	public Empleado getEmpleadoSeleccionado() {
		return empleadoSeleccionado;
	}

	/**
	 * @param empleadoSeleccionado
	 *            the empleadoSeleccionado to set
	 */
	public void setEmpleadoSeleccionado(Empleado empleadoSeleccionado) {
		this.empleadoSeleccionado = empleadoSeleccionado;
	}

	/**
	 * @return the nulo
	 */
	public Object getNulo() {
		return nulo;
	}

	/**
	 * @param nulo
	 *            the nulo to set
	 */
	public void setNulo(Object nulo) {
		this.nulo = nulo;
	}

}
