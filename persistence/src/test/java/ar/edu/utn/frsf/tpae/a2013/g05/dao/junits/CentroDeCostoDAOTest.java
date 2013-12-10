package ar.edu.utn.frsf.tpae.a2013.g05.dao.junits;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.utn.frsf.tpae.a2013.g05.dao.CentroDeCostoDAO;
import ar.edu.utn.frsf.tpae.a2013.g05.model.CentroDeCosto;

/**
 * Clase que contiene tests unitarios para {@link CentroDeCostoDAO}.
 * 
 * @author Dario
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context-test.xml" })
public class CentroDeCostoDAOTest {

	@Autowired(required = true)
	private CentroDeCostoDAO centroDeCostoDAO;

	@Test
	@Transactional
	@Rollback(true)
	public void validarListarCentrosDeCosto() {
		
		List<CentroDeCosto> listaCreada = new ArrayList<CentroDeCosto>();
		CentroDeCosto centroDeCosto = new CentroDeCosto("Centro Uno");
		listaCreada.add(centroDeCosto);
		centroDeCosto = new CentroDeCosto("Centro Dos");
		listaCreada.add(centroDeCosto);
		
		List<CentroDeCosto> listaRetornada = centroDeCostoDAO.listarCentrosDeCosto();
		// Probamos que traiga todos los centros de costo comprobando que los
		// traiga secuencialmente.
		for (int i = 0; i < listaRetornada.size(); i++) {
			assertEquals(listaCreada.get(i).getNombre(), listaRetornada.get(i).getNombre());
		}

	}

}
