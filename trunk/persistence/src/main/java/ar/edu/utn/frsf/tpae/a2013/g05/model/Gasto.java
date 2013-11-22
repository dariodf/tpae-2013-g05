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
@Table(name = "gst")
public class Gasto {

	@Id
	@Column(name = "gst_id")
	@SequenceGenerator(name = "SecuenciaGasto", sequenceName = "seq_gst", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SecuenciaGasto")
	private Integer id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "gst_slg_id")
	private SolicitudDeGastos solicitudDeGastos;

	@Column(name = "gst_fech")
	@Temporal(TemporalType.DATE)
	private Date fecha;

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
	public Gasto(SolicitudDeGastos solicitudDeGastos, Date fecha, float importe, String nroFactura) {
		this.solicitudDeGastos = solicitudDeGastos;
		this.fecha = fecha;
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
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha
	 *            the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
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

}
