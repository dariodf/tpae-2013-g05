package ar.edu.utn.frsf.tpae.a2013.g05.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.utn.frsf.tpae.a2013.g05.dao.CentroDeCostoDAO;
import ar.edu.utn.frsf.tpae.a2013.g05.model.CentroDeCosto;
import ar.edu.utn.frsf.tpae.a2013.g05.service.CentroDeCostoService;

/**
 * @author Dario
 * 
 */
public class CentroDeCostoServiceImpl implements CentroDeCostoService {

	private CentroDeCostoDAO centroDeCostoDAO;

	// Setter utilizado por Spring.
	@Autowired(required = true)
	public void setCentroDeCostoDAO(CentroDeCostoDAO centroDeCostoDAO) {
		this.centroDeCostoDAO = centroDeCostoDAO;
	}

	@Override
	public List<CentroDeCosto> listarCentrosDeCosto() {
		return centroDeCostoDAO.listarCentrosDeCosto();
	}

}
