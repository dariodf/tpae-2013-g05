package ar.edu.utn.frsf.tpae.a2013.g05.dao.junits;

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

import ar.edu.utn.frsf.tpae.a2013.g05.dao.SolicitudDeGastosDAO;
import ar.edu.utn.frsf.tpae.a2013.g05.model.CentroDeCosto;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Constantes;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Empleado;
import ar.edu.utn.frsf.tpae.a2013.g05.model.SolicitudDeGastos;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Supervisor;

/**
 * @author Dario
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context-test.xml" })
public class SolicitudDeGastosDAOTest {

	@Autowired(required = true)
	private SolicitudDeGastosDAO solicitudDeGastosDAO;

	@Test
	@Transactional
	@Rollback(true)
	public void validarPersistencia() {
		SolicitudDeGastos solicitudDeGasto = crearUnaSolicitudDeGasto();

		SolicitudDeGastos solicitudDeGastosRetorno = solicitudDeGastosDAO.persistir(solicitudDeGasto);

		// Probamos que ambas solicitudes tengan el mismo id.
		assertEquals(solicitudDeGasto.getId(), solicitudDeGastosRetorno.getId());
	}

	private SolicitudDeGastos crearUnaSolicitudDeGasto() {
		return new SolicitudDeGastos(new CentroDeCosto("Centro Uno"), "Gastos en viajes a CBA", (float) 12354.54,
				Constantes.PENDIENTE.name(), new Date(), new Date(), new Supervisor("Dario", "5678", "De Filippis",
						"Dario", "30789456", new Date()), new Empleado("Agustin", "1234", "Martinez", "Agustin",
						"32123456", "Programador Java Junior", "20321234568", "123456789012345678901234567890",
						"156123456", "mrtnz.agustin@gmail.com"), "Default comment");
	}

	@Test
	@Transactional
	@Rollback(true)
	public void validarListarSolicitudesPendientes() {
		SolicitudDeGastos solicitudDeGasto = crearUnaSolicitudDeGasto();
		solicitudDeGastosDAO.persistir(solicitudDeGasto);

		List<SolicitudDeGastos> listaSolicitudesPendientes = solicitudDeGastosDAO.listarSolicitudesPendientes(1);
		for (SolicitudDeGastos solicitudDeGastos : listaSolicitudesPendientes) {
			assertEquals(solicitudDeGastos.getEstado(), Constantes.PENDIENTE.name());

			// Probamos que las solicitudes que se traigan sean del usuario
			// especificado.
			assertEquals(solicitudDeGastos.getEmpleado().getId(), 1);
		}

		listaSolicitudesPendientes = solicitudDeGastosDAO.listarSolicitudesPendientes(43);

		// Probamos que devuelva 0 cuando no existen solicitudes pendientes
		// para el usuario especificado.
		assertEquals(0, listaSolicitudesPendientes.size());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void validarListarSolicitudes() {
		List<SolicitudDeGastos> listaSolicitudes = solicitudDeGastosDAO.listarSolicitudes(1);
		for (SolicitudDeGastos solicitudDeGastos : listaSolicitudes) {
			// Probamos que las solicitudes que se traigan sean del usuario
			// especificado.
			assertEquals(solicitudDeGastos.getEmpleado().getId(), 1);
		}

		listaSolicitudes = solicitudDeGastosDAO.listarSolicitudesPendientes(43);

		// Probamos que devuelva 0 cuando no existen solicitudes pendientes
		// para el usuario especificado.
		assertEquals(0, listaSolicitudes.size());
	}

}
