package entity;

public class Disposicion {
	private int disposicion_id;
	private String disposicion;
	private int estado;

	public Disposicion(int disposicion_id, String disposicion, int estado) {
		super();
		this.disposicion_id = disposicion_id;
		this.disposicion = disposicion;
		this.estado = estado;
	}

	public Disposicion() {

	}

	public int getDisposicion_id() {
		return disposicion_id;
	}

	public void setDisposicion_id(int disposicion_id) {
		this.disposicion_id = disposicion_id;
	}

	public String getDisposicion() {
		return disposicion;
	}

	public void setDisposicion(String disposicion) {
		this.disposicion = disposicion;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

}
