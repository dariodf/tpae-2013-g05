/**
 * 
 */
package ar.edu.utn.frsf.tpae.a2013.g05.model;

import java.util.Date;

import javax.persistence.*;

/**
 * @author root
 *
 */

@Entity
@Table(name="spv")
public class Supervisor extends Usuario{

        @Column(name="spv_ult_acc")
        @Temporal(TemporalType.DATE)
        private Date ultimoAcceso;

	
	
	
    public Supervisor(){};//Constructor por defecto para Hibernate.

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
