package ar.edu.utn.frsf.tpae.a2013.g05.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.utn.frsf.tpae.a2013.g05.dao.UsuarioDAO;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Usuario;
import ar.edu.utn.frsf.tpae.a2013.g05.service.UsuarioService;

/**
 * Implementación del servicio para usuario.
 * 
 * @author Daniela
 */
public class UsuarioServiceImpl implements UsuarioService {

	private UsuarioDAO usuarioDao;

	// Setter utilizado por Spring.
	@Autowired(required = true)
	public void setUsuarioDao(UsuarioDAO usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	@Override
	public Usuario ingresar(String usuario, String password) {
		return usuarioDao.validarUsuario(usuario, password);
	}

	@Override
	public Usuario crear(Usuario usuario) {
		return this.usuarioDao.persistir(usuario);
	}

}
