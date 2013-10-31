/**
 * 
 */
package ar.edu.utn.frsf.tpae.a2013.g05.model;

/**
 * @author root
 *
 */
public class Empleado extends Usuario {
	private String cargo;
	private String cuil;
	private String nroCuenta;
	private String telefono;
	private String email;
	
	
	
	
	
	/**
	 * @param id
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
	public Empleado(int id, String usuario, String password, String apellido,
			String nombre, String dni, String cargo, String cuil,
			String nroCuenta, String telefono, String email) {
		super(id, usuario, password, apellido, nombre, dni);
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
	 * @param cargo the cargo to set
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
	 * @param cuil the cuil to set
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
	 * @param nroCuenta the nroCuenta to set
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
	 * @param telefono the telefono to set
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
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
