/**
 * 
 */
package ar.edu.utn.frsf.tpae.a2013.g05.dao.factories;

import ar.edu.utn.frsf.tpae.a2013.g05.dao.GastoDAO;
import ar.edu.utn.frsf.tpae.a2013.g05.dao.mocks.GastoMockDAO;

/**
 * @author root
 *
 */
public class GastoDAOFactory {
	public static GastoDAO getGastoDAO(){
		return new GastoMockDAO();
	}
}
