/**
 * 
 */
package ar.edu.utn.frsf.tpae.a2013.g05.dao.factories;

import ar.edu.utn.frsf.tpae.a2013.g05.dao.UsuarioDAO;
import ar.edu.utn.frsf.tpae.a2013.g05.dao.mocks.UsuarioMockDAO;
import ar.edu.utn.frsf.tpae.a2013.g05.hibernate.UsuarioHibernate;

/**
 * @author root
 *
 */
public class UsuarioDAOFactory {
	
	public static UsuarioDAO getUsuarioDAO(){
		return new UsuarioHibernate();
	}
}
