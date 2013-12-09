package ar.edu.utn.frsf.tpae.a2013.g05.service;

import ar.edu.utn.frsf.tpae.a2013.g05.model.Usuario;

/**
 * Interfaz que define las operaciones que debe proveer el servicio de usuario.
 * 
 * @author Daniela
 */
public interface UsuarioService {

	/**
	 * Busca a un usuario utilizando su usuario y contraseña.
	 * 
	 * @param usuario
	 *            nombre de usuario del usuario que esta intentando loguearse
	 * @param password
	 *            password del usuario que esta intentando loguearse
	 * @return Si los valores ingresados pertenecen a un usuario existente en el
	 *         sistema, retorna el usuario. Sino retorna null.
	 */
	Usuario buscarUsuario(String usuario, String password);

	/**
	 * Permite crear un nuevo usuario con acceso a la aplicación.
	 * 
	 * @param usuario
	 *            el usuario a crear.
	 * @return el usuario creado.
	 */
	Usuario crearUsuario(Usuario usuario);

	/**
	 * Retorna el usuario Logueado.
	 * @return the usuarioLogueado
	 */
	public Usuario getUsuarioLogueado();
}
