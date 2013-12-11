/**
 * 
 */
package ar.edu.utn.frsf.tpae.a2013.g05.service;

import java.util.List;

import ar.edu.utn.frsf.tpae.a2013.g05.model.SolicitudDeGastos;

/**
 * Interfaz que define las operaciones que debe proveer el servicio de Solicitudes De Gastos.
 * 
 * @author Dario
 *
 */
public interface SolicitudDeGastosService {
	
	/**
	 * Metodo encargado de listar todas las solicitudes de gastos pendientes
	 * @return Una lista con las solicitudes de gastos pendientes
	 */
	public List<SolicitudDeGastos> listarSolicitudesPendientes();
	
	/**
	 * Metodo encargado de persistir una solicitud de gastos en la base de datos 
	 * o de modificar una existente en caso de que la misma ya se encuentre en la base de datos
	 * @param solicitudDeGastos La solicitud de gastos a persistir
	 */
	public void crearSolicitudAprobacion(SolicitudDeGastos solicitudDeGastos);
}

