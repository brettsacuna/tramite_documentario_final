package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.DataAccess;
import entity.Situacion;
import interfaces.Intermetodos;

public class SituacionDao implements Intermetodos<Situacion> {

	@Override
	public Situacion Grabar(Situacion o) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Eliminar(Situacion o) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void Modificar(Situacion o) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Situacion> Listar() throws Exception {
		Connection cn = null;
		List<Situacion> lista = new ArrayList<Situacion>();
		try {
			// conexion a la base de datos
			cn = DataAccess.getConnection();
			// comando sql
			String sql = "select situacion_id, situacion from situacion "
					+ " where estado = 1  order by situacion_id asc";
			// crear statement
			Statement stm = cn.createStatement();
			// ejecutar comando y obtener resultados
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Situacion d = new Situacion();
				// asignar valores al objeto d
				d.setSituacion_id(rs.getInt("situacion_id"));
				d.setSituacion(rs.getString("situacion"));

				lista.add(d);
			}
			// cerrar cursor
			rs.close();
			stm.close();
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return lista;
	}

	@Override
	public List<Situacion> Filtrar(Situacion o) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Situacion Buscar(Situacion o) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
