package ar.edu.utn.frsf.tpae.a2013.g05.dao.mocks;

import java.util.ArrayList;
import java.util.List;

import ar.edu.utn.frsf.tpae.a2013.g05.dao.CentroDeCostoDAO;
import ar.edu.utn.frsf.tpae.a2013.g05.model.CentroDeCosto;

/**
 * @author Dario
 * 
 */
public class CentroDeCostoMockDAO implements CentroDeCostoDAO {

	@Override
	public List<CentroDeCosto> listarCentrosDeCosto() {
		List<CentroDeCosto> listaRetorno = new ArrayList<CentroDeCosto>();

		listaRetorno.add(new CentroDeCosto("Centro Uno"));
		listaRetorno.add(new CentroDeCosto("Centro Dos"));
		return listaRetorno;
	}

}
