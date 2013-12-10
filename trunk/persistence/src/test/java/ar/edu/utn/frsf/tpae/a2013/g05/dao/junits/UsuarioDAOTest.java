package ar.edu.utn.frsf.tpae.a2013.g05.dao.junits;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.utn.frsf.tpae.a2013.g05.dao.UsuarioDAO;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Empleado;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Supervisor;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Usuario;

/**
 * @author Dario
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context-test.xml" })
public class UsuarioDAOTest {

	@Autowired(required = true)
	private UsuarioDAO usuarioDAO;

	@Test
	@Transactional
	@Rollback(true)
	public void validarLogin() {
		Usuario usuario = new Empleado("Agustin", "1234", "Martinez", "Agustin", "32123456", "Programador Java Junior",
				"20321234568", "123456789012345678901234567890", "156123456", "mrtnz.agustin@gmail.com");
		Usuario usuarioAPersistir = this.usuarioDAO.persistir(usuario);

		Usuario usuarioRetornado = usuarioDAO.validarUsuario("Agustin", "1234");

		// Probamos que el Id sea el correcto.
		assertEquals(usuarioAPersistir.getId(), usuarioRetornado.getId());

		// Probamos que la validación no es correcta, por lo tanto retorna null.
		usuarioRetornado = usuarioDAO.validarUsuario("Carlos", "1234");
		assertEquals(usuarioRetornado, null);

		// Probamos que traiga un Supervisor.
		usuario = new Supervisor("Dario", "5678", "De Filippis", "Dario", "30789456", new Date());
		// usuarioRetornado = usuarioDAO.validarUsuario("Dario", "5678");

		Usuario usuarioAPersistir2 = this.usuarioDAO.persistir(usuario);
		assertEquals(usuario.getClass(), usuarioAPersistir2.getClass());

		// Probamos que traiga un Empleado.
		usuario = new Empleado("Daniela", "3456", "Greca", "Daniela", "31654321", "Programador Java Senior",
				"28316543218", "098765432109876543210987654321", "156654321", "daniela.greca@gmail.com");
		// usuarioRetornado = usuarioDAO.validarUsuario("Daniela", "3456");
		Usuario usuarioAPersistir3 = this.usuarioDAO.persistir(usuario);

		assertEquals(usuario.getClass(), usuarioAPersistir3.getClass());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void validarListarEmpleados() {
		
		List<Usuario> listaCreada = new ArrayList<Usuario>();
		Usuario usuario = new Empleado("Agustin", "1234", "Martinez", "Agustin", "32123456", "Programador Java Junior",
				"20321234568", "123456789012345678901234567890", "156123456", "mrtnz.agustin@gmail.com");
		listaCreada.add(this.usuarioDAO.persistir(usuario));
		
		usuario = new Empleado("Daniela", "3456", "Greca", "Daniela", "31654321", "Programador Java Senior",
				"28316543218", "098765432109876543210987654321", "156654321", "daniela.greca@gmail.com");
		listaCreada.add(this.usuarioDAO.persistir(usuario));

		
		List<Empleado> listaRetornada = usuarioDAO.listarEmpleados();

		for (int i = 0; i < listaRetornada.size(); i++) {
			assertEquals(listaCreada.get(i).getDni(), listaRetornada.get(i).getDni());
		}
	}

}
