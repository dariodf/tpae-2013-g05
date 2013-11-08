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
@Table(name="gst")
public class Gasto {
        
        @Id
        @Column(name="gst_id")
        @SequenceGenerator(name = "SecuenciaGasto", sequenceName = "seq_gst", allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SecuenciaGasto")
        private Integer id;
        
        @ManyToOne
        @JoinColumn(name="gst_slg_id")
        private SolicitudDeGastos solicitudDeGastos;
        
        @Column(name="gst_fech")
        @Temporal(TemporalType.DATE)
        private Date fecha;
        
        @Column(name="gst_imp")
        private float importe;
        
        @Column(name="gst_nro_fact")
        private String nroFactura;
	
        @Column(name="gst_cmt_emp")
        private String comentario;
	
    public Gasto(){};//Constructor por defecto para Hibernate.
	/**
	 * @param id
	 * @param solicitudDeGastos
	 * @param fecha
	 * @param importe
	 * @param nroFactura
	 */
	public Gasto(int id, SolicitudDeGastos solicitudDeGastos, Date fecha,
			float importe, String nroFactura) {
		this.id = id;
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
	 * @param id the id to set
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
	 * @param solicitudDeGastos the solicitudDeGastos to set
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
	 * @param fecha the fecha to set
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
	 * @param importe the importe to set
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
	 * @param nroFactura the nroFactura to set
	 */
	public void setNroFactura(String nroFactura) {
		this.nroFactura = nroFactura;
	}
	/**
	 * @return the comentario
	 */
	public String getComentario() {
		return comentario;
	}
	/**
	 * @param comentario the comentario to set
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
}
