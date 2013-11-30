package ar.edu.utn.frsf.tpae.a2013.g05.webui.controller.login;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import ar.edu.utn.frsf.tpae.a2013.g05.service.UsuarioService;

/**
 * Managed bean que actua como modelo para la vista "login.xhtml" brindando lógica
 * de controlador y siendo el punto de contacto con la capa de servicios.
 * 
 * @author Daniela
 */
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

	// DI via Spring
	@ManagedProperty(value = "#{usuarioService}")
	UsuarioService usuarioService;

//	/** El usuario que se edita en "index.jsp". */
//	private Usuario usuario;
//
//	@PostConstruct
//	public void init() {
//		// Inicialización de variables usadas en las JSP, para evitar punteros
//		// nulos.
//		// usuario = new Empleado();
//	}
//
//	/**
//	 * Permite que un usuario existente en la base de datos pueda loguearse al
//	 * sistema de gestión de operaciones Guarda una factura con los datos
//	 * ingresados en "index.jsp", invocando al servicio correspondiente.
//	 * 
//	 * @return <code>null</code> para permanecer en la misma página.
//	 */
//	public String guardar() {
//		// el service locator es un patron que se puede usar si no se quiere
//		// configurar directamente
//		// a spring como el motor de resolucion de DI y de EL sino como una
//		// alternativa
//		// FacturacionService service = ServiceLocator.getFacturacionService();
//		List<Factura> facturas = new ArrayList<Factura>();
//		facturas.add(this.factura);
//		facturacionService.crear(facturas);
//
//		// Se retorna null para permanecer en la misma página.
//		return null;
//	}
//
//	/**
//	 * Guarda en el atributo <code>listaFacturas</code> los resultados de la
//	 * búsqueda realizada utilizando los valores de los campos de búsquedade
//	 * "listaFacturas.jsp".
//	 * 
//	 * @return <code>null</code> para permanecer en la misma página.
//	 */
//	public String buscar() {
//
//		System.out.println("se ejecuta el buscar");
//		// FacturacionService service = ServiceLocator.getFacturacionService();
//		this.listaFacturas = facturacionService.listar();
//		int indice = 0;
//		if (this.listaFacturas != null && this.precioBusqueda != null) {
//			// TODO Utilizar los campos de búsqueda como criterios de filtrado
//			// en la capa de servicio y DAO
//			for (Factura f : this.listaFacturas) {
//				if (f.getPrecioTotal() < this.precioBusqueda)
//					this.listaFacturas.remove(indice);
//				indice++;
//			}
//		}
//		// Se retorna null para permanecer en la misma página.
//		return null;
//	}
//
//	// Getters y setters, utilizados por las JSP.
//
//	public Factura getFactura() {
//		return factura;
//	}
//
//	public void setFactura(Factura factura) {
//		System.out.println("SE EJECUTA EL SET FACTURA");
//		this.factura = factura;
//	}
//
//	public FacturacionService getFacturacionService() {
//		return facturacionService;
//	}
//
//	public void setFacturacionService(FacturacionService facturacionService) {
//		this.facturacionService = facturacionService;
//	}
//
//	public Integer getIdFacturaSeleccionada() {
//		return idFacturaSeleccionada;
//	}
//
//	public void setIdFacturaSeleccionada(Integer idFacturaSeleccionada) {
//		this.idFacturaSeleccionada = idFacturaSeleccionada;
//	}
}
