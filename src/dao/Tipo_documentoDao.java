package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.DataAccess;
import entity.Tipo_documento;
import interfaces.Intermetodos;

public class Tipo_documentoDao implements Intermetodos<Tipo_documento> {

	@Override
	public Tipo_documento Grabar(Tipo_documento o) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Eliminar(Tipo_documento o) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void Modificar(Tipo_documento o) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Tipo_documento> Listar() throws Exception {
		Connection cn = null;
		List<Tipo_documento> lista = new ArrayList<Tipo_documento>();
		try {
			// conexion a la base de datos
			cn = DataAccess.getConnection();
			// comando sql
			String sql = "select tipo_documento_id, tipo_documento, tipo_documento_corto from tipo_documento "
					+ " where estado = 1  order by tipo_documento_id asc";
			// crear statement
			Statement stm = cn.createStatement();
			// ejecutar comando y obtener resultados
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Tipo_documento d = new Tipo_documento();
				// asignar valores al objeto d
				d.setTipo_documento_id(rs.getInt("tipo_documento_id"));
				d.setTipo_documento(rs.getString("tipo_documento"));
				d.setTipo_documento_corto(rs.getString("tipo_documento_corto"));

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
	public List<Tipo_documento> Filtrar(Tipo_documento o) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tipo_documento Buscar(Tipo_documento o) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
