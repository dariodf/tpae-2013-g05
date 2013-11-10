/**
 * 
 */
package ar.edu.utn.frsf.tpae.a2013.g05.dao.junits;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ar.edu.utn.frsf.tpae.a2013.g05.dao.CentroDeCostoDAO;
import ar.edu.utn.frsf.tpae.a2013.g05.dao.factories.CentroDeCostoDAOFactory;
import ar.edu.utn.frsf.tpae.a2013.g05.model.CentroDeCosto;

/**
 * @author Dario
 *
 */
public class CentroDeCostoDAOTest {


	private CentroDeCostoDAO centroDeCostoDAO; 
	@Before
	public void setUp() {
		centroDeCostoDAO = CentroDeCostoDAOFactory.getCentroDeCostoDAO();
	}

	@Test
	public void validarListarCentrosDeCosto() {
		List<CentroDeCosto> listaCentrosDeCosto = centroDeCostoDAO.listarCentrosDeCosto();
		for (int i=0; i<listaCentrosDeCosto.size();i++)
		{
			assertEquals(i+1, listaCentrosDeCosto.get(i).getId()); // Probamos que traiga todos los centros de costo comprobando que los traiga secuencialmente.
		}
				
	}

}
