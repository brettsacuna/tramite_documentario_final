package entity;

public class Seguimiento_documento {

	private String documento_id;
	private int situacion_id;
	private String fecha_seguimiento;
	private int estado;

	public Seguimiento_documento(String documento_id, int situacion_id, String fecha_seguimiento, int estado) {
		super();
		this.documento_id = documento_id;
		this.situacion_id = situacion_id;
		this.fecha_seguimiento = fecha_seguimiento;
		this.estado = estado;
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
