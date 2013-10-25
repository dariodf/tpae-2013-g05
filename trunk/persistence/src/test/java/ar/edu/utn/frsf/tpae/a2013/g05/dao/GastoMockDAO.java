/**
 * 
 */
package ar.edu.utn.frsf.tpae.a2013.g05.dao;

import java.util.List;

import ar.edu.utn.frsf.tpae.a2013.g05.model.CentroDeCosto;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Empleado;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Gasto;

/**
 * @author root
 *
 */
public class GastoMockDAO implements GastoDAO{

	@Override
	public Gasto persistir(int idGasto) {
		// TODO Crear el mock para la devolucion de la persistencia de un gasto
		return null;
	}

	@Override
	public List<Gasto> listarGastos(List<CentroDeCosto> centrosDeCosto,
			List<Empleado> empleados) {
		// TODO Crear el mock para el listado de gastos
		return null;
	}
	
}
