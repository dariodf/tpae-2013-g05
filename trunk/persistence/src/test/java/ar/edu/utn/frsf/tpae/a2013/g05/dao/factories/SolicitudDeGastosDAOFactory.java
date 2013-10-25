/**
 * 
 */
package ar.edu.utn.frsf.tpae.a2013.g05.dao.factories;

import ar.edu.utn.frsf.tpae.a2013.g05.dao.SolicitudDeGastosDAO;
import ar.edu.utn.frsf.tpae.a2013.g05.dao.mocks.SolicitudDeGastosMockDAO;

/**
 * @author root
 *
 */
public class SolicitudDeGastosDAOFactory {
	public static SolicitudDeGastosDAO getSolicitudDeGastosDAO(){
		return new SolicitudDeGastosMockDAO();
	}
}
