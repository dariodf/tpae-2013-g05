/**
 * 
 */
package ar.edu.utn.frsf.tpae.a2013.g05.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.utn.frsf.tpae.a2013.g05.dao.GastoDAO;
import ar.edu.utn.frsf.tpae.a2013.g05.dao.SolicitudDeGastosDAO;
import ar.edu.utn.frsf.tpae.a2013.g05.model.SolicitudDeGastos;
import ar.edu.utn.frsf.tpae.a2013.g05.service.SolicitudDeGastosService;

/**
 * Implementacion del servicio para Solicitudes de Gastos
 * @author Dario
 *
 */
public class SolicitudDeGastosServiceImpl implements SolicitudDeGastosService {
	private SolicitudDeGastosDAO solicitudDeGastosDAO;
	
	// Setter utilizado por Spring.
	@Autowired(required = true)
	public void setSolicitudDeGastosDAO (SolicitudDeGastosDAO solicitudDeGastosDAO) {
		this.solicitudDeGastosDAO = solicitudDeGastosDAO;
	}

	@Override
	public List<SolicitudDeGastos> listarSolicitudesPendientes(){
		return solicitudDeGastosDAO.listarSolicitudesPendientes();
	}
}
