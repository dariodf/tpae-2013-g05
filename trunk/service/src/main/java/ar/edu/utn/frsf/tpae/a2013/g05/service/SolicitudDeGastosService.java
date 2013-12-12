package ar.edu.utn.frsf.tpae.a2013.g05.service;

import ar.edu.utn.frsf.tpae.a2013.g05.model.SolicitudDeGastos;

import java.util.List;

/**
 * Interfaz que define las operaciones que debe proveer el servicio de
 * Solicitudes De Gastos.
 * 
 * @author Dario
 * 
 */
public interface SolicitudDeGastosService {

	/**
	 * Permite crear una nueva solicitud de aprobación de gasto.
	 * 
	 * @param solicitudDeGastos
	 *            la solicitudDeGastos a crear.
	 * @return el usuario creado.
	 */
	void crearSolicitudAprobacion(SolicitudDeGastos solicitudDeGastos);

	/**
	 * Metodo encargado de listar todas las solicitudes de gastos pendientes
	 * 
	 * @return Una lista con las solicitudes de gastos pendientes
	 */
	public List<SolicitudDeGastos> listarSolicitudesPendientes();

	
	/**
	 * Metodo encargado de listar todas las solicitudes de un empleado especifico
	 * @param idEmpleado id del empleado del cual se quiere listar las solicitudes
	 * @return lista de solicitudes del empleado en cuestion
	 */
	public List<SolicitudDeGastos> listarSolicitudes(int idEmpleado);
}

