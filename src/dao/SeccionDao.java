package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.DataAccess;
import entity.Seccion;
import interfaces.Intermetodos;

public class SeccionDao implements Intermetodos<Seccion> {

	@Override
	public Seccion Grabar(Seccion o) throws Exception {
		// TODO Auto-generated method stub
		return null;

	}

	@Override
	public void Eliminar(Seccion o) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void Modificar(Seccion o) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Seccion> Listar() throws Exception {
		Connection cn = null;
		List<Seccion> lista = new ArrayList<Seccion>();
		try {
			// conexion a la base de datos
			cn = DataAccess.getConnection();
			// comando sql
			String sql = "select seccion_id, seccion, seccion_larga, seccion_abreviada from seccion "
					+ " where estado = 1  order by seccion_id asc";
			// crear statement
			Statement stm = cn.createStatement();
			// ejecutar comando y obtener resultados
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Seccion d = new Seccion();
				// asignar valores al objeto d
				d.setSeccion_id(rs.getInt("seccion_id"));
				d.setSeccion(rs.getString("seccion"));
				d.setSeccion_larga(rs.getString("seccion_larga"));
				d.setSeccion_abreviada(rs.getString("seccion_abreviada"));

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
	public List<Seccion> Filtrar(Seccion o) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Seccion Buscar(Seccion o) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
