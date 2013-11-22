/**
 * 
 */
package ar.edu.utn.frsf.tpae.a2013.g05.dao.factories;

import ar.edu.utn.frsf.tpae.a2013.g05.dao.CentroDeCostoDAO;
import ar.edu.utn.frsf.tpae.a2013.g05.dao.mocks.CentroDeCostoMockDAO;
import ar.edu.utn.frsf.tpae.a2013.g05.hibernate.CentroDeCostoHibernate;

/**
 * @author Dario
 *
 */
public class CentroDeCostoDAOFactory {
	public static CentroDeCostoDAO getCentroDeCostoDAO(){
		return new CentroDeCostoHibernate();
	}
}
