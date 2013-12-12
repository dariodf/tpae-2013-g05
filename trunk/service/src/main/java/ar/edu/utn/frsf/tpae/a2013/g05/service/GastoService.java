package ar.edu.utn.frsf.tpae.a2013.g05.service;

import java.util.List;

import ar.edu.utn.frsf.tpae.a2013.g05.model.CentroDeCosto;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Empleado;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Gasto;

/**
 * Interfaz que define las operaciones que debe proveer el servicio de gasto.
 * 
 */
public interface GastoService {

	/**
	 * Genera la lista de Gastos según el Centro de Costo y Empleado
	 * seleccionados.
	 * 
	 * @param centrosDeCosto
	 *            Centro de Costo seleccionado.
	 * @param empleado
	 *            Empleado seleccionado.
	 * @return Lista de los gastos que cumplen los criterios seleccionados.
	 */
	public List<Gasto> listarGastos(CentroDeCosto centroDeCosto, Empleado empleado);

	/**
	 * Metodo encargado de persistir un gasto en la base de datos
	 * 
	 * @param gasto
	 *            el gasto a persistir
	 */
	public void agregarGasto(Gasto gasto);

}
