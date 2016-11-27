package entity;

public class Accion {
	private int accion_id;
	private String accion;
	private int estado;

	public Accion(int accion_id, String accion, int estado) {
		super();
		this.accion_id = accion_id;
		this.accion = accion;
		this.estado = estado;
	}

	public Accion() {

	}

	public int getAccion_id() {
		return accion_id;
	}

	public void setAccion_id(int accion_id) {
		this.accion_id = accion_id;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

}
