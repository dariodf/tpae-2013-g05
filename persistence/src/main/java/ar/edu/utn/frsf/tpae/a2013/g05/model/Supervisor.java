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
