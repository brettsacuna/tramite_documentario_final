package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.DataAccess;
import entity.Unidad;
import interfaces.Intermetodos;

public class UnidadDao implements Intermetodos<Unidad> {

	@Override
	public Unidad Grabar(Unidad o) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Eliminar(Unidad o) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void Modificar(Unidad o) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Unidad> Listar() throws Exception {
		Connection cn = null;
		List<Unidad> lista = new ArrayList<Unidad>();
		try {
			// conexion a la base de datos
			cn = DataAccess.getConnection();
			// comando sql
			String sql = "select unidad_id, unidad_id_interno, unidad, unidad_gguu, unidad_nucleo from unidad "
					+ " where estado = 1  order by unidad_id asc ";
			// crear statement
			Statement stm = cn.createStatement();
			// ejecutar comando y obtener resultados
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Unidad d = new Unidad();
				// asignar valores al objeto d
				d.setUnidad_id(rs.getInt("unidad_id"));
				d.setUnidad_id_interno(rs.getString("unidad_id_interno"));
				d.setUnidad(rs.getString("unidad"));
				d.setUnidad_gguu(rs.getString("unidad_gguu"));
				d.setUnidad_nucleo(rs.getString("unidad_nucleo"));

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
	public List<Unidad> Filtrar(Unidad o) throws Exception {
		Connection cn = null;
		List<Unidad> lista = new ArrayList<Unidad>();
		try {
			// conexion a la base de datos
			cn = DataAccess.getConnection();
			// comando sql
			String sql = "select unidad_id, unidad_id_interno, unidad, unidad_gguu, unidad_nucleo from unidad "
					+ " where unidad like ? and estado = 1 limit 8";
			// crear statement
			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setString(1, "%" + o.getUnidad() + "%");
			// ejecutar comando y obtener resultados
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				Unidad d = new Unidad();
				// asignar valores al objeto d
				d.setUnidad_id(rs.getInt("unidad_id"));
				d.setUnidad_id_interno(rs.getString("unidad_id_interno"));
				d.setUnidad(rs.getString("unidad"));
				d.setUnidad_gguu(rs.getString("unidad_gguu"));
				d.setUnidad_nucleo(rs.getString("unidad_nucleo"));

				lista.add(d);
			}
			// cerrar cursor
			rs.close();
			pstm.close();
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
	public Unidad Buscar(Unidad o) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
