package ar.edu.utn.frsf.tpae.a2013.g05.dao.mocks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ar.edu.utn.frsf.tpae.a2013.g05.dao.GastoDAO;
import ar.edu.utn.frsf.tpae.a2013.g05.model.CentroDeCosto;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Empleado;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Gasto;
import ar.edu.utn.frsf.tpae.a2013.g05.model.SolicitudDeGastos;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Supervisor;

/**
 * @author root
 * 
 */
public class GastoMockDAO implements GastoDAO {

	@Override
	public Gasto persistir(Gasto gasto) {
		// Ac� persistir�a.
		return gasto;
	}

	@Override
	public List<Gasto> listarGastos(List<CentroDeCosto> centrosDeCosto, List<Empleado> empleados) {

		List<Gasto> listaDeGastos = new ArrayList<Gasto>();
		Gasto gastoUno = new Gasto(new SolicitudDeGastos(new CentroDeCosto("Centro Uno"), "Gastos en viajes a CBA",
				12354, "No Procesada", new Supervisor("Dario", "5678", "De Filippis", "Dario", "30789456", new Date()),
				new Empleado("Agustin", "1234", "Martinez", "Agustin", "32123456", "Programador Java Junior",
						"20321234568", "123456789012345678901234567890", "156123456", "mrtnz.agustin@gmail.com")),
				new Date(), (float) 1500.50, "B004");
		Gasto gastoDos = new Gasto(new SolicitudDeGastos(new CentroDeCosto("Centro Dos"), "Gastos en viajes a ER",
				12354, "No Procesada", new Supervisor("Dario", "5678", "De Filippis", "Dario", "30789456", new Date()),
				new Empleado("Agustin", "1234", "Martinez", "Agustin", "32123456", "Programador Java Junior",
						"20321234568", "123456789012345678901234567890", "156123456", "mrtnz.agustin@gmail.com")),
				new Date(), (float) 2000.99, "B034");
		Gasto gastoTres = new Gasto(new SolicitudDeGastos(new CentroDeCosto("Centro Uno"), "Gastos en viajes a CBA",
				12354, "No Procesada", new Supervisor("Dario", "5678", "De Filippis", "Dario", "30789456", new Date()),
				new Empleado("Agustin", "1234", "Martinez", "Agustin", "32123456", "Programador Java Junior",
						"20321234568", "123456789012345678901234567890", "156123456", "mrtnz.agustin@gmail.com")),
				new Date(), (float) 1200.99, "B031");
		Gasto gastoCuatro = new Gasto(new SolicitudDeGastos(new CentroDeCosto("Centro Uno"),
				"Gastos en viaticos a CBA", 12354, "No Procesada", new Supervisor("Dario", "5678", "De Filippis",
						"Dario", "30789456", new Date()), new Empleado("Daniela", "3456", "Greca", "Daniela",
						"31654321", "Programador Java Senior", "28316543218", "098765432109876543210987654321",
						"156654321", "daniela.greca@gmail.com")), new Date(), (float) 4120.99, "B068");

		if (centrosDeCosto.size() == 0 && empleados.size() == 0) {
			listaDeGastos.add(gastoUno);
			listaDeGastos.add(gastoDos);
			listaDeGastos.add(gastoTres);
			listaDeGastos.add(gastoCuatro);
			return listaDeGastos;
		} else if (centrosDeCosto.size() != 0 && centrosDeCosto.get(0).getId() == 1 && empleados.size() == 0) {
			listaDeGastos.add(gastoUno);
			listaDeGastos.add(gastoTres);
			listaDeGastos.add(gastoCuatro);
			return listaDeGastos;
		} else if (centrosDeCosto.size() == 0 && empleados.size() != 0 && empleados.get(0).getId() == 1) {
			listaDeGastos.add(gastoUno);
			listaDeGastos.add(gastoDos);
			listaDeGastos.add(gastoTres);
			return listaDeGastos;
		} else if (centrosDeCosto.get(0).getId() == 1 && empleados.get(0).getId() == 2) {
			listaDeGastos.add(gastoCuatro);
			return listaDeGastos;
		}

		return null;
	}

}