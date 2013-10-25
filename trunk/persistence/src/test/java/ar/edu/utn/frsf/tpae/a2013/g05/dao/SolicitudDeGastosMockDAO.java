/**
 * 
 */
package ar.edu.utn.frsf.tpae.a2013.g05.dao;

import java.util.List;

import ar.edu.utn.frsf.tpae.a2013.g05.model.SolicitudDeGastos;

/**
 * @author root
 *
 */
public class SolicitudDeGastosMockDAO implements SolicitudDeGastosDAO {

	@Override
	public SolicitudDeGastos persistir(SolicitudDeGastos solicitudDeGastos) {
		// TODO Crear el mock para persistir una solicitud de gastos
		return null;
	}

	@Override
	public List<SolicitudDeGastos> listarSolicitudesPendientes(int idEmpleado) {
		// TODO Crear el mock para listar las solicitudes pendientes
		return null;
	}

	@Override
	public List<SolicitudDeGastos> listarSolicitudes(int idEmpleado) {
		// TODO Crear el mock para listar las solicitudes
		return null;
	}

}
