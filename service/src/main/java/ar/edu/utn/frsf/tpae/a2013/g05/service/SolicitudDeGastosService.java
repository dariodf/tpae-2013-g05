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
	
}
