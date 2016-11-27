package entity;

public class Usuario {

	private int usuario_id;
	private String usuario;
	private String contrasena;
	private int estado;

	public Usuario(int usuario_id, String usuario, String contrasena, int estado) {
		super();
		this.usuario_id = usuario_id;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.estado = estado;
	}

	public Usuario() {

	}

	public int getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

}
