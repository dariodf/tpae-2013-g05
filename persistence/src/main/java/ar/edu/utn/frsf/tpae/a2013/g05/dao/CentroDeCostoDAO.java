package ar.edu.utn.frsf.tpae.a2013.g05.dao;

import java.util.List;

import ar.edu.utn.frsf.tpae.a2013.g05.model.CentroDeCosto;

/**
 * @author Dario
 * 
 */
public interface CentroDeCostoDAO {

	/**
	 * Busca y retorna la lista completa de centros de costo de la empresa.
	 * 
	 * @return Lista de los centros de costo.
	 */
	List<CentroDeCosto> listarCentrosDeCosto();

}
