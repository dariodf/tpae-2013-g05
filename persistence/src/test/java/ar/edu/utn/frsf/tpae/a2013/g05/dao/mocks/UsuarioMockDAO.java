package ar.edu.utn.frsf.tpae.a2013.g05.dao.mocks;

import ar.edu.utn.frsf.tpae.a2013.g05.dao.UsuarioDAO;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Empleado;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Supervisor;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Usuario;


/**
 * @author root
 *
 */
public class UsuarioMockDAO implements UsuarioDAO{

	@Override
	public Usuario validarUsuario(String usuario, String password) {
		// En el caso de que el usuario no exista, devuelve null
		Usuario usuarioTemporal = null;
		
		// Casos para cuando los usuarios seamos algunos de los tres desarrolladores, se setea lo correspondiente
		if(0 == usuario.compareTo("Agustin") && 0 == password.compareTo("1234")){
			usuarioTemporal = new Empleado();
			usuarioTemporal.setUsuario(usuario);
			usuarioTemporal.setPassword(password);		
		}
		else if(0 == usuario.compareTo("Daniela") && 0 == password.compareTo("3456")){
			usuarioTemporal = new Empleado();
			usuarioTemporal.setUsuario(usuario);
			usuarioTemporal.setPassword(password);		
		}
		else if(0 == usuario.compareTo("Dario") && 0 == password.compareTo("5678")){
			usuarioTemporal = new Supervisor();
			usuarioTemporal.setUsuario(usuario);
			usuarioTemporal.setPassword(password);		
		}
		
		return usuarioTemporal;
	}

}
