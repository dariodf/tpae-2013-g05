package ar.edu.utn.frsf.tpae.a2013.g05.dao.mocks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
		Usuario usuarioTemporal;
		
		// Casos para cuando los usuarios seamos algunos de los tres desarrolladores, se setea lo correspondiente
		if(0 == usuario.compareTo("Agustin") && 0 == password.compareTo("1234")){
			usuarioTemporal = new Empleado(1, usuario,password, "Martinez",
					"Agustin", "32123456", "Programador Java Junior", "20321234568",
					"123456789012345678901234567890", "156123456", "mrtnz.agustin@gmail.com");
			return usuarioTemporal;
		}
		else if(0 == usuario.compareTo("Daniela") && 0 == password.compareTo("3456")){
			usuarioTemporal = new Empleado(2, usuario,password, "Greca",
					"Daniela", "31654321", "Programador Java Senior", "28316543218",
					"098765432109876543210987654321", "156654321", "daniela.greca@gmail.com");
			return usuarioTemporal;
		}
		else if(0 == usuario.compareTo("Dario") && 0 == password.compareTo("5678")){
			usuarioTemporal = new Supervisor(3, usuario, password, "De Filippis",
					"Dario", "30789456", new Date());
			return usuarioTemporal;
		}
		
		return null;
	}

	@Override
	public List<Usuario> listarEmpleados() {
		List<Usuario> listaRetorno = new ArrayList<Usuario>();
		listaRetorno.add(new Empleado(1, "Agustin","1234", "Martinez",
				"Agustin", "32123456", "Programador Java Junior", "20321234568",
				"123456789012345678901234567890", "156123456", "mrtnz.agustin@gmail.com"));
		listaRetorno.add(new Empleado(2, "Daniela","3456", "Greca",
					"Daniela", "31654321", "Programador Java Senior", "28316543218",
					"098765432109876543210987654321", "156654321", "daniela.greca@gmail.com"));
		return listaRetorno;
	}

}
