package entity;

public class RespuestaDoc {

	private int estado;
	private String documento_id;

	public RespuestaDoc() {

	}

	public RespuestaDoc(int estado, String documento_id) {
		super();
		this.estado = estado;
		this.documento_id = documento_id;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getDocumento_id() {
		return documento_id;
	}

	public void setDocumento_id(String documento_id) {
		this.documento_id = documento_id;
	}

}
