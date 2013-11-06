/**
 * 
 */
package ar.edu.utn.frsf.tpae.a2013.g05.dao.junits;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ar.edu.utn.frsf.tpae.a2013.g05.dao.SolicitudDeGastosDAO;
import ar.edu.utn.frsf.tpae.a2013.g05.dao.factories.SolicitudDeGastosDAOFactory;
import ar.edu.utn.frsf.tpae.a2013.g05.model.CentroDeCosto;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Empleado;
import ar.edu.utn.frsf.tpae.a2013.g05.model.SolicitudDeGastos;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Supervisor;

/**
 * @author Dario
 *
 */
public class SolicitudDeGastosDAOTest {

	private SolicitudDeGastosDAO solicitudDeGastosDAO;
	@Before
	public void setUp(){
		solicitudDeGastosDAO = SolicitudDeGastosDAOFactory.getSolicitudDeGastosDAO();
	}

	@Test
	public void validarPersistencia() {
		
		SolicitudDeGastos solicitudDeGastos = new SolicitudDeGastos(1, new CentroDeCosto(1, "Centro Uno"), "Gastos en viajes a CBA", 12354, "No Procesada", new Supervisor(3, "Dario", "5678", "De Filippis",
				"Dario", "30789456", new Date()), new Empleado(1, "Agustin","1234", "Martinez",
						"Agustin", "32123456", "Programador Java Junior", "20321234568",
						"123456789012345678901234567890", "156123456", "mrtnz.agustin@gmail.com"));
		SolicitudDeGastos solicitudDeGastosRetorno = solicitudDeGastosDAO.persistir(solicitudDeGastos);
		assertEquals(solicitudDeGastos.getId(), solicitudDeGastosRetorno.getId()); // Probamos que ambas solicitudes tengan el mismo id.		
	}
	
	@Test
	public void validarListarSolicitudesPendientes() {
		
		List<SolicitudDeGastos> listaSolicitudesPendientes = solicitudDeGastosDAO.listarSolicitudesPendientes(1);
		for (SolicitudDeGastos solicitudDeGastos : listaSolicitudesPendientes)
		{
			assertEquals(solicitudDeGastos.getEstado(), "No Procesada"); // Probamos que las solicitudes sean No Procesadas.
			assertEquals(solicitudDeGastos.getEmpleado().getId(), 1); // Probamos que las solicitudes que se traigan sean del usuario especificado.	
		}
		
		
		listaSolicitudesPendientes = solicitudDeGastosDAO.listarSolicitudesPendientes(43);
		assertEquals(listaSolicitudesPendientes, null); // Probamos que devuelva null cuando no existen solicitudes pendientes para el usuario especificado.
	}
	
	@Test
	public void validarListarSolicitudes() {
		
		List<SolicitudDeGastos> listaSolicitudes = solicitudDeGastosDAO.listarSolicitudes(1);
		for (SolicitudDeGastos solicitudDeGastos : listaSolicitudes)
			assertEquals(solicitudDeGastos.getEmpleado().getId(), 1); // Probamos que las solicitudes que se traigan sean del usuario especificado.
		
		
		listaSolicitudes= solicitudDeGastosDAO.listarSolicitudesPendientes(43);
		assertEquals(listaSolicitudes, null); // Probamos que devuelva null cuando no existen solicitudes pendientes para el usuario especificado.
		
	}

}
