/**
 * 
 */
package ar.edu.utn.frsf.tpae.a2013.g05.dao.factories;

import ar.edu.utn.frsf.tpae.a2013.g05.dao.GastoDAO;
import ar.edu.utn.frsf.tpae.a2013.g05.dao.mocks.GastoMockDAO;
import ar.edu.utn.frsf.tpae.a2013.g05.hibernate.GastoHibernate;

/**
 * @author root
 *
 */
public class GastoDAOFactory {
	public static GastoDAO getGastoDAO(){
		return new GastoHibernate();
	}
}
