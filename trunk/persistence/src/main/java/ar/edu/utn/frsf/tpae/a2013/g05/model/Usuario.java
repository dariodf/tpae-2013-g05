/**
 * 
 */
package ar.edu.utn.frsf.tpae.a2013.g05.model;

import javax.persistence.*;

/**
 * @author 
 *
 */

@Entity
@Table(name = "usr")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Usuario {
	@Id
	@Column(name="usr_id")
	@SequenceGenerator(name = "SecuenciaUsuario", sequenceName = "seq_usr", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SecuenciaUsuario")
	private int id;
	
	@Column(name="usr_usr")
	private String usuario;
	
	@Column(name="usr_pwd")
	private String password;
	
	@Column(name="usr_ape")
	private String apellido;
	
	@Column(name="usr_nom")
	private String nombre;
	
	@Column(name="usr_dni")
	private String dni;
	
	
	
	public Usuario(){}//Constructor por defecto para Hibernate.
	
	
	/**
	 * @param id
	 * @param usuario
	 * @param password
	 * @param apellido
	 * @param nombre
	 * @param dni
	 */	
	public Usuario(int id, String usuario, String password, String apellido,
			String nombre, String dni) {
		this.id = id;
		this.usuario = usuario;
		this.password = password;
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}
	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}
	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
}
