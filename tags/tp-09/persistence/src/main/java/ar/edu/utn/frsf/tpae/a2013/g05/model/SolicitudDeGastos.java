package ar.edu.utn.frsf.tpae.a2013.g05.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author root
 * 
 */
@Entity
@Table(name = "slg")
public class SolicitudDeGastos {

	@Id
	@Column(name = "slg_id")
	@SequenceGenerator(name = "SecuenciaSolicitud", sequenceName = "seq_slg", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SecuenciaSolicitud")
	private Integer id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "slg_emp_id")
	private Empleado empleado;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "slg_cco_id")
	private CentroDeCosto centroDeCosto;

	@Column(name = "slg_desc")
	private String descripcion;

	@Column(name = "slg_fecha_creacion")
	@Temporal(TemporalType.DATE)
	private Date fechaCreacion;

	@Column(name = "slg_fecha_aprobacion")
	@Temporal(TemporalType.DATE)
	private Date fechaAprobacion;

	@Column(name = "slg_imp_est")
	private float importeEstimado;

	@Column(name = "slg_est")
	private String estado;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "slg_spv_id")
	private Supervisor supervisor;

	@Column(name = "slg_cmt_spv")
	private String comentario;

	/**
	 * Constructor por defecto para Hibernate.
	 */
	public SolicitudDeGastos() {
	}

	/**
	 * @param centroDeCosto
	 * @param descripcion
	 * @param importeEstimado
	 * @param estado
	 * @param fechaCreacion
	 * @param fechaAprobacion
	 * @param supervisor
	 * @param comentario
	 */
	public SolicitudDeGastos(CentroDeCosto centroDeCosto, String descripcion, float importeEstimado, String estado,
			Date fechaCreacion, Date fechaAprobacion, Supervisor supervisor, Empleado empleado, String comentario) {
		this.centroDeCosto = centroDeCosto;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.fechaAprobacion = fechaAprobacion;
		this.importeEstimado = importeEstimado;
		this.estado = estado;
		this.supervisor = supervisor;
		this.empleado = empleado;
		this.comentario = comentario;
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
	 * @return the centroDeCosto
	 */
	public CentroDeCosto getCentroDeCosto() {
		return centroDeCosto;
	}

	/**
	 * @param centroDeCosto
	 *            the centroDeCosto to set
	 */
	public void setCentroDeCosto(CentroDeCosto centroDeCosto) {
		this.centroDeCosto = centroDeCosto;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the fechaCreacion
	 */
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * @param fechaCreacion
	 *            the fechaCreacion to set
	 */
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * @return the fechaAprobacion
	 */
	public Date getFechaAprobacion() {
		return fechaAprobacion;
	}

	/**
	 * @param fechaAprobacion
	 *            the fechaAprobacion to set
	 */
	public void setFechaAprobacion(Date fechaAprobacion) {
		this.fechaAprobacion = fechaAprobacion;
	}

	/**
	 * @return the importeEstimado
	 */
	public float getImporteEstimado() {
		return importeEstimado;
	}

	/**
	 * @param importeEstimado
	 *            the importeEstimado to set
	 */
	public void setImporteEstimado(float importeEstimado) {
		this.importeEstimado = importeEstimado;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado
	 *            the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the supervisor
	 */
	public Supervisor getSupervisor() {
		return supervisor;
	}

	/**
	 * @param supervisor
	 *            the supervisor to set
	 */
	public void setSupervisor(Supervisor supervisor) {
		this.supervisor = supervisor;
	}

	/**
	 * @return the empleado
	 */
	public Empleado getEmpleado() {
		return empleado;
	}

	/**
	 * @param empleado
	 *            the empleado to set
	 */
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	/**
	 * @return the comentario
	 */
	public String getComentario() {
		return comentario;
	}

	/**
	 * @param comentario
	 *            the comentario to set
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

}
