/**
 * 
 */
package ar.edu.utn.frsf.tpae.a2013.g05.dao.junits;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ar.edu.utn.frsf.tpae.a2013.g05.dao.GastoDAO;
import ar.edu.utn.frsf.tpae.a2013.g05.dao.factories.GastoDAOFactory;
import ar.edu.utn.frsf.tpae.a2013.g05.model.CentroDeCosto;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Empleado;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Gasto;
import ar.edu.utn.frsf.tpae.a2013.g05.model.SolicitudDeGastos;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Supervisor;

/**
 * @author Dario
 *
 */
public class GastoDAOTest {

	private GastoDAO gastoDAO; 
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		gastoDAO = GastoDAOFactory.getGastoDAO();
	}

	@Test
	public void validarPersistencia() {
		Gasto gasto = new Gasto(1, new SolicitudDeGastos(1, new CentroDeCosto(1, "Centro Uno"), "Gastos en viajes a CBA", 12354, "No Procesada", new Supervisor(3, "Dario", "5678", "De Filippis",
				"Dario", "30789456", new Date()),new Empleado(1, "Agustin","1234", "Martinez",
						"Agustin", "32123456", "Programador Java Junior", "20321234568",
						"123456789012345678901234567890", "156123456", "mrtnz.agustin@gmail.com")), new Date(), (float) 1500.50, "B004");
		Gasto gastoRetorno = gastoDAO.persistir(gasto);
		assertEquals(gasto.getId(), gastoRetorno.getId()); // Probamos que ambas solicitudes tengan el mismo id.		
	}
	
	@Test
	public void validarListarGastos()
	{
		List<CentroDeCosto> centrosDeCosto = new ArrayList<CentroDeCosto>();
		List<Empleado> empleados = new ArrayList<Empleado>();
		
		
		List<Gasto> listaGastos = gastoDAO.listarGastos(centrosDeCosto, empleados);
		for (int i=0; i<listaGastos.size();i++)
		{
			assertEquals(i+1, listaGastos.get(i).getId()); // Probamos que traiga todos los gastos comprobando que los traiga secuencialmente.
		}
		
		
		centrosDeCosto.add(new CentroDeCosto(1, "Centro Uno"));
		listaGastos = gastoDAO.listarGastos(centrosDeCosto, empleados);
		for (Gasto gasto : listaGastos) {
			assertEquals(1, gasto.getSolicitudDeGastos().getCentroDeCosto().getId()); // Probamos que traiga todos los gastos del centro de costos 1.
		}
		centrosDeCosto.clear(); // Limpiamos la lista de Centros de Costo.
		
		
		empleados.add(new Empleado(1, "Agustin","1234", "Martinez",
							"Agustin", "32123456", "Programador Java Junior", "20321234568",
							"123456789012345678901234567890", "156123456", "mrtnz.agustin@gmail.com"));
		listaGastos = gastoDAO.listarGastos(centrosDeCosto, empleados);
		for (Gasto gasto : listaGastos) {
			assertEquals(1, gasto.getSolicitudDeGastos().getEmpleado().getId()); // Probamos que traiga todos los gastos del empleado 1.  
		}
		empleados.clear(); // Limpiamos la lista de empleados.
		
		
		empleados.add(new Empleado(2, "Daniela","3456", "Greca",
						"Daniela", "31654321", "Programador Java Senior", "28316543218",
						"098765432109876543210987654321", "156654321", "daniela.greca@gmail.com"));
		centrosDeCosto.add(new CentroDeCosto(1, "Centro Uno"));
		listaGastos = gastoDAO.listarGastos(centrosDeCosto, empleados);
		for (Gasto gasto : listaGastos) {
			assertEquals(1, gasto.getSolicitudDeGastos().getCentroDeCosto().getId()); // Probamos que traiga todos los gastos del centro de costos 1.
			assertEquals(2, gasto.getSolicitudDeGastos().getEmpleado().getId()); // Probamos que traiga todos los gastos del empleado 2.
		}
		
	}

}
