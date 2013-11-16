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
 * @author Dario
 * 
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
		switch ((centrosDeCosto.size() == 0) ? ((empleados.size() == 0) ? 0 : 1) : ((empleados.size() == 0) ? 2 : 3)) {
		case 0:
			query = getCurrentSession().createQuery("FROM Gasto");
			break;
		case 1:
			query = getCurrentSession().createQuery("FROM Gasto WHERE solicitudDeGastos.empleado=:empleados");
			query.setParameterList("empleados", empleados);
			break;
		case 2:
			query = getCurrentSession().createQuery("FROM Gasto WHERE solicitudDeGastos.centroDeCosto=:centrosdecosto");
			query.setParameterList("centrosdecosto", centrosDeCosto);
			break;
		case 3:
			query = getCurrentSession()
					.createQuery(
							"FROM Gasto WHERE solicitudDeGastos.centroDeCosto=:centrosdecosto AND solicitudDeGastos.empleado=:empleados");
			query.setParameterList("centrosdecosto", centrosDeCosto);
			query.setParameterList("empleados", empleados);
			break;

		default:
			query = null;
			return null;
		}

		@SuppressWarnings("unchecked")
		List<Gasto> listaGastosSeleccionados = query.list();

		return listaGastosSeleccionados;
	}

}
