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
		return null;
	}

	@Override
	public List<SolicitudDeGastos> listarSolicitudesPendientes(int idEmpleado) {
		return null;
	}

	@Override
	public List<SolicitudDeGastos> listarSolicitudes(int idEmpleado) {
		// TODO Auto-generated method stub
		return null;
	}

}
