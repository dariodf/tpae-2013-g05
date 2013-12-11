package ar.edu.utn.frsf.tpae.a2013.g05.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.utn.frsf.tpae.a2013.g05.dao.UsuarioDAO;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Empleado;
import ar.edu.utn.frsf.tpae.a2013.g05.model.Usuario;
import ar.edu.utn.frsf.tpae.a2013.g05.service.UsuarioService;

/**
 * Implementación del servicio para usuario.
 * 
 * @author Daniela
 */
public class UsuarioServiceImpl implements UsuarioService {

	private UsuarioDAO usuarioDAO;
	
	private Usuario usuarioLogueado;

	public Usuario getUsuarioLogueado() {
		return usuarioLogueado;
	}

	// Setter utilizado por Spring.
	@Autowired(required = true)
	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	@Override
	public Usuario buscarUsuario(String usuario, String password) {
		this.usuarioLogueado = usuarioDAO.validarUsuario(usuario, password);
		return this.usuarioLogueado;
	}

	@Override
	public Usuario crearUsuario(Usuario usuario) {
		return this.usuarioDAO.persistir(usuario);
	}

	@Override
	public List<Empleado> listarEmpleados() {
		return this.usuarioDAO.listarEmpleados();
	}

}
