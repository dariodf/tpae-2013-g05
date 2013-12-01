package ar.edu.utn.frsf.tpae.a2013.g05.service;

import ar.edu.utn.frsf.tpae.a2013.g05.model.Usuario;

/**
 * Interfaz que define las operaciones que debe proveer el servicio de usuario.
 * 
 * @author Daniela
 */
public interface UsuarioService {

	/**
	 * Permite a un usuario existente ingresar a la aplicaci�n.
	 * 
	 * @param usuario
	 *            nombre de usuario del usuario que esta intentando loguearse
	 * @param password
	 *            password del usuario que esta intentando loguearse
	 * @return Si los valores ingresados pertenecen a un usuario existente en el
	 *         sistema, retorna el usuario. Sino retorna null.
	 */
	Usuario ingresar(String usuario, String password);

	/**
	 * Permite crear un nuevo usuario con acceso a la aplicaci�n.
	 * 
	 * @param usuario
	 *            el usuario a crear.
	 * @return el usuario creado.
	 */
	Usuario crear(Usuario usuario);

}
