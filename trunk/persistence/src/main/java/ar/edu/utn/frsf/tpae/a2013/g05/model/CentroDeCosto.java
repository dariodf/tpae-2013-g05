package ar.edu.utn.frsf.tpae.a2013.g05.model;

import java.io.Serializable;

import javax.persistence.*;

/**
 * @author root
 * 
 */
@Entity
@Table(name = "cco")
public class CentroDeCosto implements Serializable {

	private static final long serialVersionUID = 8141373408551731362L;

	@Id
	@Column(name = "cco_id")
	@SequenceGenerator(name = "SecuenciaCentroDeCosto", sequenceName = "seq_cco", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SecuenciaCentroDeCosto")
	private int id;

	@Column(name = "cco_nom")
	private String nombre;

	/**
	 * Constructor por defecto para Hibernate.
	 */
	public CentroDeCosto() {
	}

	/**
	 * @param id
	 * @param nombre
	 */
	public CentroDeCosto(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
