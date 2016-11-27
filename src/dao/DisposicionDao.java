package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.DataAccess;

import entity.Disposicion;
import interfaces.Intermetodos;

public class DisposicionDao implements Intermetodos<Disposicion> {

	@Override
	public Disposicion Grabar(Disposicion o) throws Exception {
		// TODO Auto-generated method stub

		return null;

	}

	@Override
	public void Eliminar(Disposicion o) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void Modificar(Disposicion o) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Disposicion> Listar() throws Exception {
		Connection cn = null;
		List<Disposicion> lista = new ArrayList<Disposicion>();
		try {
			// conexion a la base de datos
			cn = DataAccess.getConnection();
			// comando sql
			String sql = "select disposicion_id,disposicion from disposicion "
					+ " where estado = 1  order by disposicion_id asc";
			// crear statement
			Statement stm = cn.createStatement();
			// ejecutar comando y obtener resultados
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Disposicion d = new Disposicion();
				// asignar valores al objeto d
				d.setDisposicion_id(rs.getInt("disposicion_id"));
				d.setDisposicion(rs.getString("disposicion"));

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
	public List<Disposicion> Filtrar(Disposicion o) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Disposicion Buscar(Disposicion o) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
