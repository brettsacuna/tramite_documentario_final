package entity;

public class UsuarioRespuesta {

	private int estado;
	private Usuario usuario;

	public UsuarioRespuesta() {

	}

	public UsuarioRespuesta(int estado, Usuario usuario) {
		super();
		this.estado = estado;
		this.usuario = usuario;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
