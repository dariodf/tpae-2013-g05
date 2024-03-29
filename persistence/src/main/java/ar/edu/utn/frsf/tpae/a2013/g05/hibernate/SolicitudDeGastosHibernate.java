package ar.edu.utn.frsf.tpae.a2013.g05.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.edu.utn.frsf.tpae.a2013.g05.dao.SolicitudDeGastosDAO;
import ar.edu.utn.frsf.tpae.a2013.g05.model.SolicitudDeGastos;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Constantes;

/**
 * DAO de Solicitud de Gasto basado en Hibernate.
 * 
 * @author Dario
 */
@Component
public class SolicitudDeGastosHibernate implements SolicitudDeGastosDAO {

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
	public SolicitudDeGastos persistir(SolicitudDeGastos solicitudDeGastos) {
		getCurrentSession().saveOrUpdate(solicitudDeGastos);

		Query query = getCurrentSession().createQuery("FROM SolicitudDeGastos WHERE id=:id");
		query.setInteger("id", solicitudDeGastos.getId());

		return (SolicitudDeGastos) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SolicitudDeGastos> listarSolicitudesPendientes(int idEmpleado) {
		Query query = getCurrentSession().createQuery(
				"FROM SolicitudDeGastos WHERE empleado.id=:idEmpleado AND estado=:estado  ORDER BY fechaCreacion DESC");
		query.setInteger("idEmpleado", idEmpleado);
		query.setString("estado", Constantes.PENDIENTE.name());

		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SolicitudDeGastos> listarSolicitudes(int idEmpleado) {
		Query query = getCurrentSession().createQuery("FROM SolicitudDeGastos WHERE empleado.id=:idEmpleado  ORDER BY fechaCreacion DESC");
		query.setInteger("idEmpleado", idEmpleado);

		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SolicitudDeGastos> listarSolicitudesPendientes() {
		Query query = getCurrentSession().createQuery("FROM SolicitudDeGastos WHERE estado=:estado ORDER BY fechaCreacion DESC");
		query.setString("estado", Constantes.PENDIENTE.name());

		return query.list();
	}

}
