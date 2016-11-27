package entity;

public class Seccion {

	private int seccion_id;
	private String seccion;
	private String seccion_larga;
	private String seccion_abreviada;
	private int estado;

	public Seccion(int seccion_id, String seccion, String seccion_larga, String seccion_abreviada, int estado) {
		super();
		this.seccion_id = seccion_id;
		this.seccion = seccion;
		this.seccion_larga = seccion_larga;
		this.seccion_abreviada = seccion_abreviada;
		this.estado = estado;
	}

	public Seccion() {

	}

	public int getSeccion_id() {
		return seccion_id;
	}

	public void setSeccion_id(int seccion_id) {
		this.seccion_id = seccion_id;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public String getSeccion_larga() {
		return seccion_larga;
	}

	public void setSeccion_larga(String seccion_larga) {
		this.seccion_larga = seccion_larga;
	}

	public String getSeccion_abreviada() {
		return seccion_abreviada;
	}

	public void setSeccion_abreviada(String seccion_abreviada) {
		this.seccion_abreviada = seccion_abreviada;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

}
