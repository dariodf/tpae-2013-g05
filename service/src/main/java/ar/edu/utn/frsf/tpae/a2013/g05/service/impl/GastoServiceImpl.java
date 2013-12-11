package ar.edu.utn.frsf.tpae.a2013.g05.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.utn.frsf.tpae.a2013.g05.dao.GastoDAO;
import ar.edu.utn.frsf.tpae.a2013.g05.model.CentroDeCosto;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Empleado;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Gasto;
import ar.edu.utn.frsf.tpae.a2013.g05.service.GastoService;

/**
 * Implementación del servicio para Gasto.
 * 
 * @author Daniela
 */
public class GastoServiceImpl implements GastoService {

	private GastoDAO gastoDAO;

	// Setter utilizado por Spring.
	@Autowired(required = true)
	public void setGastoDao(GastoDAO gastoDAO) {
		this.gastoDAO = gastoDAO;
	}

	@Override
	public List<Gasto> listarGastos(CentroDeCosto centroDeCosto, Empleado empleado) {
		return gastoDAO.listarGastos(centroDeCosto, empleado);
	}

	

}
