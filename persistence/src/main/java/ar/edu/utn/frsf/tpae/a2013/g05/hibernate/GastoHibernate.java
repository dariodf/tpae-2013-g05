package ar.edu.utn.frsf.tpae.a2013.g05.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.edu.utn.frsf.tpae.a2013.g05.dao.GastoDAO;
import ar.edu.utn.frsf.tpae.a2013.g05.model.CentroDeCosto;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Empleado;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Gasto;

/**
 * DAO de Gasto basado en Hibernate.
 * 
 * @author Dario
 */
@Component
public class GastoHibernate implements GastoDAO {

	private SessionFactory sessionFactory;

	// Setter utilizado por Spring.
	@Autowired(required = true)
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Gasto persistir(Gasto gasto) {
		getCurrentSession().save(gasto);

		Query query = getCurrentSession().createQuery("FROM Gasto WHERE id=:id");
		query.setInteger("id", gasto.getId());

		return (Gasto) query.uniqueResult();
	}

	@Override
	public List<Gasto> listarGastos(List<CentroDeCosto> centrosDeCosto, List<Empleado> empleados) {
		Query query;
		int longitudListaEmpleados = empleados.size();

		if (centrosDeCosto.size() == 0) {

			if (longitudListaEmpleados == 0) {
				query = getCurrentSession().createQuery("FROM Gasto");
			} else {
				query = getCurrentSession().createQuery("FROM Gasto WHERE solicitudDeGastos.empleado=:empleados");
				query.setParameterList("empleados", empleados);
			}

		} else {

			if (longitudListaEmpleados == 0) {
				query = getCurrentSession().createQuery(
						"FROM Gasto WHERE solicitudDeGastos.centroDeCosto=:centrosdecosto");
				query.setParameterList("centrosdecosto", centrosDeCosto);
			} else {
				query = getCurrentSession()
						.createQuery(
								"FROM Gasto WHERE solicitudDeGastos.centroDeCosto=:centrosdecosto AND solicitudDeGastos.empleado=:empleados");
				query.setParameterList("centrosdecosto", centrosDeCosto);
				query.setParameterList("empleados", empleados);
			}
		}

		@SuppressWarnings("unchecked")
		List<Gasto> listaGastosSeleccionados = query.list();

		return listaGastosSeleccionados;
	}

}
