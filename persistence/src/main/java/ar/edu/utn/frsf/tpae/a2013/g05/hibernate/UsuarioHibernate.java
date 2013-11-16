package ar.edu.utn.frsf.tpae.a2013.g05.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.edu.utn.frsf.tpae.a2013.g05.dao.UsuarioDAO;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Usuario;

/**
 * @author Dario
 * 
 */
@Component
public class UsuarioHibernate implements UsuarioDAO {

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
	public Usuario validarUsuario(String usuario, String password) {
		Query query = getCurrentSession().createQuery("FROM Usuario WHERE usuario=:usuario AND password=:password");
		query.setString("usuario", usuario);
		query.setString("password", password);

		return (Usuario) query.uniqueResult();

		// query =
		// getCurrentSession().createQuery("FROM Empleado WHERE id=:id");
		// query.setInteger("id", usuarioTemporal.getId());
		// if (query.list().isEmpty()) {
		// query =
		// getCurrentSession().createQuery("FROM Supervisor WHERE id=:id");
		// query.setInteger("id", usuarioTemporal.getId());
		// if (query.list().isEmpty())
		// return null;
		// else {
		// // Guardamos el resultado para poder cerrar la sesión.
		// usuarioRetorno = (Supervisor) query.uniqueResult();
		// }
		//
		// } else {
		// // Guardamos el resultado para poder cerrar la sesión.
		// usuarioRetorno = (Empleado) query.uniqueResult();
		// }
		// return usuarioRetorno;
	}

	@Override
	public List<Usuario> listarEmpleados() {
		Query query = getCurrentSession().createQuery("FROM Empleado");

		@SuppressWarnings("unchecked")
		List<Usuario> usuariosRetorno = query.list();
		return usuariosRetorno;
	}

	@Override
	public Usuario persistir(Usuario usuario) {
		getCurrentSession().save(usuario);

		Query query = getCurrentSession().createQuery("FROM Usuario WHERE id=:id");
		query.setInteger("id", usuario.getId());

		return (Usuario) query.uniqueResult();
	}

}
