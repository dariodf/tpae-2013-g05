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
		getCurrentSession().saveOrUpdate(gasto);

		Query query = getCurrentSession().createQuery("FROM Gasto WHERE id=:id");
		query.setInteger("id", gasto.getId());

		return (Gasto) query.uniqueResult();
	}

	@Override
	public List<Gasto> listarGastos(CentroDeCosto centroDeCosto, Empleado empleado) {
		Query query;

		if (empleado == null && centroDeCosto == null) {
			query = getCurrentSession().createQuery("FROM Gasto");

		} else if (centroDeCosto == null) {
			query = getCurrentSession().createQuery("FROM Gasto WHERE solicitudDeGastos.empleado=:empleado");
			query.setParameter("empleado", empleado);

		} else if (empleado == null) {
			query = getCurrentSession().createQuery("FROM Gasto WHERE solicitudDeGastos.centroDeCosto=:centrodecosto");
			query.setParameter("centrodecosto", centroDeCosto);
		} else {
			query = getCurrentSession()
					.createQuery(
							"FROM Gasto WHERE solicitudDeGastos.centroDeCosto=:centrodecosto AND solicitudDeGastos.empleado=:empleado");
			query.setParameter("centrodecosto", centroDeCosto);
			query.setParameter("empleado", empleado);
		}

		@SuppressWarnings("unchecked")
		List<Gasto> listaGastosSeleccionados = query.list();

		return listaGastosSeleccionados;
	}

}
