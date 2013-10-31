/**
 * 
 */
package ar.edu.utn.frsf.tpae.a2013.g05.dao;

import java.util.List;

import ar.edu.utn.frsf.tpae.a2013.g05.model.Gasto;
import ar.edu.utn.frsf.tpae.a2013.g05.model.CentroDeCosto;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Empleado;


/**
 * @author root
 *
 */
public interface GastoDAO {
	/**
	 * Crea o modifica una gasto Si el identificador tiene el valor
	 * <code>null</code>, se trata de una operaci�n de creaci�n. En caso
	 * contrario, modificaci�n.
	 * 
	 * @param gasto
	 *            El gasto a crear o modificar.
	 * @return El gasto persistido, con sus campos actualizados. El el caso de
	 *         una operaci�n de creaci�n, el objeto retornado tendr� seteado el
	 *         identificador.
	 */
	Gasto persistir(Gasto gasto);

	
	
	/**
	 * Lista los gatos pertenecientes a los centros de costos y los empleados seleccionados.
	 * En el caso de que los parametros sean nulos, se retornan todos los gastos.
	 * @param centrosDeCosto
	 * 		centros de costo para los cuales se desea generar el listado
	 * @param empleados
	 * 		empleados para los cuales se desea generar el listado
	 * @return
	 */
	List<Gasto> listarGastos(List<CentroDeCosto> centrosDeCosto,
			List<Empleado> empleados);
	
}
