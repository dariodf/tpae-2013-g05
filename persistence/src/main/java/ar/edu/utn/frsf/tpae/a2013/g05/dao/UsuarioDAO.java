/**
 * 
 */
package ar.edu.utn.frsf.tpae.a2013.g05.dao;

import ar.edu.utn.frsf.tpae.a2013.g05.model.Usuario;

/**
 * @author root
 *
 */
public interface UsuarioDAO {
	
	
	/**
	 * 		Valida que los datos enviados como parametro pertenezcan a un usuario valido
	 * @param usuario
	 * 		nombre de usuario del usuario que esta intentando loguearse
	 * @param password
	 * 		password del usuario que esta intentando loguearse
	 * @return
	 * 		Si los valores son correctos, se retorna el usuario instanciado (empleado o supervisor).
	 * 		Si los valores son incorrectos, se retorna null.
	 */
	Usuario validarUsuario(String usuario, String password);
}
