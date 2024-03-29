package ar.edu.utn.frsf.tpae.a2013.g05.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.utn.frsf.tpae.a2013.g05.model.Empleado;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Usuario;

/**
 * Clase que contiene tests unitarios para {@link UsuarioService}.
 * 
 * @author Daniela
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context-test.xml" })
public class UsuarioServiceTest {

	@Autowired(required = true)
	private UsuarioService usuarioService;

	@Test
	@Transactional
	@Rollback(true)
	public void validarUsuarioNoExistente() {
		Usuario usuario = this.usuarioService.buscarUsuario("Pepito", "Pepita");

		assertNull(usuario);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void validarUsuarioExistente() {
		Empleado empleado = this.crearUnEmpleado();
		usuarioService.crearUsuario(empleado);

		assertNotNull(empleado);

		Usuario usuarioExistente = usuarioService.buscarUsuario(empleado.getUsuario(), empleado.getPassword());
		
		assertNotNull(usuarioExistente);
		assertEquals(empleado.getId(), usuarioExistente.getId());
	}	
	
	@Test
	@Transactional
	@Rollback(true)
	public void listarEmpleados() {
		List<Empleado> listaCreada = new ArrayList<Empleado>();
		
		Empleado empleado = this.crearUnEmpleado();
		listaCreada.add((Empleado) usuarioService.crearUsuario(empleado));
	
		empleado = crearOtroEmpleado();
		listaCreada.add((Empleado) usuarioService.crearUsuario(empleado));
		
		List<Empleado> listaRetorno = this.usuarioService.listarEmpleados();
		for(int i=0; i < listaRetorno.size(); i++)
			assertEquals(listaCreada.get(i).getDni(), listaRetorno.get(i).getDni());
	}

	private Empleado crearUnEmpleado() {
		return new Empleado("Romina", "3456", "Greca", "Romina", "31654321", "Programador Java Senior",
				"28316543218", "098765432109876543210987654321", "156654321", "romina.greca@gmail.com");
	}
	
	private Empleado crearOtroEmpleado() {
		return new Empleado("Ramon", "3356", "Zutti", "Ramon", "30054321", "Programador C++ Junior",
				"28316544444", "198765432109876543210987654321", "156654321", "ramon.zutti@gmail.com");
	}

}
