package ar.edu.utn.frsf.tpae.a2013.g05.model;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Objeto del modelo de datos (persistente). Representa un empleado de la
 * empresa.
 * 
 * @author root
 */
@Entity
@Table(name = "emp")
public class Empleado extends Usuario implements Serializable {

	private static final long serialVersionUID = -103528344938423134L;

	@Column(name = "emp_crg")
	private String cargo;

	@Column(name = "emp_ncta")
	private String nroCuenta;

	@Column(name = "emp_tel")
	private String telefono;

	@Column(name = "emp_cuil")
	private String cuil;

	@Column(name = "emp_mail")
	private String email;

	/**
	 * Constructor por defecto para Hibernate.
	 */
	public Empleado() {
	}

	/**
	 * @param usuario
	 * @param password
	 * @param apellido
	 * @param nombre
	 * @param dni
	 * @param cargo
	 * @param cuil
	 * @param nroCuenta
	 * @param telefono
	 * @param email
	 */
	public Empleado(String usuario, String password, String apellido, String nombre, String dni, String cargo,
			String cuil, String nroCuenta, String telefono, String email) {
		super(usuario, password, apellido, nombre, dni);
		this.cargo = cargo;
		this.cuil = cuil;
		this.nroCuenta = nroCuenta;
		this.telefono = telefono;
		this.email = email;
	}

	/**
	 * @return the cargo
	 */
	public String getCargo() {
		return cargo;
	}

	/**
	 * @param cargo
	 *            the cargo to set
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	/**
	 * @return the cuil
	 */
	public String getCuil() {
		return cuil;
	}

	/**
	 * @param cuil
	 *            the cuil to set
	 */
	public void setCuil(String cuil) {
		this.cuil = cuil;
	}

	/**
	 * @return the nroCuenta
	 */
	public String getNroCuenta() {
		return nroCuenta;
	}

	/**
	 * @param nroCuenta
	 *            the nroCuenta to set
	 */
	public void setNroCuenta(String nroCuenta) {
		this.nroCuenta = nroCuenta;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono
	 *            the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
