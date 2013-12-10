package ar.edu.utn.frsf.tpae.a2013.g05.dao;

import java.util.List;

import ar.edu.utn.frsf.tpae.a2013.g05.model.Gasto;
import ar.edu.utn.frsf.tpae.a2013.g05.model.CentroDeCosto;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Empleado;

/**
 * Interfaz que define las operaciones que debe proveer un DAO de Gasto.
 * 
 * @author Agustín
 */
public interface GastoDAO {

	/**
	 * Crea o modifica un gasto. Si el identificador tiene el valor
	 * <code>null</code>, se trata de una operación de creación. En caso
	 * contrario, modificación.
	 * 
	 * @param gasto
	 *            El gasto a crear o modificar.
	 * @return El gasto persistido, con sus campos actualizados. En el caso de
	 *         una operación de creación, el objeto retornado tendrá seteado el
	 *         identificador.
	 */
	Gasto persistir(Gasto gasto);

	/**
	 * Lista los gatos pertenecientes a los centros de costos y los empleados
	 * seleccionados. En el caso de que los parametros sean nulos, se retornan
	 * todos los gastos.
	 * 
	 * @param centroDeCosto
	 *            centros de costo para los cuales se desea generar el listado
	 * @param empleado
	 *            empleado para el cual se desea generar el listado
	 * @return
	 */
	List<Gasto> listarGastos(CentroDeCosto centroDeCosto, Empleado empleado);

}
