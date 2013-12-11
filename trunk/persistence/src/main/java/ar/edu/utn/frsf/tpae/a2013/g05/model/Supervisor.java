package ar.edu.utn.frsf.tpae.a2013.g05.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * @author root
 * 
 */
@Entity
@Table(name = "spv")
public class Supervisor extends Usuario implements Serializable {

	private static final long serialVersionUID = 6205548401818672691L;

	@Column(name = "spv_ult_acc")
	@Temporal(TemporalType.TIMESTAMP)
	private Date ultimoAcceso;

	/**
	 * Constructor por defecto para Hibernate.
	 */
	public Supervisor() {
	}

	/**
	 * @param usuario
	 * @param password
	 * @param apellido
	 * @param nombre
	 * @param dni
	 * @param ultimoAcceso
	 */
	public Supervisor(String usuario, String password, String apellido, String nombre, String dni,
			Date ultimoAcceso) {
		super(usuario, password, apellido, nombre, dni);
		this.ultimoAcceso = ultimoAcceso;
	}

	/**
	 * @return the ultimoAcceso
	 */
	public Date getUltimoAcceso() {
		return ultimoAcceso;
	}

	/**
	 * @param ultimoAcceso
	 *            the ultimoAcceso to set
	 */
	public void setUltimoAcceso(Date ultimoAcceso) {
		this.ultimoAcceso = ultimoAcceso;
	}

}
