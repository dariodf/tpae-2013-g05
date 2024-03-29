package ar.edu.utn.frsf.tpae.a2013.g05.dao;

import java.util.List;

import ar.edu.utn.frsf.tpae.a2013.g05.model.SolicitudDeGastos;

/**
 * Interfaz que define las operaciones que debe proveer un DAO de Solicitud de
 * gasto.
 * 
 * @author Agust�n
 */
public interface SolicitudDeGastosDAO {

	/**
	 * Crea o modifica una solicitud de gastos. 
	 * 
	 * @param solicitudDeGastos
	 *            La solicitud de gastos a crear o modificar.
	 * @return La solicitud de gastos persistida, con sus campos actualizados.
	 *         El el caso de una operaci�n de creaci�n, el objeto retornado
	 *         tendr� seteado el identificador.
	 */
	SolicitudDeGastos persistir(SolicitudDeGastos solicitudDeGastos);

	/**
	 * Obtiene la lista de todas las solicitudes de gastos pendientes de un
	 * empleado. Es decir, aquellas no procesadas.
	 * 
	 * @param idEmpleado
	 *            El n�mero identificador del empleado creador de las
	 *            solicitudes de gastos.
	 * @return La lista de todas las solicitudes de gastos pendientes de un
	 *         empleado.
	 */
	List<SolicitudDeGastos> listarSolicitudesPendientes(int idEmpleado);

	/**
	 * Obtiene la lista de todas las solicitudes de gastos de un empleado. Es
	 * decir: aprobadas, rechazadas y no procesadas
	 * 
	 * @param idEmpleado
	 *            El n�mero identificador del empleado creador de las
	 *            solicitudes de gastos.
	 * @return La lista de todas las solicitudes de gastos pendientes de un
	 *         empleado.
	 */
	List<SolicitudDeGastos> listarSolicitudes(int idEmpleado);
	
	/**
	 * Obtiene la lista de todas las solicitudes de gastos pendientes de un. 
	 * Es decir, aquellas no procesadas.
	 * @return La lista de todas las solicitudes de gastos pendientes
	 */
	List<SolicitudDeGastos> listarSolicitudesPendientes();

}
