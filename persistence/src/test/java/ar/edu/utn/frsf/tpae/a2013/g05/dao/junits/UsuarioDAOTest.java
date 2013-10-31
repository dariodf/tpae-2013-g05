/**
 * 
 */
package ar.edu.utn.frsf.tpae.a2013.g05.dao.junits;

import static org.junit.Assert.*;

import java.util.Date;


import org.junit.Before;
import org.junit.Test;

import ar.edu.utn.frsf.tpae.a2013.g05.dao.UsuarioDAO;
import ar.edu.utn.frsf.tpae.a2013.g05.dao.factories.UsuarioDAOFactory;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Empleado;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Supervisor;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Usuario;

/**
 * @author Dario
 *
 */
public class UsuarioDAOTest {

	private UsuarioDAO usuarioDAO;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		usuarioDAO = UsuarioDAOFactory.getUsuarioDAO();
	}


	@Test
	public void validarLogin(){
		
		Usuario usuario = new Empleado(1, "Agustin","1234", "Martinez",
				"Agustin", "32123456", "Programador Java Junior", "20321234568",
				"123456789012345678901234567890", "156123456", "mrtnz.agustin@gmail.com");
		
		Usuario usuarioRetornado = usuarioDAO.validarUsuario("Agustin","1234");
		// Probamos que el Id sea el correcto.
		assertEquals(usuarioRetornado.getId(), usuario.getId());
		
		
		usuarioRetornado = usuarioDAO.validarUsuario("Carlos","1234");
		// Probamos que la validación no es correcta, por lo tanto retorna null.
		assertEquals(usuarioRetornado, null);
		
		usuarioRetornado = usuarioDAO.validarUsuario("Dario","5678");
		usuario = new Supervisor(3, "Dario", "5678", "De Filippis",
				"Dario", "30789456", new Date());
		// Probamos que traiga un Supervisor.
		assertEquals(usuario.getClass(), usuarioRetornado.getClass());	
		
		usuarioRetornado = usuarioDAO.validarUsuario("Daniela","3456");
		usuario = new Empleado(2, "Daniela","3456", "Greca",
				"Daniela", "31654321", "Programador Java Senior", "28316543218",
				"098765432109876543210987654321", "156654321", "daniela.greca@gmail.com");
		// Probamos que traiga un Empleado.
		assertEquals(usuario.getClass(), usuarioRetornado.getClass());
		
	}

}
