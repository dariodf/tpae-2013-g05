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

import ar.edu.utn.frsf.tpae.a2013.g05.dao.CentroDeCostoDAO;
import ar.edu.utn.frsf.tpae.a2013.g05.dao.GastoDAO;
import ar.edu.utn.frsf.tpae.a2013.g05.dao.UsuarioDAO;
import ar.edu.utn.frsf.tpae.a2013.g05.model.CentroDeCosto;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Empleado;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Gasto;
import ar.edu.utn.frsf.tpae.a2013.g05.model.SolicitudDeGastos;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Supervisor;

/**
 * 
 * @author Dario
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context-test.xml" })
public class GastoDAOTest {

	@Autowired(required = true)
	private GastoDAO gastoDAO;

	@Autowired(required = true)
	private CentroDeCostoDAO centroDeCostoDAO;

	@Autowired(required = true)
	private UsuarioDAO usuarioDAO;

	@Test
	@Transactional
	@Rollback(true)
	public void validarPersistencia() {
		Gasto gasto = crearUnGasto();
		Gasto gastoRetorno = gastoDAO.persistir(gasto);

		// Probamos que ambas solicitudes tengan el mismo id.
		assertEquals(gasto.getId(), gastoRetorno.getId());
	}

	private Gasto crearYPersistirUnGasto() {
		Gasto gasto = crearUnGasto();
		gastoDAO.persistir(gasto);

		return gasto;
	}

	private Gasto crearUnGasto() {
		return new Gasto(new SolicitudDeGastos(new CentroDeCosto("Centro Uno"), "Gastos en viajes a CBA", 12354,
				"No Procesada", new Date(), new Supervisor("Dario", "5678", "De Filippis", "Dario", "30789456",
						new Date()), new Empleado("Agustin", "1234", "Martinez", "Agustin", "32123456",
						"Programador Java Junior", "20321234568", "123456789012345678901234567890", "156123456",
						"mrtnz.agustin@gmail.com")), new Date(), (float) 1500.50, "B004");
	}

	@Test
	@Transactional
	@Rollback(true)
	public void validarListarGastos() {
		List<CentroDeCosto> centrosDeCosto = new ArrayList<CentroDeCosto>();
		List<Gasto> listaGastos = new ArrayList<Gasto>();
//		List<Empleado> empleados = new ArrayList<Empleado>();
//		
//		List<Gasto> listaGastos = gastoDAO.listarGastos(centrosDeCosto, empleados);
//		for (int i = 0; i < listaGastos.size(); i++) {
//			// Probamos que traiga todos los gastos comprobando que los traiga
//			// secuencialmente.
//			assertEquals(i + 1, listaGastos.get(i).getId());
//		}

		Gasto gasto1 = crearYPersistirUnGasto();

		// Recuperamos de la BD las entidades creadas
		centrosDeCosto = centroDeCostoDAO.listarCentrosDeCosto();
		Empleado empleado1 = usuarioDAO.listarEmpleados().get(0);

		listaGastos = gastoDAO.listarGastos(centrosDeCosto, empleado1);
		for (int i = 0; i < listaGastos.size(); i++) {
			// Probamos que traiga todos los gastos del centro de costos 1.
			assertEquals(centrosDeCosto.get(i).getNombre(), gasto1.getSolicitudDeGastos().getCentroDeCosto()
					.getNombre());
		}

		// TODO: Método listarGastos ver como plantearlo, según sea necesario
		// cdo. implementemos los servicios requeridos.
		listaGastos = gastoDAO.listarGastos(new ArrayList<CentroDeCosto>(), empleado1);
		for (Gasto gasto : listaGastos) {
			// Probamos que traiga todos los gastos del empleado 1.
			assertEquals(empleado1.getNombre(), gasto.getSolicitudDeGastos().getEmpleado().getNombre());
			assertEquals(empleado1.getApellido(), gasto.getSolicitudDeGastos().getEmpleado().getApellido());
		}
//		// Limpiamos la lista de empleados.
//		empleados.clear();

		// Crea y persiste un Empleado
		Empleado empleado2 = crearYPersistirUnEmpleado();
//		empleados.add(empleado2);

		listaGastos = gastoDAO.listarGastos(centrosDeCosto, empleado2);
		for (Gasto gasto : listaGastos) {
			// Probamos que traiga todos los gastos del centro de costos 1.
			assertEquals(1, gasto.getSolicitudDeGastos().getCentroDeCosto().getId());
			// Probamos que traiga todos los gastos del empleado 2.
			assertEquals(2, gasto.getSolicitudDeGastos().getEmpleado().getId());
		}

	}

	private Empleado crearYPersistirUnEmpleado() {
		Empleado empleado = new Empleado("Daniela", "3456", "Greca", "Daniela", "31654321", "Programador Java Senior",
				"28316543218", "098765432109876543210987654321", "156654321", "daniela.greca@gmail.com");
		usuarioDAO.persistir(empleado);

		return empleado;
	}

}
