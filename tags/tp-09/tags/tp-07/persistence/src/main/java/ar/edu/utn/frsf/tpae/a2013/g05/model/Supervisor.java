/**
 * 
 */
package ar.edu.utn.frsf.tpae.a2013.g05.model;

import java.util.Date;

/**
 * @author root
 *
 */
public class Supervisor extends Usuario {
	private Date ultimoAcceso;

	
	
	
	

	/**
	 * @param id
	 * @param usuario
	 * @param password
	 * @param apellido
	 * @param nombre
	 * @param dni
	 * @param ultimoAcceso
	 */
	public Supervisor(int id, String usuario, String password, String apellido,
			String nombre, String dni, Date ultimoAcceso) {
		super(id, usuario, password, apellido, nombre, dni);
		this.ultimoAcceso = ultimoAcceso;
	}

	/**
	 * @return the ultimoAcceso
	 */
	public Date getUltimoAcceso() {
		return ultimoAcceso;
	}

	/**
	 * @param ultimoAcceso the ultimoAcceso to set
	 */
	public void setUltimoAcceso(Date ultimoAcceso) {
		this.ultimoAcceso = ultimoAcceso;
	}

	
	
}
