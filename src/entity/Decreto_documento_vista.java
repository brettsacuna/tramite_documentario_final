package entity;

import com.sun.org.apache.bcel.internal.generic.DSTORE;

public class Decreto_documento_vista {

	private int decreto_documento_id;
	private String documento_id;
	private int seccion_id;
	private String seccion;
	private String fecha_decreto;
	private int estado;

	public Decreto_documento_vista() {

	}

	public Decreto_documento_vista(int decreto_documento_id, String documento_id, int seccion_id, String seccion,
			String fecha_decreto, int estado) {
		super();
		this.decreto_documento_id = decreto_documento_id;
		this.documento_id = documento_id;
		this.seccion_id = seccion_id;
		this.seccion = seccion;
		this.fecha_decreto = fecha_decreto;
		this.estado = estado;
	}

	public int getDecreto_documento_id() {
		return decreto_documento_id;
	}

	public void setDecreto_documento_id(int decreto_documento_id) {
		this.decreto_documento_id = decreto_documento_id;
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

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
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
