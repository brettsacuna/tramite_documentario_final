package entity;

public class Situacion {

	private int situacion_id;
	private String situacion;
	private int estado;

	public Situacion(int situacion_id, String situacion, int estado) {
		super();
		this.situacion_id = situacion_id;
		this.situacion = situacion;
		this.estado = estado;
	}

	public Situacion() {

	}

	public int getSituacion_id() {
		return situacion_id;
	}

	public void setSituacion_id(int situacion_id) {
		this.situacion_id = situacion_id;
	}

	public String getSituacion() {
		return situacion;
	}

	public void setSituacion(String situacion) {
		this.situacion = situacion;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
}
