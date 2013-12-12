package ar.edu.utn.frsf.tpae.a2013.g05.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.utn.frsf.tpae.a2013.g05.model.CentroDeCosto;

/**
 * Clase que contiene tests unitarios para {@link CentroDeCostoService}.
 * 
 * @author Daniela
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context-test.xml" })
public class CentroDeCostoServiceTest {

	@Autowired(required = true)
	private CentroDeCostoService centroDeCostoService;

	@Test
	@Transactional
	@Rollback(true)
	public void validarCentroDeCostoExistente() {
		CentroDeCosto centroDeCosto = this.crearUnCentroDeCosto();
		centroDeCostoService.crearCentroDeCosto(centroDeCosto);

		assertNotNull(centroDeCosto);

		List<CentroDeCosto> centroDeCostos = centroDeCostoService.listarCentrosDeCosto();

		assertNotNull(centroDeCostos);
		assertEquals(centroDeCosto.getNombre(), centroDeCostos.get(0).getNombre());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void listarCentroDeCostos() {
		List<CentroDeCosto> listaCreada = new ArrayList<CentroDeCosto>();

		CentroDeCosto centroDeCosto = this.crearUnCentroDeCosto();
		listaCreada.add(centroDeCostoService.crearCentroDeCosto(centroDeCosto));

		centroDeCosto = crearOtroCentroDeCosto();
		listaCreada.add(centroDeCostoService.crearCentroDeCosto(centroDeCosto));

		List<CentroDeCosto> listaRetorno = this.centroDeCostoService.listarCentrosDeCosto();
		for (int i = 0; i < listaRetorno.size(); i++)
			assertEquals(listaCreada.get(i).getNombre(), listaRetorno.get(i).getNombre());
	}

	private CentroDeCosto crearUnCentroDeCosto() {
		return new CentroDeCosto("Ventas");
	}

	private CentroDeCosto crearOtroCentroDeCosto() {
		return new CentroDeCosto("Marketing");
	}

}
