package ar.edu.utn.frsf.tpae.a2013.g05.dao.mocks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ar.edu.utn.frsf.tpae.a2013.g05.dao.SolicitudDeGastosDAO;
import ar.edu.utn.frsf.tpae.a2013.g05.model.CentroDeCosto;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Empleado;
import ar.edu.utn.frsf.tpae.a2013.g05.model.SolicitudDeGastos;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Supervisor;

/**
 * 
 * @author Agustín
 */
public class SolicitudDeGastosMockDAO implements SolicitudDeGastosDAO {

	@Override
	public SolicitudDeGastos persistir(SolicitudDeGastos solicitudDeGastos) {
		// Acá persistiría
		return solicitudDeGastos;
	}

	@Override
	public List<SolicitudDeGastos> listarSolicitudesPendientes(int idEmpleado) {

		if (idEmpleado == 1) {
			ArrayList<SolicitudDeGastos> solicitudes = new ArrayList<SolicitudDeGastos>();
			solicitudes.add(new SolicitudDeGastos(new CentroDeCosto("Centro Uno"), "Gastos en viajes a CBA",
					(float) 12334.34, "No Procesada", new Date(), new Supervisor("Dario", "5678", "De Filippis",
							"Dario", "30789456", new Date()), new Empleado("Agustin", "1234", "Martinez", "Agustin",
							"32123456", "Programador Java Junior", "20321234568", "123456789012345678901234567890",
							"156123456", "mrtnz.agustin@gmail.com")));
			solicitudes.add(new SolicitudDeGastos(new CentroDeCosto("Centro Dos"), "Gastos en viajes a ER",
					(float) 24134.65, "No Procesada", new Date(), new Supervisor("Dario", "5678", "De Filippis",
							"Dario", "30789456", new Date()), new Empleado("Agustin", "1234", "Martinez", "Agustin",
							"32123456", "Programador Java Junior", "20321234568", "123456789012345678901234567890",
							"156123456", "mrtnz.agustin@gmail.com")));
			solicitudes.add(new SolicitudDeGastos(new CentroDeCosto("Centro Dos"), "Comidas evento Federal",
					(float) 15134.35, "No Procesada", new Date(), new Supervisor("Dario", "5678", "De Filippis",
							"Dario", "30789456", new Date()), new Empleado("Agustin", "1234", "Martinez", "Agustin",
							"32123456", "Programador Java Junior", "20321234568", "123456789012345678901234567890",
							"156123456", "mrtnz.agustin@gmail.com")));
			return solicitudes;
		}
		return null;
	}

	@Override
	public List<SolicitudDeGastos> listarSolicitudes(int idEmpleado) {

		if (idEmpleado == 1) {
			ArrayList<SolicitudDeGastos> solicitudes = new ArrayList<SolicitudDeGastos>();
			solicitudes.add(new SolicitudDeGastos(new CentroDeCosto("Centro Uno"), "Gastos en viajes a CBA", 12354,
					"No Procesada", new Date(), new Supervisor("Dario", "5678", "De Filippis", "Dario", "30789456",
							new Date()), new Empleado("Agustin", "1234", "Martinez", "Agustin", "32123456",
							"Programador Java Junior", "20321234568", "123456789012345678901234567890", "156123456",
							"mrtnz.agustin@gmail.com")));
			solicitudes.add(new SolicitudDeGastos(new CentroDeCosto("Centro Dos"), "Gastos en viajes a ER", 12354,
					"Aprobada", new Date(), new Supervisor("Dario", "5" + "678", "De Filippis", "Dario", "30789456",
							new Date()), new Empleado("Agustin", "1234", "Martinez", "Agustin", "32123456",
							"Programador Java Junior", "20321234568", "123456789012345678901234567890", "156123456",
							"mrtnz.agustin@gmail.com")));
			solicitudes.add(new SolicitudDeGastos(new CentroDeCosto("Centro Dos"), "Comidas evento Federal", 12354,
					"Rechazada", new Date(), new Supervisor("Dario", "5678", "De Filippis", "Dario", "30789456",
							new Date()), new Empleado("Agustin", "1234", "Martinez", "Agustin", "32123456",
							"Programador Java Junior", "20321234568", "123456789012345678901234567890", "156123456",
							"mrtnz.agustin@gmail.com")));
			return solicitudes;
		}

		return null;

	}

}
