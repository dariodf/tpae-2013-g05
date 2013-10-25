/**
 * 
 */
package ar.edu.utn.frsf.tpae.a2013.g05.dao;

/**
 * @author root
 *
 */
public class GastoDAOFactory {
	public static GastoDAO getGastoDAO(){
		return new GastoMockDAO();
	}
}
