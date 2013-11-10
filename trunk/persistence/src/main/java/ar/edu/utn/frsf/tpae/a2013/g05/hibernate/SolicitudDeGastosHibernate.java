/**
 * 
 */
package ar.edu.utn.frsf.tpae.a2013.g05.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import ar.edu.utn.frsf.tpae.a2013.g05.dao.SolicitudDeGastosDAO;
import ar.edu.utn.frsf.tpae.a2013.g05.model.SolicitudDeGastos;

/**
 * @author Dario
 *
 */
public class SolicitudDeGastosHibernate implements SolicitudDeGastosDAO {

    private static SessionFactory  sessionFactory = configureSessionFactory();
    private static ServiceRegistry serviceRegistry;

    private static SessionFactory configureSessionFactory() throws HibernateException {
        Configuration configuration = new Configuration();
        configuration.configure();
        serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }
    
	@Override
	public SolicitudDeGastos persistir(SolicitudDeGastos solicitudDeGastos) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(solicitudDeGastos);
		session.getTransaction().commit();
		Query query = session.createQuery("FROM SolicitudDeGastos WHERE id=:id");
		query.setInteger("id", solicitudDeGastos.getId());
		if (query.list().isEmpty())
			return null;
		SolicitudDeGastos solicitudRetorno = (SolicitudDeGastos) query.uniqueResult();
		session.close();
		return solicitudRetorno;
	}

	@Override
	public List<SolicitudDeGastos> listarSolicitudesPendientes(int idEmpleado) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createQuery("FROM SolicitudDeGastos WHERE empleado.id=:idEmpleado AND estado=:estado");
		query.setInteger("idEmpleado", idEmpleado);
		query.setString("estado", "No Procesada");
		if (query.list().isEmpty())
			return null;
		List<SolicitudDeGastos> listaRetorno = query.list();
		
		session.close();
		return listaRetorno;
	}

	@Override
	public List<SolicitudDeGastos> listarSolicitudes(int idEmpleado) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createQuery("FROM SolicitudDeGastos WHERE empleado.id=:idEmpleado");
		query.setInteger("idEmpleado", idEmpleado);
		if (query.list().isEmpty())
			return null;
		List<SolicitudDeGastos> listaRetorno = query.list();
		
		session.close();
		return listaRetorno;		
	}

}
