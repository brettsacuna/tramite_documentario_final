package entity;

import com.sun.org.apache.bcel.internal.generic.FSTORE;

public class Documento_disposicion_vista {

	private int documento_disposicion_id;
	private String documento_id;
	private int disposicion_id;
	private String disposicion;
	private String fecha_disposicion;
	private int estado;

	public Documento_disposicion_vista() {

	}

	public Documento_disposicion_vista(int documento_disposicion_id, String documento_id, int disposicion_id,
			String disposicion, String fecha_disposicion, int estado) {
		super();
		this.documento_disposicion_id = documento_disposicion_id;
		this.documento_id = documento_id;
		this.disposicion_id = disposicion_id;
		this.disposicion = disposicion;
		this.fecha_disposicion = fecha_disposicion;
		this.estado = estado;
	}

	public int getDocumento_disposicion_id() {
		return documento_disposicion_id;
	}

	public void setDocumento_disposicion_id(int documento_disposicion_id) {
		this.documento_disposicion_id = documento_disposicion_id;
	}

	public String getDocumento_id() {
		return documento_id;
	}

	public void setDocumento_id(String documento_id) {
		this.documento_id = documento_id;
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

	public String getFecha_disposicion() {
		return fecha_disposicion;
	}

	public void setFecha_disposicion(String fecha_disposicion) {
		this.fecha_disposicion = fecha_disposicion;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

}
