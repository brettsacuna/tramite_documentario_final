package entity;

public class Respuesta {

	private int estado;
	private String adjunto;

	public Respuesta(int estado, String adjunto) {
		super();
		this.estado = estado;
		this.adjunto = adjunto;
	}

	public Respuesta() {

	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getAdjunto() {
		return adjunto;
	}

	public void setAdjunto(String adjunto) {
		this.adjunto = adjunto;
	}

}
