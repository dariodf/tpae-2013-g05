/**
 * 
 */
package ar.edu.utn.frsf.tpae.a2013.g05.dao;

/**
 * @author root
 *
 */
public class UsuarioDAOFactory {
	
	public static UsuarioDAO getUsuarioDAO(){
		return new UsuarioMockDAO();
	}
}
