package ar.edu.utn.frsf.tpae.a2013.g05.service;

import java.util.List;

import ar.edu.utn.frsf.tpae.a2013.g05.model.CentroDeCosto;

/**
 * Interfaz que define las operaciones que debe proveer el servicio de Centros
 * de Costo.
 * 
 * @author Dario
 * 
 */
public interface CentroDeCostoService {

	/**
	 * Metodo encargado de listar los centros de costos
	 * 
	 * @return Lista que contiene todos los centros de costo
	 */
	public List<CentroDeCosto> listarCentrosDeCosto();

}
