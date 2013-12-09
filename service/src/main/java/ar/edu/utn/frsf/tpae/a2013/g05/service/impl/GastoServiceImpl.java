package ar.edu.utn.frsf.tpae.a2013.g05.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.utn.frsf.tpae.a2013.g05.dao.CentroDeCostoDAO;
import ar.edu.utn.frsf.tpae.a2013.g05.dao.GastoDAO;
import ar.edu.utn.frsf.tpae.a2013.g05.dao.SolicitudDeGastosDAO;
import ar.edu.utn.frsf.tpae.a2013.g05.dao.UsuarioDAO;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Usuario;
import ar.edu.utn.frsf.tpae.a2013.g05.service.GastoService;

/**
 * Implementación del servicio para Gasto. Incluye el manejo de las solicitudes
 * de gasto y de los centros de costo.
 * 
 * @author Daniela
 */
public class GastoServiceImpl implements GastoService {

	private GastoDAO gastoDAO;

	private SolicitudDeGastosDAO solicitudDeGastosDAO;

	private CentroDeCostoDAO centroDeCostoDAO;

	// Setter utilizado por Spring.
	@Autowired(required = true)
	public void setGastoDao(GastoDAO gastoDAO) {
		this.gastoDAO = gastoDAO;
	}

	// Setter utilizado por Spring.
	@Autowired(required = true)
	public void setSolicitudDeGastosDAO(SolicitudDeGastosDAO solicitudDeGastosDAO) {
		this.solicitudDeGastosDAO = solicitudDeGastosDAO;
	}

	// Setter utilizado por Spring.
	@Autowired(required = true)
	public void setCentroDeCostoDAO(CentroDeCostoDAO centroDeCostoDAO) {
		this.centroDeCostoDAO = centroDeCostoDAO;
	}


}
