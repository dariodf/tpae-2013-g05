package ar.edu.utn.frsf.tpae.a2013.g05.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.edu.utn.frsf.tpae.a2013.g05.dao.CentroDeCostoDAO;
import ar.edu.utn.frsf.tpae.a2013.g05.model.CentroDeCosto;

/**
 * @author Dario
 * 
 */
@Component
public class CentroDeCostoHibernate implements CentroDeCostoDAO {

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
	public List<CentroDeCosto> listarCentrosDeCosto() {
		Query query = getCurrentSession().createQuery("FROM CentroDeCosto");
		@SuppressWarnings("unchecked")
		List<CentroDeCosto> centrosDeCostoRetorno = query.list();
		return centrosDeCostoRetorno;
	}

}
