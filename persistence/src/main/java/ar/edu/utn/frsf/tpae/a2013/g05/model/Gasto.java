package ar.edu.utn.frsf.tpae.a2013.g05.model;

import java.io.Serializable;
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
@Table(name = "gst")
public class Gasto implements Serializable {

	private static final long serialVersionUID = 6968402046147272039L;

	@Id
	@Column(name = "gst_id")
	@SequenceGenerator(name = "SecuenciaGasto", sequenceName = "seq_gst", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SecuenciaGasto")
	private Integer id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "gst_slg_id")
	private SolicitudDeGastos solicitudDeGastos;

	@Column(name = "gst_fech_alta")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaAlta;
	
	@Column(name = "gst_fech_real")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRealizacion;

	@Column(name = "gst_imp")
	private float importe;

	@Column(name = "gst_nro_fact")
	private String nroFactura;

	/**
	 * Constructor por defecto para Hibernate.
	 */
	public Gasto() {
	}

	/**
	 * @param solicitudDeGastos
	 * @param fecha
	 * @param importe
	 * @param nroFactura
	 */
	public Gasto(SolicitudDeGastos solicitudDeGastos, Date fechaAlta, float importe, String nroFactura) {
		this.solicitudDeGastos = solicitudDeGastos;
		this.fechaAlta = fechaAlta;
		this.importe = importe;
		this.nroFactura = nroFactura;
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
	 * @return the solicitudDeGastos
	 */
	public SolicitudDeGastos getSolicitudDeGastos() {
		return solicitudDeGastos;
	}

	/**
	 * @param solicitudDeGastos
	 *            the solicitudDeGastos to set
	 */
	public void setSolicitudDeGastos(SolicitudDeGastos solicitudDeGastos) {
		this.solicitudDeGastos = solicitudDeGastos;
	}

	/**
	 * @return the importe
	 */
	public float getImporte() {
		return importe;
	}

	/**
	 * @param importe
	 *            the importe to set
	 */
	public void setImporte(float importe) {
		this.importe = importe;
	}

	/**
	 * @return the nroFactura
	 */
	public String getNroFactura() {
		return nroFactura;
	}

	/**
	 * @param nroFactura
	 *            the nroFactura to set
	 */
	public void setNroFactura(String nroFactura) {
		this.nroFactura = nroFactura;
	}

	/**
	 * @return the fechaAlta
	 */
	public Date getFechaAlta() {
		return fechaAlta;
	}

	/**
	 * @param fechaAlta the fechaAlta to set
	 */
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	/**
	 * @return the fechaRealizacion
	 */
	public Date getFechaRealizacion() {
		return fechaRealizacion;
	}

	/**
	 * @param fechaRealizacion the fechaRealizacion to set
	 */
	public void setFechaRealizacion(Date fechaRealizacion) {
		this.fechaRealizacion = fechaRealizacion;
	}

}
