package entity;

public class Clasificacion {

	private int clasificacion_id;
	private String clasificacion;
	private int estado;

	public Clasificacion(int clasificacion_id, String clasificacion, int estado) {
		super();
		this.clasificacion_id = clasificacion_id;
		this.clasificacion = clasificacion;
		this.estado = estado;
	}

	public Clasificacion() {

	}

	public int getClasificacion_id() {
		return clasificacion_id;
	}

	public void setClasificacion_id(int clasificacion_id) {
		this.clasificacion_id = clasificacion_id;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

}
