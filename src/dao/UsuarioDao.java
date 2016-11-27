package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import database.DataAccess;
import entity.Usuario;
import entity.UsuarioRespuesta;
import interfaces.Intermetodos;

public class UsuarioDao implements Intermetodos<Usuario> {

	@Override
	public Usuario Grabar(Usuario o) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Eliminar(Usuario o) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void Modificar(Usuario o) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Usuario> Listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> Filtrar(Usuario o) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario Buscar(Usuario o) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public UsuarioRespuesta Login(Usuario o) throws Exception {

		Connection cn = null;
		// boolean sw;

		Usuario u = new Usuario();
		UsuarioRespuesta ur = new UsuarioRespuesta();

		try {
			cn = DataAccess.getConnection();
			String query = " select usuario_id, usuario, contrasena, estado from usuario where usuario = ? and "
					+ " contrasena = ? and estado = 1 ";
			PreparedStatement pstm = cn.prepareStatement(query);
			pstm.setString(1, o.getUsuario());
			pstm.setString(2, o.getContrasena());

			ResultSet rs = pstm.executeQuery();

			if (rs.next()) {

				u.setUsuario_id(rs.getInt("usuario_id"));
				u.setUsuario(rs.getString("usuario"));

				ur.setEstado(1);
				ur.setUsuario(u);

			} else {
				ur.setEstado(0);
				ur.setUsuario(null);

			}

			rs.close();
			pstm.close();

		} catch (Exception e) {
			throw e;
		} finally {
			try {
				cn.close();
			} catch (Exception exception) {
				// TODO: handle exception
			}
		}
		return ur;

	}

}
