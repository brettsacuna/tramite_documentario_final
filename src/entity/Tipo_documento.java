package entity;

public class Tipo_documento {

	private int tipo_documento_id;
	private String tipo_documento;
	private String tipo_documento_corto;
	private int estado;

	public Tipo_documento(int tipo_documento_id, String tipo_documento, String tipo_documento_corto, int estado) {
		super();
		this.tipo_documento_id = tipo_documento_id;
		this.tipo_documento = tipo_documento;
		this.tipo_documento_corto = tipo_documento_corto;
		this.estado = estado;
	}

	public Tipo_documento() {

	}

	public int getTipo_documento_id() {
		return tipo_documento_id;
	}

	public void setTipo_documento_id(int tipo_documento_id) {
		this.tipo_documento_id = tipo_documento_id;
	}

	public String getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(String tipo_documento) {
		this.tipo_documento = tipo_documento;
	}

	public String getTipo_documento_corto() {
		return tipo_documento_corto;
	}

	public void setTipo_documento_corto(String tipo_documento_corto) {
		this.tipo_documento_corto = tipo_documento_corto;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

}
