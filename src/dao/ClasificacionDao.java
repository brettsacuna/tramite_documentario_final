package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.DataAccess;
import entity.Clasificacion;

import interfaces.Intermetodos;

public class ClasificacionDao implements Intermetodos<Clasificacion> {

	@Override
	public Clasificacion Grabar(Clasificacion o) throws Exception {
		// TODO Auto-generated method stub
		return null;

	}

	@Override
	public void Eliminar(Clasificacion o) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void Modificar(Clasificacion o) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Clasificacion> Listar() throws Exception {
		Connection cn = null;
		List<Clasificacion> lista = new ArrayList<Clasificacion>();
		try {
			// conexion a la base de datos
			cn = DataAccess.getConnection();
			// comando sql
			String sql = "select clasificacion_id,clasificacion from clasificacion "
					+ " where estado = 1  order by clasificacion_id asc";
			// crear statement
			Statement stm = cn.createStatement();
			// ejecutar comando y obtener resultados
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Clasificacion d = new Clasificacion();
				// asignar valores al objeto d
				d.setClasificacion_id(rs.getInt("clasificacion_id"));
				d.setClasificacion(rs.getString("clasificacion"));

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
	public List<Clasificacion> Filtrar(Clasificacion o) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Clasificacion Buscar(Clasificacion o) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
