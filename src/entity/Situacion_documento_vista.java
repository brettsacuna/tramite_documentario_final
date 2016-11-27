package entity;

public class Situacion_documento_vista {

	private int seguimiento_documento_id;
	private String documento_id;
	private int situacion_id;
	private String situacion;
	private String fecha_seguimiento;
	private int estado;

	public Situacion_documento_vista() {

	}

	public Situacion_documento_vista(int seguimiento_documento_id, String documento_id, int situacion_id,
			String situacion, String fecha_seguimiento, int estado) {
		super();
		this.seguimiento_documento_id = seguimiento_documento_id;
		this.documento_id = documento_id;
		this.situacion_id = situacion_id;
		this.situacion = situacion;
		this.fecha_seguimiento = fecha_seguimiento;
		this.estado = estado;
	}

	public int getSeguimiento_documento_id() {
		return seguimiento_documento_id;
	}

	public void setSeguimiento_documento_id(int seguimiento_documento_id) {
		this.seguimiento_documento_id = seguimiento_documento_id;
	}

	public String getDocumento_id() {
		return documento_id;
	}

	public void setDocumento_id(String documento_id) {
		this.documento_id = documento_id;
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

	public String getFecha_seguimiento() {
		return fecha_seguimiento;
	}

	public void setFecha_seguimiento(String fecha_seguimiento) {
		this.fecha_seguimiento = fecha_seguimiento;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

}
