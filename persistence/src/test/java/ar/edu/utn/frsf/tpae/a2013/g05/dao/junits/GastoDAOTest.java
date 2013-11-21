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

import ar.edu.utn.frsf.tpae.a2013.g05.dao.GastoDAO;
import ar.edu.utn.frsf.tpae.a2013.g05.model.CentroDeCosto;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Empleado;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Gasto;
import ar.edu.utn.frsf.tpae.a2013.g05.model.SolicitudDeGastos;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Supervisor;

/**
 * @author Dario
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context-test.xml" })
public class GastoDAOTest {

	@Autowired(required = true)
	private GastoDAO gastoDAO;

	@Test
	@Transactional
	@Rollback(true)
	public void validarPersistencia() {
		Gasto gasto = new Gasto(new SolicitudDeGastos(new CentroDeCosto("Centro Uno"), "Gastos en viajes a CBA", 12354,
				"No Procesada", new Date(), new Supervisor("Dario", "5678", "De Filippis", "Dario", "30789456",
						new Date()), new Empleado("Agustin", "1234", "Martinez", "Agustin", "32123456",
						"Programador Java Junior", "20321234568", "123456789012345678901234567890", "156123456",
						"mrtnz.agustin@gmail.com")), new Date(), (float) 1500.50, "B004");
		
		Gasto gastoRetorno = gastoDAO.persistir(gasto);

		// Probamos que ambas solicitudes tengan el mismo id.
		assertEquals(gasto.getId(), gastoRetorno.getId());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void validarListarGastos() {
		List<CentroDeCosto> centrosDeCosto = new ArrayList<CentroDeCosto>();
		List<Empleado> empleados = new ArrayList<Empleado>();

		List<Gasto> listaGastos = gastoDAO.listarGastos(centrosDeCosto, empleados);
		for (int i = 0; i < listaGastos.size(); i++) {
			// Probamos que traiga todos los gastos comprobando que los traiga
			// secuencialmente.
			assertEquals(i + 1, listaGastos.get(i).getId());
		}

		centrosDeCosto.add(new CentroDeCosto("Centro Uno"));
		listaGastos = gastoDAO.listarGastos(centrosDeCosto, empleados);
		for (Gasto gasto : listaGastos) {
			// Probamos que traiga todos los gastos del centro de costos 1.
			assertEquals(1, gasto.getSolicitudDeGastos().getCentroDeCosto().getId());
		}
		// Limpiamos la lista de Centros de Costo.
		centrosDeCosto.clear();

		empleados.add(new Empleado("Agustin", "1234", "Martinez", "Agustin", "32123456", "Programador Java Junior",
				"20321234568", "123456789012345678901234567890", "156123456", "mrtnz.agustin@gmail.com"));
		listaGastos = gastoDAO.listarGastos(centrosDeCosto, empleados);
		for (Gasto gasto : listaGastos) {
			// Probamos que traiga todos los gastos del empleado 1.
			assertEquals(1, gasto.getSolicitudDeGastos().getEmpleado().getId());
		}
		// Limpiamos la lista de empleados.
		empleados.clear();

		empleados.add(new Empleado("Daniela", "3456", "Greca", "Daniela", "31654321", "Programador Java Senior",
				"28316543218", "098765432109876543210987654321", "156654321", "daniela.greca@gmail.com"));
		centrosDeCosto.add(new CentroDeCosto("Centro Uno"));
		listaGastos = gastoDAO.listarGastos(centrosDeCosto, empleados);
		for (Gasto gasto : listaGastos) {
			// Probamos que traiga todos los gastos del centro de costos 1.
			assertEquals(1, gasto.getSolicitudDeGastos().getCentroDeCosto().getId());
			// Probamos que traiga todos los gastos del empleado 2.F
			assertEquals(2, gasto.getSolicitudDeGastos().getEmpleado().getId());
		}

	}

}
