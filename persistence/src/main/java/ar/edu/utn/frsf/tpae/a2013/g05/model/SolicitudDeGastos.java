/**
 * 
 */
package ar.edu.utn.frsf.tpae.a2013.g05.model;

/**
 * @author root
 *
 */
public class SolicitudDeGastos {

	private int id;
	private CentroDeCosto centroDeCosto;
	private String descripcion;
	private float importeEstimado;
	private String estado;
	private Supervisor supervisor;
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
	 * @return the centroDeCosto
	 */
	public CentroDeCosto getCentroDeCosto() {
		return centroDeCosto;
	}
	/**
	 * @param centroDeCosto the centroDeCosto to set
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
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the importeEstimado
	 */
	public float getImporteEstimado() {
		return importeEstimado;
	}
	/**
	 * @param importeEstimado the importeEstimado to set
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
	 * @param estado the estado to set
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
	 * @param supervisor the supervisor to set
	 */
	public void setSupervisor(Supervisor supervisor) {
		this.supervisor = supervisor;
	}

	
}
