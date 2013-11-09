/**
 * 
 */
package ar.edu.utn.frsf.tpae.a2013.g05.dao.factories;

import ar.edu.utn.frsf.tpae.a2013.g05.dao.SolicitudDeGastosDAO;
import ar.edu.utn.frsf.tpae.a2013.g05.dao.mocks.SolicitudDeGastosMockDAO;
import ar.edu.utn.frsf.tpae.a2013.g05.hibernate.SolicitudDeGastosHibernate;

/**
 * @author root
 *
 */
public class SolicitudDeGastosDAOFactory {
	public static SolicitudDeGastosDAO getSolicitudDeGastosDAO(){
		return new SolicitudDeGastosHibernate();
	}
}
