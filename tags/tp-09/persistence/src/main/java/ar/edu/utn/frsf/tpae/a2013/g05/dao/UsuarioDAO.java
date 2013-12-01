package ar.edu.utn.frsf.tpae.a2013.g05.dao;

import java.util.List;

import ar.edu.utn.frsf.tpae.a2013.g05.model.Empleado;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Usuario;

/**
 * Interfaz que define las operaciones que debe proveer un DAO de Usuario.
 * 
 * @author Agustín
 */
public interface UsuarioDAO {

	/**
	 * Valida que los datos enviados como parametro pertenezcan a un usuario
	 * valido
	 * 
	 * @param usuario
	 *            nombre de usuario del usuario que esta intentando loguearse
	 * @param password
	 *            password del usuario que esta intentando loguearse
	 * @return Si los valores son correctos, se retorna el usuario instanciado
	 *         (empleado o supervisor). Si los valores son incorrectos, se
	 *         retorna null.
	 */
	Usuario validarUsuario(String usuario, String password);

	/**
	 * Busca y retorna la lista completa de empleados de la empresa.
	 * 
	 * @return Lista de los empleados.
	 */
	List<Empleado> listarEmpleados();

	/**
	 * Crea o modifica un usuario. Si el identificador tiene el valor
	 * <code>null</code>, se trata de una operación de creación. En caso
	 * contrario, modificación.
	 * 
	 * @param usuario
	 *            El usuario a crear o modificar.
	 * @return El usuario persistido, con sus campos actualizados. En el caso de
	 *         una operación de creación, el objeto retornado tendrá seteado el
	 *         identificador.
	 */
	Usuario persistir(Usuario usuario);

}
