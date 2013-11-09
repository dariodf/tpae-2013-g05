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
import ar.edu.utn.frsf.tpae.a2013.g05.model.SolicitudDeGastos;

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
		Query query = session.createQuery("FROM Gasto WHERE id=:id");
		query.setInteger("id", gasto.getId());
		if (query.list().isEmpty())
			return null;
		Gasto gastoRetorno = (Gasto) query.uniqueResult();
		session.close();
		return gastoRetorno;
	}

	@Override
	public List<Gasto> listarGastos(List<CentroDeCosto> centrosDeCosto,
			List<Empleado> empleados) {
		
		Session session = sessionFactory.openSession();
		Query query;
		switch ((centrosDeCosto.size() == 0)? ((empleados.size()==0)? 0: 1):((empleados.size()==0)? 2: 3)) {
		case 0:
			query = session.createQuery("FROM Gasto");
			break;
		case 1:
			query = session.createQuery("FROM Gasto WHERE solicitudDeGastos.empleado=:empleados");
			query.setParameterList("empleados", empleados);
			break;
		case 2:
			query = session.createQuery("FROM Gasto WHERE solicitudDeGastos.centroDeCosto=:centrosdecosto");
			query.setParameterList("centrosdecosto", centrosDeCosto);
			break;
		case 3:
			query = session.createQuery("FROM Gasto WHERE solicitudDeGastos.centroDeCosto=:centrosdecosto AND solicitudDeGastos.empleado=:empleados");
			query.setParameterList("centrosdecosto", centrosDeCosto);
			query.setParameterList("empleados", empleados);
			break;

		default:
			query = null;
			return null;
		}
		 
		
		
		
		if (query.list().isEmpty())
			return null;
		List<Gasto> listaGastosSeleccionados=query.list();
		
					
		session.close();
		
		return listaGastosSeleccionados;
	}

	
	
}
