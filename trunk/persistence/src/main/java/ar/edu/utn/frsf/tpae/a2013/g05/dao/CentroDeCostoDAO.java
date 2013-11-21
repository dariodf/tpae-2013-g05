package ar.edu.utn.frsf.tpae.a2013.g05.dao;

import java.util.List;

import ar.edu.utn.frsf.tpae.a2013.g05.model.CentroDeCosto;

/**
 * Interfaz que define las operaciones que debe proveer un DAO de Centro de
 * Costo.
 * 
 * @author Dario
 */
public interface CentroDeCostoDAO {

	/**
	 * Busca y retorna la lista completa de centros de costo de la empresa.
	 * 
	 * @return Lista de los centros de costo.
	 */
	List<CentroDeCosto> listarCentrosDeCosto();

}
