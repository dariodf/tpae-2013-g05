package ar.edu.utn.frsf.tpae.a2013.g05.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.edu.utn.frsf.tpae.a2013.g05.dao.UsuarioDAO;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Empleado;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Usuario;

/**
 * DAO de usuario basado en Hibernate.
 * 
 * @author Dario
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
	}

	@Override
	public List<Empleado> listarEmpleados() {
		Query query = getCurrentSession().createQuery("FROM Empleado");

		@SuppressWarnings("unchecked")
		List<Empleado> usuariosRetorno = query.list();
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
