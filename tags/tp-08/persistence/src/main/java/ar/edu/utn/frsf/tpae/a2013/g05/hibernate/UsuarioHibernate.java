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

import ar.edu.utn.frsf.tpae.a2013.g05.dao.UsuarioDAO;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Empleado;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Supervisor;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Usuario;

/**
 * @author Dario
 *
 */
public class UsuarioHibernate implements UsuarioDAO {

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
	public Usuario validarUsuario(String usuario, String password) {
		Usuario usuarioRetorno;
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createQuery("FROM Usuario WHERE usuario=:usuario AND password=:password");
		query.setString("usuario", usuario);
		query.setString("password", password);
		if (query.list().isEmpty())
			return null;

		
		Usuario usuarioTemporal= (Usuario) query.uniqueResult();
		
		query = session.createQuery("FROM Empleado WHERE id=:id");
		query.setInteger("id", usuarioTemporal.getId());
		if (query.list().isEmpty())
		{
			query = session.createQuery("FROM Supervisor WHERE id=:id");
			query.setInteger("id", usuarioTemporal.getId());
			if (query.list().isEmpty())
				return null;
			else
				usuarioRetorno = (Supervisor) query.uniqueResult();// Guardamos el resultado para poder cerrar la sesión.
		}
		else
			usuarioRetorno = (Empleado) query.uniqueResult();// Guardamos el resultado para poder cerrar la sesión.
		
		
		
		
		session.close();
		
		return usuarioRetorno;
	}

	@Override
	public List<Usuario> listarEmpleados() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createQuery("FROM Empleado");
		if (query.list().isEmpty())
			return null;
		List<Usuario> usuariosRetorno = query.list();		
		session.close();				
		return usuariosRetorno;
	}

}
