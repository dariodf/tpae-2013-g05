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

import ar.edu.utn.frsf.tpae.a2013.g05.dao.GastoDAO;
import ar.edu.utn.frsf.tpae.a2013.g05.model.CentroDeCosto;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Empleado;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Gasto;

/**
 * @author Dario
 *
 */
public class GastoHibernate implements GastoDAO {

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
	public Gasto persistir(Gasto gasto) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(gasto);
		session.getTransaction().commit();
		session.close();

		return gasto;
	}

	@Override
	public List<Gasto> listarGastos(List<CentroDeCosto> centrosDeCosto,
			List<Empleado> empleados) {
		
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("SELECT FROM gst, slg WHERE gst_slg_id=sgl_id slg_cco=:centrosdecosto AND slg_emp_id=:empleados"); //TODO: Ver consulta
		query.setParameterList("centrosdecosto", centrosDeCosto);
		query.setParameterList("empleados", empleados);
		if (query.list().isEmpty())
			return null;
		List<Gasto> listaGastosSeleccionados=query.list();
		
					
		session.close();
		
		return listaGastosSeleccionados;
	}

	
	
}
