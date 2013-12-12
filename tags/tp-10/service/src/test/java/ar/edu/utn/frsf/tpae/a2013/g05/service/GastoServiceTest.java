package ar.edu.utn.frsf.tpae.a2013.g05.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.utn.frsf.tpae.a2013.g05.model.CentroDeCosto;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Constantes;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Empleado;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Gasto;
import ar.edu.utn.frsf.tpae.a2013.g05.model.SolicitudDeGastos;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Supervisor;

/**
 * Clase que contiene tests unitarios para {@link GastoService}.
 * 
 * @author Daniela
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context-test.xml" })
public class GastoServiceTest {

	@Autowired(required = true)
	private GastoService gastoService;

	@Autowired(required = true)
	private CentroDeCostoService centroDeCostoService;

	@Autowired(required = true)
	private UsuarioService usuarioService;

	@Test
	@Transactional
	@Rollback(true)
	public void validarListarGastosConNulos() {
		Gasto gasto = this.crearUnGasto(crearUnEmpleado(), crearUnCentroDeCosto());
		gastoService.crearGasto(gasto);

		Gasto gasto2 = this.crearOtroGasto(crearOtroEmpleado(), crearUnCentroDeCosto());
		gastoService.crearGasto(gasto2);

		List<Gasto> gastosExistentes = gastoService.listarGastos(null, null);

		assertNotNull(gastosExistentes);
		assertEquals(2, gastosExistentes.size());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void validarGastoEmpleadoNulo() {
		CentroDeCosto cco = this.crearUnCentroDeCosto();
		centroDeCostoService.crearCentroDeCosto(cco);

		Gasto gasto = this.crearUnGasto(crearUnEmpleado(), cco);
		gastoService.crearGasto(gasto);

		Gasto gasto2 = this.crearOtroGasto(crearOtroEmpleado(), cco);
		gastoService.crearGasto(gasto2);

		List<Gasto> gastosExistentes = gastoService.listarGastos(cco, null);

		assertNotNull(gastosExistentes);
		assertEquals(2, gastosExistentes.size());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void validarGastoCCONulo() {
		Empleado empleado = crearUnEmpleado();
		usuarioService.crearUsuario(empleado);
		
		Gasto gasto = this.crearUnGasto(empleado, crearUnCentroDeCosto());
		gastoService.crearGasto(gasto);

		Gasto gasto2 = this.crearOtroGasto(crearOtroEmpleado(), crearUnCentroDeCosto());
		gastoService.crearGasto(gasto2);

		List<Gasto> gastosExistentes = gastoService.listarGastos(null, empleado);

		assertNotNull(gastosExistentes);
		assertEquals(1, gastosExistentes.size());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void validarGastoExistente() {
		Empleado empleado = this.crearUnEmpleado();
		usuarioService.crearUsuario(empleado);
		CentroDeCosto cco = this.crearUnCentroDeCosto();
		centroDeCostoService.crearCentroDeCosto(cco);

		Gasto gasto = this.crearUnGasto(empleado, cco);
		gastoService.crearGasto(gasto);

		assertNotNull(gasto);

		List<Gasto> gastosExistentes = gastoService.listarGastos(cco, empleado);

		assertNotNull(gastosExistentes);
		assertEquals(gasto.getFechaAlta(), gastosExistentes.get(0).getFechaAlta());
		assertEquals(gasto.getId(), gastosExistentes.get(0).getId());
	}

	
	/**
	 * Gasto con CCO = 'Ventas'
	 */
	private Gasto crearUnGasto(Empleado empleado, CentroDeCosto cco) {
		return new Gasto(new SolicitudDeGastos(cco, "Gastos en viajes a CBA", 12354,
				Constantes.PENDIENTE.name(), new Date(), new Date(), new Supervisor("Dario", "5678", "De Filippis",
						"Dario", "30789456", new Date()), empleado, "Default comment"), new Date(), new Date(),
				(float) 1500.50, "B004");
	}

	/**
	 * Gasto con CCO = 'Ventas'
	 */
	private Gasto crearOtroGasto(Empleado otroEmple, CentroDeCosto cco) {
		return new Gasto(new SolicitudDeGastos(cco, "Gastos en viajes a BA", 2154,
				Constantes.PENDIENTE.name(), new Date(), new Date(), new Supervisor("Dario", "5678", "De Filippis",
						"Dario", "30789456", new Date()), otroEmple, "Default comment"), new Date(), new Date(),
				(float) 1500.50, "B004");
	}

	private Empleado crearUnEmpleado() {
		return new Empleado("Agustin", "1234", "Martinez", "Agustin", "32123456", "Programador Java Junior",
				"20321234568", "123456789012345678901234567890", "156123456", "mrtnz.agustin@gmail.com");
	}

	private Empleado crearOtroEmpleado() {
		return new Empleado("Mariana", "1234", "Arias", "Mariana", "21123456", "Programadora Java Junior",
				"20321234568", "123489012345678901234567890", "156123456", "marian@gmail.com");
	}

	private CentroDeCosto crearUnCentroDeCosto() {
		return new CentroDeCosto("Ventas");
	}

}
