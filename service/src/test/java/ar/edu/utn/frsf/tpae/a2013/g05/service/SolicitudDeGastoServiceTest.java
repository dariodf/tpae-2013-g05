package ar.edu.utn.frsf.tpae.a2013.g05.service;

import static org.junit.Assert.assertEquals;

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
import ar.edu.utn.frsf.tpae.a2013.g05.model.SolicitudDeGastos;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Supervisor;

/**
 * Clase que contiene tests unitarios para {@link SolicitudDeGastosService}.
 * 
 * @author Daniela
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context-test.xml" })
public class SolicitudDeGastoServiceTest {

	@Autowired(required = true)
	private SolicitudDeGastosService solicitudDeGastosService;

	@Test
	@Transactional
	@Rollback(true)
	public void listarSolicitudesDeGastoPendientes() {
		Empleado empleado = this.crearUnEmpleado();

		SolicitudDeGastos slg = this.crearUnaSolicitudDeGastos(empleado);
		solicitudDeGastosService.crearSolicitudAprobacion(slg);

		List<SolicitudDeGastos> listaRetorno = this.solicitudDeGastosService.listarSolicitudes(empleado.getId());

		assertEquals(slg.getCentroDeCosto().getNombre(), listaRetorno.get(0).getCentroDeCosto().getNombre());
		assertEquals(slg.getFechaCreacion(), listaRetorno.get(0).getFechaCreacion());
		assertEquals(slg.getEmpleado().getId(), listaRetorno.get(0).getEmpleado().getId());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void listarSolicitudesDeGastos() {
		Empleado empleado = this.crearUnEmpleado();

		SolicitudDeGastos slg = this.crearUnaSolicitudDeGastos(empleado);
		solicitudDeGastosService.crearSolicitudAprobacion(slg);
		SolicitudDeGastos slg2 = this.crearOtraSolicitudDeGastos();
		solicitudDeGastosService.crearSolicitudAprobacion(slg2);

		List<SolicitudDeGastos> listaRetorno = this.solicitudDeGastosService.listarSolicitudesPendientes();

		assertEquals(1, listaRetorno.size());
		assertEquals(slg.getEstado(), listaRetorno.get(0).getEstado());
		assertEquals(Constantes.PENDIENTE.name(), listaRetorno.get(0).getEstado());
	}

	private Empleado crearUnEmpleado() {
		return new Empleado("Agustin", "1234", "Martinez", "Agustin", "32123456", "Programador Java Junior",
				"20321234568", "123456789012345678901234567890", "156123456", "mrtnz.agustin@gmail.com");
	}

	/**
	 * SolicitudDeGastos con Estado.PENDIENTE
	 */
	private SolicitudDeGastos crearUnaSolicitudDeGastos(Empleado empleado) {
		return new SolicitudDeGastos(new CentroDeCosto("Centro Uno"), "Gastos en viajes a CBA", (float) 12354.54,
				Constantes.PENDIENTE.name(), new Date(), new Date(), new Supervisor("Dario", "5678", "De Filippis",
						"Dario", "30789456", new Date()), empleado, "Default comment");
	}

	/**
	 * SolicitudDeGastos con Estado.APROBADA
	 */
	private SolicitudDeGastos crearOtraSolicitudDeGastos() {
		return new SolicitudDeGastos(new CentroDeCosto("Centro Dos"), "Gastos en viajes a BA", (float) 12354.54,
				Constantes.APROBADA.name(), new Date(), new Date(), new Supervisor("Dario", "5678", "De Filippis",
						"Dario", "30789456", new Date()), new Empleado("Agustin", "1234", "Martinez", "Agustin",
						"32123456", "Programador Java Junior", "20321234568", "123456789012345678901234567890",
						"156123456", "mrtnz.agustin@gmail.com"), "Default comment");
	}

}
