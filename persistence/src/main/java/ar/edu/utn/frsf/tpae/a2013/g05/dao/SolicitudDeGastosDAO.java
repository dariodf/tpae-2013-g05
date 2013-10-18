/**
 * 
 */
package ar.edu.utn.frsf.tpae.a2013.g05.dao;

import java.util.List;

import ar.edu.utn.frsf.tpae.a2013.g05.model.SolicitudDeGastos;

/**
 * @author root
 *
 */
public interface SolicitudDeGastosDAO {

	/**
	 * Crea o modifica una solicitud de gastos. Si el identificador tiene el valor
	 * <code>null</code>, se trata de una operaci�n de creaci�n. En caso
	 * contrario, modificaci�n.
	 * 
	 * @param solicitudDeGastos
	 *            La solicitud de gastos a crear o modificar.
	 * @return La solicitud de gastos persistida, con sus campos actualizados. El el caso de
	 *         una operaci�n de creaci�n, el objeto retornado tendr� seteado el
	 *         identificador.
	 */
	SolicitudDeGastos persistir(SolicitudDeGastos solicitudDeGastos);

	/**
	 * Obtiene la lista de todas las solicitudes de gastos creadas por un empleado.
	 * @param idEmpleado
	 *            El n�mero identificador del empleado creador de las solicitudes de gastos.
	 * @return La lista de todas las solicitudes de gastos creadas por un empleado.
	 */
	List<SolicitudDeGastos> listar(int idEmpleado);
	

	
	
	
}
