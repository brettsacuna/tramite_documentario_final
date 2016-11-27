package entity;

public class Unidad {
	private int unidad_id;
	private String unidad_id_interno;
	private String unidad;
	private String unidad_gguu;
	private String unidad_nucleo;
	private int estado;

	public Unidad(int unidad_id, String unidad_id_interno, String unidad, String unidad_gguu, String unidad_nucleo,
			int estado) {
		super();
		this.unidad_id = unidad_id;
		this.unidad_id_interno = unidad_id_interno;
		this.unidad = unidad;
		this.unidad_gguu = unidad_gguu;
		this.unidad_nucleo = unidad_nucleo;
		this.estado = estado;
	}

	public Unidad() {

	}

	public int getUnidad_id() {
		return unidad_id;
	}

	public void setUnidad_id(int unidad_id) {
		this.unidad_id = unidad_id;
	}

	public String getUnidad_id_interno() {
		return unidad_id_interno;
	}

	public void setUnidad_id_interno(String unidad_id_interno) {
		this.unidad_id_interno = unidad_id_interno;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public String getUnidad_gguu() {
		return unidad_gguu;
	}

	public void setUnidad_gguu(String unidad_gguu) {
		this.unidad_gguu = unidad_gguu;
	}

	public String getUnidad_nucleo() {
		return unidad_nucleo;
	}

	public void setUnidad_nucleo(String unidad_nucleo) {
		this.unidad_nucleo = unidad_nucleo;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

}
