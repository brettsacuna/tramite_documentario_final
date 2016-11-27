package entity;

public class Decreto_documento_seccion {

	private String documento_id;
	private int seccion_id;
	private String fecha_decreto;
	private int estado;

	public Decreto_documento_seccion(String documento_id, int seccion_id, String fecha_decreto, int estado) {
		super();
		this.documento_id = documento_id;
		this.seccion_id = seccion_id;
		this.fecha_decreto = fecha_decreto;
		this.estado = estado;
	}

	public Decreto_documento_seccion() {

	}

	public String getDocumento_id() {
		return documento_id;
	}

	public void setDocumento_id(String documento_id) {
		this.documento_id = documento_id;
	}

	public int getSeccion_id() {
		return seccion_id;
	}

	public void setSeccion_id(int seccion_id) {
		this.seccion_id = seccion_id;
	}

	public String getFecha_decreto() {
		return fecha_decreto;
	}

	public void setFecha_decreto(String fecha_decreto) {
		this.fecha_decreto = fecha_decreto;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

}
