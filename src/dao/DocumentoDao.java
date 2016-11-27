package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.DataAccess;
import entity.Decreto_documento_seccion;
import entity.Decreto_documento_vista;
import entity.Documento;
import entity.Documento_disposicion;
import entity.Documento_disposicion_vista;
import entity.Seguimiento_documento;
import entity.Situacion_documento_vista;
import entity.VistaDocumento;
import entity.VistaDocumentoSimple;
import interfaces.Intermetodos;

public class DocumentoDao implements Intermetodos<Documento> {

	@Override
	public Documento Grabar(Documento o) throws Exception {
		Connection cn = null;
		try {
			cn = DataAccess.getConnection();
			cn.setAutoCommit(false);

			String query1 = " select valor from controlador where parametro = 'documento' ";
			Statement stm = cn.createStatement();
			ResultSet rst = stm.executeQuery(query1);

			rst.next();

			int i = rst.getInt("valor");

			rst.close();

			String query2 = "update controlador set valor = valor+1 where parametro = 'documento' ";
			Statement stm2 = cn.createStatement();
			stm2.executeUpdate(query2);

			String pref = "";

			if (i <= 9) {
				pref = "D00000000" + i;
			} else if (i >= 10 || i < 99) {
				pref = "D0000000" + i;
			} else if (i >= 100 || i < 999) {
				pref = "D000000" + i;
			} else if (i >= 1000 || i < 9999) {
				pref = "D00000" + i;
			} else if (i >= 10000 || i < 99999) {
				pref = "D0000" + i;
			} else if (i >= 100000 || i < 999999) {
				pref = "D000" + i;
			} else if (i >= 1000000 || i < 9999999) {
				pref = "D00" + i;
			} else if (i >= 10000000 || i < 99999999) {
				pref = "D0" + i;
			} else if (i >= 100000000 || i < 999999999) {
				pref = "D" + i;
			}

			o.setDocumento_id(pref);

			String sql = "insert into documento(documento_id,asunto,documento_fecha,"
					+ "tipo_documento_id,fecha_registro,documento_numero,unidad_id_origen,"
					+ "seccion_id_destino,clasificacion_id,url_archivo,observacion,anulado,estado,estado_documento)"
					+ " values (?,?,?,?,sysdate(),?,?,?,?,?,?,0,1,0) ";

			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setString(1, o.getDocumento_id());
			pstm.setString(2, o.getAsunto());
			pstm.setString(3, o.getDocumento_fecha());
			pstm.setInt(4, o.getTipo_documento_id());
			pstm.setString(5, o.getDocumento_numero());
			pstm.setInt(6, o.getUnidad_id_origen());
			pstm.setInt(7, o.getSeccion_id_destino());
			pstm.setInt(8, o.getClasificacion_id());
			pstm.setString(9, o.getUrl_archivo());
			pstm.setString(10, o.getObservacion());

			pstm.executeUpdate();

			pstm.close();

			cn.commit();

		} catch (Exception e) {
			try {
				cn.rollback();
			} catch (Exception exception) {

			}
			throw e;
		} finally {
			try {
			} catch (Exception e) {
				cn.close();
			}
		}

		return o;
	}

	@Override
	public void Eliminar(Documento o) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void Modificar(Documento o) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Documento> Listar() throws Exception {
		Connection cn = null;
		List<Documento> lista = new ArrayList<Documento>();
		try {
			// conexion a la base de datos
			cn = DataAccess.getConnection();
			// comando sql
			String sql = " select documento_id,asunto,documento_fecha,"
					+ " tipo_documento_id,fecha_registro,documento_numero,unidad_id_origen,"
					+ " seccion_id_destino,clasificacion_id,url_archivo,observacion,anulado,estado from documento "
					+ " where estado = 1 and anulado = 0 order by documento_id asc";

			// crear statement
			Statement stm = cn.createStatement();
			// ejecutar comando y obtener resultados
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Documento d = new Documento();
				// asignar valores al objeto d
				d.setDocumento_id(rs.getString("documento_id"));
				d.setAsunto(rs.getString("asunto"));
				d.setDocumento_fecha(rs.getString("documento_fecha"));
				d.setTipo_documento_id(rs.getInt("tipo_documento_id"));
				d.setFecha_registro(rs.getString("fecha_registro"));
				d.setDocumento_numero(rs.getString("documento_numero"));
				d.setUnidad_id_origen(rs.getInt("unidad_id_origen"));
				d.setSeccion_id_destino(rs.getInt("seccion_id_destino"));
				d.setClasificacion_id(rs.getInt("clasificacion_id"));
				d.setObservacion(rs.getString("observacion"));

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
	public List<Documento> Filtrar(Documento o) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Documento Buscar(Documento o) throws Exception {
		Connection cn = null;
		Documento d = new Documento();
		try {
			// conexion a la base de datos
			cn = DataAccess.getConnection();
			// comando sql
			String sql = " select documento_id,asunto,documento_fecha, "
					+ " tipo_documento_id,fecha_registro,documento_numero,unidad_id_origen, "
					+ " seccion_id_destino,clasificacion_id,url_archivo,observacion,anulado,estado from documento "
					+ " where documento_id = ? estado = 1 and anulado = 0 ";
			// crear statement
			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setString(1, o.getDocumento_id());
			// ejecutar comando y obtener resultados
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				// Documento d = new Documento();
				// asignar valores al objeto d
				d.setDocumento_id(rs.getString("documento_id"));
				d.setAsunto(rs.getString("Asunto"));
				d.setDocumento_fecha(rs.getString("documento_fecha"));
				d.setTipo_documento_id(rs.getInt("tipo_documento_id"));
				d.setFecha_registro(rs.getString("fecha_registro"));
				d.setDocumento_numero(rs.getString("documento_numero"));
				d.setUnidad_id_origen(rs.getInt("unidad_id_origen"));
				d.setSeccion_id_destino(rs.getInt("seccion_id_destino"));
				d.setObservacion(rs.getString("observacion"));

				// lista.add(d);
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
		return d;

	}

	public List<VistaDocumento> ListarDocumento(int pag, int limite, int opcion, String desde, String hasta,
			String numero_registro, int unidad_id_origen, int tipo_documento_id, int estado, int seccion_id_destino)
			throws Exception {
		Connection cn = null;
		List<VistaDocumento> lista = new ArrayList<VistaDocumento>();
		// List<VistaDocumentoSimple> listadocsimple = new
		// ArrayList<VistaDocumentoSimple>();
		PreparedStatement pstm;
		String sql = "";
		ResultSet rs;

		try {

			List<Decreto_documento_vista> listadecretos = new ArrayList<Decreto_documento_vista>();
			List<Documento_disposicion_vista> listadispocicion = new ArrayList<Documento_disposicion_vista>();
			List<Situacion_documento_vista> listaseguimiento = new ArrayList<Situacion_documento_vista>();

			// numero de registro
			if (opcion == 0) {

				// conexion a la base de datos
				cn = DataAccess.getConnection();
				// comando sql
				sql = " select d.documento_id,d.asunto,d.documento_fecha,td.tipo_documento,d.fecha_registro, "
						+ " d.documento_numero,u.unidad,s.seccion,d.url_archivo,c.clasificacion "
						+ " from documento as d,tipo_documento as td,unidad as u,seccion as s,clasificacion as c "
						+ "  where  d.tipo_documento_id = td.tipo_documento_id and d.unidad_id_origen = u.unidad_id and "
						+ " d.seccion_id_destino = s.seccion_id and d.clasificacion_id = c.clasificacion_id and "
						+ " d.documento_id = ? limit ? offset ? ";

				// crear statement
				pstm = cn.prepareStatement(sql);

				pstm.setString(1, numero_registro);
				pstm.setInt(2, limite);
				pstm.setInt(3, pag);

				rs = pstm.executeQuery();

				while (rs.next()) {

					VistaDocumento ds = new VistaDocumento();
					// asignar valores al objeto d
					ds.setDocumento_id(rs.getString("documento_id"));
					ds.setAsunto(rs.getString("asunto"));
					ds.setDocumento_fecha(rs.getString("documento_fecha"));
					ds.setTipo_documento(rs.getString("tipo_documento"));
					ds.setFecha_registro(rs.getString("fecha_registro"));
					ds.setDocumento_numero(rs.getString("documento_numero"));
					ds.setUnidad(rs.getString("unidad"));
					ds.setSeccion(rs.getString("seccion_id_destino"));
					ds.setUrl_archivo(rs.getString("clasificacion_id"));
					ds.setClasificacion(rs.getString("observacion"));

					String sql2 = " select d.decreto_documento_id, d.documento_id, d.seccion_id, "
							+ " s.seccion, d.fecha_decreto, d.estado from decreto_documento_seccion as d, "
							+ " seccion as s where d.seccion_id = s.seccion_id and d.documento_id = ? "
							+ " order by decreto_documento_id asc ";

					PreparedStatement pstm2 = cn.prepareStatement(sql);

					pstm2.setString(1, ds.getDocumento_id());

					ResultSet rs2 = pstm2.executeQuery();

					while (rs2.next()) {

						Decreto_documento_vista ddv = new Decreto_documento_vista();
						// asignar valores al objeto d
						ddv.setDecreto_documento_id(rs.getInt("decreto_documento_id"));
						ddv.setDocumento_id(rs.getString("documento_id"));
						ddv.setSeccion_id(rs.getInt("seccion_id"));
						ddv.setSeccion(rs.getString("seccion"));
						ddv.setFecha_decreto(rs.getString("fecha_decreto"));
						ddv.setEstado(rs.getInt("estado"));

						listadecretos.add(ddv);
					}
					rs2.close();
					pstm2.close();

					ds.setListadecreto(listadecretos);

					String sql3 = " select 	d.documento_disposicion_id, d.documento_id, "
							+ " d.disposicion_id, ds.disposicion, d.fecha_disposicion, d.estado "
							+ " from documento_disposicion as d, disposicion as ds "
							+ " where d.disposicion_id = ds.disposicion_id and d.documento_id = ? "
							+ " order by documento_disposicion_id asc ";

					PreparedStatement pstm3 = cn.prepareStatement(sql);

					pstm3.setString(1, ds.getDocumento_id());

					ResultSet rs3 = pstm3.executeQuery();

					while (rs3.next()) {

						Documento_disposicion_vista ddis = new Documento_disposicion_vista();
						// asignar valores al objeto d
						ddis.setDocumento_disposicion_id(rs.getInt("documento_disposicion_id"));
						ddis.setDocumento_id(rs.getString("documento_id"));
						ddis.setDisposicion_id(rs.getInt("disposicion_id"));
						ddis.setDisposicion(rs.getString("disposicion"));
						ddis.setFecha_disposicion(rs.getString("fecha_disposicion"));
						ddis.setEstado(rs.getInt("estado"));

						listadispocicion.add(ddis);
					}
					rs3.close();
					pstm3.close();

					ds.setListadisposicion(listadispocicion);

					String sql4 = " select 	d.seguimiento_documento_id,	d.documento_id, d.situacion_id, "
							+ " ds.situacion,d.fecha_seguimiento, d.estado from 	seguimiento_documento as d,"
							+ " situacion as ds where d.situacion_id = ds.situacion_id and  d.documento_id = ? "
							+ " order by situacion_documento_id asc ";

					PreparedStatement pstm4 = cn.prepareStatement(sql);

					pstm4.setString(1, ds.getDocumento_id());

					ResultSet rs4 = pstm3.executeQuery();

					while (rs4.next()) {

						Situacion_documento_vista sdv = new Situacion_documento_vista();
						// asignar valores al objeto d
						sdv.setSeguimiento_documento_id(rs.getInt("seguimiento_documento_id"));
						sdv.setDocumento_id(rs.getString("documento_id"));
						sdv.setSituacion_id(rs.getInt("situacion_id"));
						sdv.setSituacion(rs.getString("situacion"));
						sdv.setFecha_seguimiento(rs.getString("fecha_seguimiento"));
						sdv.setEstado(rs.getInt("estado"));

						listaseguimiento.add(sdv);
					}
					rs4.close();
					pstm4.close();

					ds.setListaseguimiento(listaseguimiento);

					lista.add(ds);

				}
				// cerrar cursor
				rs.close();
				pstm.close();

				// unidad de origen
			} else if (opcion == 1) {

				// conexion a la base de datos
				cn = DataAccess.getConnection();
				// comando sql
				sql = " select d.documento_id,d.asunto,d.documento_fecha,td.tipo_documento,d.fecha_registro, "
						+ " d.documento_numero,u.unidad,s.seccion,d.url_archivo,c.clasificacion "
						+ " from documento as d,tipo_documento as td,unidad as u,seccion as s,clasificacion as c "
						+ "  where  d.tipo_documento_id = td.tipo_documento_id and d.unidad_id_origen = u.unidad_id and "
						+ " d.seccion_id_destino = s.seccion_id and d.clasificacion_id = c.clasificacion_id and "
						+ " d.unidad_id_origen = ? limit ? offset ? ";

				// crear statement
				pstm = cn.prepareStatement(sql);

				pstm.setInt(1, unidad_id_origen);
				pstm.setInt(2, limite);
				pstm.setInt(3, pag);

				rs = pstm.executeQuery();

				while (rs.next()) {

					VistaDocumento ds = new VistaDocumento();
					// asignar valores al objeto d
					ds.setDocumento_id(rs.getString("documento_id"));
					ds.setAsunto(rs.getString("asunto"));
					ds.setDocumento_fecha(rs.getString("documento_fecha"));
					ds.setTipo_documento(rs.getString("tipo_documento"));
					ds.setFecha_registro(rs.getString("fecha_registro"));
					ds.setDocumento_numero(rs.getString("documento_numero"));
					ds.setUnidad(rs.getString("unidad"));
					ds.setSeccion(rs.getString("seccion_id_destino"));
					ds.setUrl_archivo(rs.getString("clasificacion_id"));
					ds.setClasificacion(rs.getString("observacion"));

					String sql2 = " select d.decreto_documento_id, d.documento_id, d.seccion_id, "
							+ " s.seccion, d.fecha_decreto, d.estado from decreto_documento_seccion as d, "
							+ " seccion as s where d.seccion_id = s.seccion_id and d.documento_id = ? "
							+ " order by decreto_documento_id asc ";

					PreparedStatement pstm2 = cn.prepareStatement(sql);

					pstm2.setString(1, ds.getDocumento_id());

					ResultSet rs2 = pstm2.executeQuery();

					while (rs2.next()) {

						Decreto_documento_vista ddv = new Decreto_documento_vista();
						// asignar valores al objeto d
						ddv.setDecreto_documento_id(rs.getInt("decreto_documento_id"));
						ddv.setDocumento_id(rs.getString("documento_id"));
						ddv.setSeccion_id(rs.getInt("seccion_id"));
						ddv.setSeccion(rs.getString("seccion"));
						ddv.setFecha_decreto(rs.getString("fecha_decreto"));
						ddv.setEstado(rs.getInt("estado"));

						listadecretos.add(ddv);
					}
					rs2.close();
					pstm2.close();

					ds.setListadecreto(listadecretos);

					String sql3 = " select 	d.documento_disposicion_id, d.documento_id, "
							+ " d.disposicion_id, ds.disposicion, d.fecha_disposicion, d.estado "
							+ " from documento_disposicion as d, disposicion as ds "
							+ " where d.disposicion_id = ds.disposicion_id and d.documento_id = ? "
							+ " order by documento_disposicion_id asc ";

					PreparedStatement pstm3 = cn.prepareStatement(sql);

					pstm3.setString(1, ds.getDocumento_id());

					ResultSet rs3 = pstm3.executeQuery();

					while (rs3.next()) {

						Documento_disposicion_vista ddis = new Documento_disposicion_vista();
						// asignar valores al objeto d
						ddis.setDocumento_disposicion_id(rs.getInt("documento_disposicion_id"));
						ddis.setDocumento_id(rs.getString("documento_id"));
						ddis.setDisposicion_id(rs.getInt("disposicion_id"));
						ddis.setDisposicion(rs.getString("disposicion"));
						ddis.setFecha_disposicion(rs.getString("fecha_disposicion"));
						ddis.setEstado(rs.getInt("estado"));

						listadispocicion.add(ddis);
					}
					rs3.close();
					pstm3.close();

					ds.setListadisposicion(listadispocicion);

					String sql4 = " select 	d.seguimiento_documento_id,	d.documento_id, d.situacion_id, "
							+ " ds.situacion,d.fecha_seguimiento, d.estado from 	seguimiento_documento as d,"
							+ " situacion as ds where d.situacion_id = ds.situacion_id and  d.documento_id = ? "
							+ " order by situacion_documento_id asc ";

					PreparedStatement pstm4 = cn.prepareStatement(sql);

					pstm4.setString(1, ds.getDocumento_id());

					ResultSet rs4 = pstm3.executeQuery();

					while (rs4.next()) {

						Situacion_documento_vista sdv = new Situacion_documento_vista();
						// asignar valores al objeto d
						sdv.setSeguimiento_documento_id(rs.getInt("seguimiento_documento_id"));
						sdv.setDocumento_id(rs.getString("documento_id"));
						sdv.setSituacion_id(rs.getInt("situacion_id"));
						sdv.setSituacion(rs.getString("situacion"));
						sdv.setFecha_seguimiento(rs.getString("fecha_seguimiento"));
						sdv.setEstado(rs.getInt("estado"));

						listaseguimiento.add(sdv);
					}
					rs4.close();
					pstm4.close();

					ds.setListaseguimiento(listaseguimiento);

					lista.add(ds);

				}
				// cerrar cursor
				rs.close();
				pstm.close();

				// tipo_documento
			} else if (opcion == 2) {

				// conexion a la base de datos
				cn = DataAccess.getConnection();
				// comando sql
				sql = "select d.documento_id,d.asunto,d.documento_fecha,td.tipo_documento,d.fecha_registro, "
						+ " d.documento_numero,u.unidad,s.seccion,d.url_archivo,c.clasificacion "
						+ " from documento as d,tipo_documento as td,unidad as u,seccion as s,clasificacion as c "
						+ "  where  d.tipo_documento_id = td.tipo_documento_id and d.unidad_id_origen = u.unidad_id and "
						+ " d.seccion_id_destino = s.seccion_id and d.clasificacion_id = c.clasificacion_id and "
						+ " d.tipo_documento_id = ? limit ? offset ? ";

				// crear statement
				pstm = cn.prepareStatement(sql);

				pstm.setInt(1, tipo_documento_id);
				pstm.setInt(2, limite);
				pstm.setInt(3, pag);

				rs = pstm.executeQuery();

				while (rs.next()) {

					VistaDocumento ds = new VistaDocumento();
					// asignar valores al objeto d
					ds.setDocumento_id(rs.getString("documento_id"));
					ds.setAsunto(rs.getString("asunto"));
					ds.setDocumento_fecha(rs.getString("documento_fecha"));
					ds.setTipo_documento(rs.getString("tipo_documento"));
					ds.setFecha_registro(rs.getString("fecha_registro"));
					ds.setDocumento_numero(rs.getString("documento_numero"));
					ds.setUnidad(rs.getString("unidad"));
					ds.setSeccion(rs.getString("seccion_id_destino"));
					ds.setUrl_archivo(rs.getString("clasificacion_id"));
					ds.setClasificacion(rs.getString("observacion"));

					String sql2 = " select d.decreto_documento_id, d.documento_id, d.seccion_id, "
							+ " s.seccion, d.fecha_decreto, d.estado from decreto_documento_seccion as d, "
							+ " seccion as s where d.seccion_id = s.seccion_id and d.documento_id = ? "
							+ " order by decreto_documento_id asc ";

					PreparedStatement pstm2 = cn.prepareStatement(sql);

					pstm2.setString(1, ds.getDocumento_id());

					ResultSet rs2 = pstm2.executeQuery();

					while (rs2.next()) {

						Decreto_documento_vista ddv = new Decreto_documento_vista();
						// asignar valores al objeto d
						ddv.setDecreto_documento_id(rs.getInt("decreto_documento_id"));
						ddv.setDocumento_id(rs.getString("documento_id"));
						ddv.setSeccion_id(rs.getInt("seccion_id"));
						ddv.setSeccion(rs.getString("seccion"));
						ddv.setFecha_decreto(rs.getString("fecha_decreto"));
						ddv.setEstado(rs.getInt("estado"));

						listadecretos.add(ddv);
					}
					rs2.close();
					pstm2.close();

					ds.setListadecreto(listadecretos);

					String sql3 = " select 	d.documento_disposicion_id, d.documento_id, "
							+ " d.disposicion_id, ds.disposicion, d.fecha_disposicion, d.estado "
							+ " from documento_disposicion as d, disposicion as ds "
							+ " where d.disposicion_id = ds.disposicion_id and d.documento_id = ? "
							+ " order by documento_disposicion_id asc ";

					PreparedStatement pstm3 = cn.prepareStatement(sql);

					pstm3.setString(1, ds.getDocumento_id());

					ResultSet rs3 = pstm3.executeQuery();

					while (rs3.next()) {

						Documento_disposicion_vista ddis = new Documento_disposicion_vista();
						// asignar valores al objeto d
						ddis.setDocumento_disposicion_id(rs.getInt("documento_disposicion_id"));
						ddis.setDocumento_id(rs.getString("documento_id"));
						ddis.setDisposicion_id(rs.getInt("disposicion_id"));
						ddis.setDisposicion(rs.getString("disposicion"));
						ddis.setFecha_disposicion(rs.getString("fecha_disposicion"));
						ddis.setEstado(rs.getInt("estado"));

						listadispocicion.add(ddis);
					}
					rs3.close();
					pstm3.close();

					ds.setListadisposicion(listadispocicion);

					String sql4 = " select 	d.seguimiento_documento_id,	d.documento_id, d.situacion_id, "
							+ " ds.situacion,d.fecha_seguimiento, d.estado from 	seguimiento_documento as d,"
							+ " situacion as ds where d.situacion_id = ds.situacion_id and  d.documento_id = ? "
							+ " order by situacion_documento_id asc ";

					PreparedStatement pstm4 = cn.prepareStatement(sql);

					pstm4.setString(1, ds.getDocumento_id());

					ResultSet rs4 = pstm3.executeQuery();

					while (rs4.next()) {

						Situacion_documento_vista sdv = new Situacion_documento_vista();
						// asignar valores al objeto d
						sdv.setSeguimiento_documento_id(rs.getInt("seguimiento_documento_id"));
						sdv.setDocumento_id(rs.getString("documento_id"));
						sdv.setSituacion_id(rs.getInt("situacion_id"));
						sdv.setSituacion(rs.getString("situacion"));
						sdv.setFecha_seguimiento(rs.getString("fecha_seguimiento"));
						sdv.setEstado(rs.getInt("estado"));

						listaseguimiento.add(sdv);
					}
					rs4.close();
					pstm4.close();

					ds.setListaseguimiento(listaseguimiento);

					lista.add(ds);

				}
				// cerrar cursor
				rs.close();
				pstm.close();

				// fecha de documento
			} else if (opcion == 3) {

				// conexion a la base de datos
				cn = DataAccess.getConnection();
				// comando sql
				sql = " select d.documento_id,d.asunto,d.documento_fecha,td.tipo_documento,d.fecha_registro, "
						+ " d.documento_numero,u.unidad,s.seccion,d.url_archivo,c.clasificacion "
						+ " from documento as d,tipo_documento as td,unidad as u,seccion as s,clasificacion as c "
						+ "  where  d.tipo_documento_id = td.tipo_documento_id and d.unidad_id_origen = u.unidad_id and "
						+ " d.seccion_id_destino = s.seccion_id and d.clasificacion_id = c.clasificacion_id and "
						+ " d.fecha_documento between ? and ? limit ? offset ? ";

				// crear statement
				pstm = cn.prepareStatement(sql);

				pstm.setString(1, desde);
				pstm.setString(2, hasta);
				pstm.setInt(3, limite);
				pstm.setInt(4, pag);

				rs = pstm.executeQuery();

				while (rs.next()) {

					VistaDocumento ds = new VistaDocumento();
					// asignar valores al objeto d
					ds.setDocumento_id(rs.getString("documento_id"));
					ds.setAsunto(rs.getString("asunto"));
					ds.setDocumento_fecha(rs.getString("documento_fecha"));
					ds.setTipo_documento(rs.getString("tipo_documento"));
					ds.setFecha_registro(rs.getString("fecha_registro"));
					ds.setDocumento_numero(rs.getString("documento_numero"));
					ds.setUnidad(rs.getString("unidad"));
					ds.setSeccion(rs.getString("seccion_id_destino"));
					ds.setUrl_archivo(rs.getString("clasificacion_id"));
					ds.setClasificacion(rs.getString("observacion"));

					String sql2 = " select d.decreto_documento_id, d.documento_id, d.seccion_id, "
							+ " s.seccion, d.fecha_decreto, d.estado from decreto_documento_seccion as d, "
							+ " seccion as s where d.seccion_id = s.seccion_id and d.documento_id = ? "
							+ " order by decreto_documento_id asc ";

					PreparedStatement pstm2 = cn.prepareStatement(sql);

					pstm2.setString(1, ds.getDocumento_id());

					ResultSet rs2 = pstm2.executeQuery();

					while (rs2.next()) {

						Decreto_documento_vista ddv = new Decreto_documento_vista();
						// asignar valores al objeto d
						ddv.setDecreto_documento_id(rs.getInt("decreto_documento_id"));
						ddv.setDocumento_id(rs.getString("documento_id"));
						ddv.setSeccion_id(rs.getInt("seccion_id"));
						ddv.setSeccion(rs.getString("seccion"));
						ddv.setFecha_decreto(rs.getString("fecha_decreto"));
						ddv.setEstado(rs.getInt("estado"));

						listadecretos.add(ddv);
					}
					rs2.close();
					pstm2.close();

					ds.setListadecreto(listadecretos);

					String sql3 = " select 	d.documento_disposicion_id, d.documento_id, "
							+ " d.disposicion_id, ds.disposicion, d.fecha_disposicion, d.estado "
							+ " from documento_disposicion as d, disposicion as ds "
							+ " where d.disposicion_id = ds.disposicion_id and d.documento_id = ? "
							+ " order by documento_disposicion_id asc ";

					PreparedStatement pstm3 = cn.prepareStatement(sql);

					pstm3.setString(1, ds.getDocumento_id());

					ResultSet rs3 = pstm3.executeQuery();

					while (rs3.next()) {

						Documento_disposicion_vista ddis = new Documento_disposicion_vista();
						// asignar valores al objeto d
						ddis.setDocumento_disposicion_id(rs.getInt("documento_disposicion_id"));
						ddis.setDocumento_id(rs.getString("documento_id"));
						ddis.setDisposicion_id(rs.getInt("disposicion_id"));
						ddis.setDisposicion(rs.getString("disposicion"));
						ddis.setFecha_disposicion(rs.getString("fecha_disposicion"));
						ddis.setEstado(rs.getInt("estado"));

						listadispocicion.add(ddis);
					}
					rs3.close();
					pstm3.close();

					ds.setListadisposicion(listadispocicion);

					String sql4 = " select 	d.seguimiento_documento_id,	d.documento_id, d.situacion_id, "
							+ " ds.situacion,d.fecha_seguimiento, d.estado from 	seguimiento_documento as d,"
							+ " situacion as ds where d.situacion_id = ds.situacion_id and  d.documento_id = ? "
							+ " order by situacion_documento_id asc ";

					PreparedStatement pstm4 = cn.prepareStatement(sql);

					pstm4.setString(1, ds.getDocumento_id());

					ResultSet rs4 = pstm3.executeQuery();

					while (rs4.next()) {

						Situacion_documento_vista sdv = new Situacion_documento_vista();
						// asignar valores al objeto d
						sdv.setSeguimiento_documento_id(rs.getInt("seguimiento_documento_id"));
						sdv.setDocumento_id(rs.getString("documento_id"));
						sdv.setSituacion_id(rs.getInt("situacion_id"));
						sdv.setSituacion(rs.getString("situacion"));
						sdv.setFecha_seguimiento(rs.getString("fecha_seguimiento"));
						sdv.setEstado(rs.getInt("estado"));

						listaseguimiento.add(sdv);
					}
					rs4.close();
					pstm4.close();

					ds.setListaseguimiento(listaseguimiento);

					lista.add(ds);

				}
				// cerrar cursor
				rs.close();
				pstm.close();

				// por seccion
			} else if (opcion == 4) {

				if (estado == 0) {

					cn = DataAccess.getConnection();
					// comando sql
					sql = " select d.documento_id,d.asunto,d.documento_fecha,td.tipo_documento,d.fecha_registro, "
							+ " d.documento_numero,u.unidad,s.seccion,d.url_archivo,c.clasificacion "
							+ " from documento as d,tipo_documento as td,unidad as u,seccion as s,clasificacion as c "
							+ "  where  d.tipo_documento_id = td.tipo_documento_id and d.unidad_id_origen = u.unidad_id and "
							+ " d.seccion_id_destino = s.seccion_id and d.clasificacion_id = c.clasificacion_id and d.estado_documento = 0 "
							+ " d.seccion_id_destino = ? limit ? offset ? ";

					// crear statement
					pstm = cn.prepareStatement(sql);

					pstm.setInt(1, seccion_id_destino);
					pstm.setInt(2, limite);
					pstm.setInt(3, pag);

					rs = pstm.executeQuery();

					while (rs.next()) {

						VistaDocumento ds = new VistaDocumento();
						// asignar valores al objeto d
						ds.setDocumento_id(rs.getString("documento_id"));
						ds.setAsunto(rs.getString("asunto"));
						ds.setDocumento_fecha(rs.getString("documento_fecha"));
						ds.setTipo_documento(rs.getString("tipo_documento"));
						ds.setFecha_registro(rs.getString("fecha_registro"));
						ds.setDocumento_numero(rs.getString("documento_numero"));
						ds.setUnidad(rs.getString("unidad"));
						ds.setSeccion(rs.getString("seccion_id_destino"));
						ds.setUrl_archivo(rs.getString("clasificacion_id"));
						ds.setClasificacion(rs.getString("observacion"));

						String sql2 = " select d.decreto_documento_id, d.documento_id, d.seccion_id, "
								+ " s.seccion, d.fecha_decreto, d.estado from decreto_documento_seccion as d, "
								+ " seccion as s where d.seccion_id = s.seccion_id and d.documento_id = ? "
								+ " order by decreto_documento_id asc ";

						PreparedStatement pstm2 = cn.prepareStatement(sql);

						pstm2.setString(1, ds.getDocumento_id());

						ResultSet rs2 = pstm2.executeQuery();

						while (rs2.next()) {

							Decreto_documento_vista ddv = new Decreto_documento_vista();
							// asignar valores al objeto d
							ddv.setDecreto_documento_id(rs.getInt("decreto_documento_id"));
							ddv.setDocumento_id(rs.getString("documento_id"));
							ddv.setSeccion_id(rs.getInt("seccion_id"));
							ddv.setSeccion(rs.getString("seccion"));
							ddv.setFecha_decreto(rs.getString("fecha_decreto"));
							ddv.setEstado(rs.getInt("estado"));

							listadecretos.add(ddv);
						}
						rs2.close();
						pstm2.close();

						ds.setListadecreto(listadecretos);

						String sql3 = " select 	d.documento_disposicion_id, d.documento_id, "
								+ " d.disposicion_id, ds.disposicion, d.fecha_disposicion, d.estado "
								+ " from documento_disposicion as d, disposicion as ds "
								+ " where d.disposicion_id = ds.disposicion_id and d.documento_id = ? "
								+ " order by documento_disposicion_id asc ";

						PreparedStatement pstm3 = cn.prepareStatement(sql);

						pstm3.setString(1, ds.getDocumento_id());

						ResultSet rs3 = pstm3.executeQuery();

						while (rs3.next()) {

							Documento_disposicion_vista ddis = new Documento_disposicion_vista();
							// asignar valores al objeto d
							ddis.setDocumento_disposicion_id(rs.getInt("documento_disposicion_id"));
							ddis.setDocumento_id(rs.getString("documento_id"));
							ddis.setDisposicion_id(rs.getInt("disposicion_id"));
							ddis.setDisposicion(rs.getString("disposicion"));
							ddis.setFecha_disposicion(rs.getString("fecha_disposicion"));
							ddis.setEstado(rs.getInt("estado"));

							listadispocicion.add(ddis);
						}
						rs3.close();
						pstm3.close();

						ds.setListadisposicion(listadispocicion);

						String sql4 = " select 	d.seguimiento_documento_id,	d.documento_id, d.situacion_id, "
								+ " ds.situacion,d.fecha_seguimiento, d.estado from 	seguimiento_documento as d,"
								+ " situacion as ds where d.situacion_id = ds.situacion_id and  d.documento_id = ? "
								+ " order by situacion_documento_id asc ";

						PreparedStatement pstm4 = cn.prepareStatement(sql);

						pstm4.setString(1, ds.getDocumento_id());

						ResultSet rs4 = pstm3.executeQuery();

						while (rs4.next()) {

							Situacion_documento_vista sdv = new Situacion_documento_vista();
							// asignar valores al objeto d
							sdv.setSeguimiento_documento_id(rs.getInt("seguimiento_documento_id"));
							sdv.setDocumento_id(rs.getString("documento_id"));
							sdv.setSituacion_id(rs.getInt("situacion_id"));
							sdv.setSituacion(rs.getString("situacion"));
							sdv.setFecha_seguimiento(rs.getString("fecha_seguimiento"));
							sdv.setEstado(rs.getInt("estado"));

							listaseguimiento.add(sdv);
						}
						rs4.close();
						pstm4.close();

						ds.setListaseguimiento(listaseguimiento);

						lista.add(ds);

					}
					// cerrar cursor
					rs.close();
					pstm.close();

				} else if (estado == 1) {

					cn = DataAccess.getConnection();
					// comando sql
					sql = " select d.documento_id,d.asunto,d.documento_fecha,td.tipo_documento,d.fecha_registro, "
							+ " d.documento_numero,u.unidad,s.seccion,d.url_archivo,c.clasificacion "
							+ " from documento as d,tipo_documento as td,unidad as u,seccion as s,clasificacion as c "
							+ "  where  d.tipo_documento_id = td.tipo_documento_id and d.unidad_id_origen = u.unidad_id and "
							+ " d.seccion_id_destino = s.seccion_id and d.clasificacion_id = c.clasificacion_id and "
							+ " d.seccion_id_destino = ? limit ? offset ? ";

					// crear statement
					pstm = cn.prepareStatement(sql);

					pstm.setInt(1, seccion_id_destino);
					pstm.setInt(2, limite);
					pstm.setInt(3, pag);

					rs = pstm.executeQuery();

					while (rs.next()) {

						VistaDocumento ds = new VistaDocumento();
						// asignar valores al objeto d
						ds.setDocumento_id(rs.getString("documento_id"));
						ds.setAsunto(rs.getString("asunto"));
						ds.setDocumento_fecha(rs.getString("documento_fecha"));
						ds.setTipo_documento(rs.getString("tipo_documento"));
						ds.setFecha_registro(rs.getString("fecha_registro"));
						ds.setDocumento_numero(rs.getString("documento_numero"));
						ds.setUnidad(rs.getString("unidad"));
						ds.setSeccion(rs.getString("seccion_id_destino"));
						ds.setUrl_archivo(rs.getString("clasificacion_id"));
						ds.setClasificacion(rs.getString("observacion"));

						String sql2 = " select d.decreto_documento_id, d.documento_id, d.seccion_id, "
								+ " s.seccion, d.fecha_decreto, d.estado from decreto_documento_seccion as d, "
								+ " seccion as s where d.seccion_id = s.seccion_id and d.documento_id = ? "
								+ " order by decreto_documento_id asc ";

						PreparedStatement pstm2 = cn.prepareStatement(sql);

						pstm2.setString(1, ds.getDocumento_id());

						ResultSet rs2 = pstm2.executeQuery();

						while (rs2.next()) {

							Decreto_documento_vista ddv = new Decreto_documento_vista();
							// asignar valores al objeto d
							ddv.setDecreto_documento_id(rs.getInt("decreto_documento_id"));
							ddv.setDocumento_id(rs.getString("documento_id"));
							ddv.setSeccion_id(rs.getInt("seccion_id"));
							ddv.setSeccion(rs.getString("seccion"));
							ddv.setFecha_decreto(rs.getString("fecha_decreto"));
							ddv.setEstado(rs.getInt("estado"));

							listadecretos.add(ddv);
						}
						rs2.close();
						pstm2.close();

						ds.setListadecreto(listadecretos);

						String sql3 = " select 	d.documento_disposicion_id, d.documento_id, "
								+ " d.disposicion_id, ds.disposicion, d.fecha_disposicion, d.estado "
								+ " from documento_disposicion as d, disposicion as ds "
								+ " where d.disposicion_id = ds.disposicion_id and d.documento_id = ? "
								+ " order by documento_disposicion_id asc ";

						PreparedStatement pstm3 = cn.prepareStatement(sql);

						pstm3.setString(1, ds.getDocumento_id());

						ResultSet rs3 = pstm3.executeQuery();

						while (rs3.next()) {

							Documento_disposicion_vista ddis = new Documento_disposicion_vista();
							// asignar valores al objeto d
							ddis.setDocumento_disposicion_id(rs.getInt("documento_disposicion_id"));
							ddis.setDocumento_id(rs.getString("documento_id"));
							ddis.setDisposicion_id(rs.getInt("disposicion_id"));
							ddis.setDisposicion(rs.getString("disposicion"));
							ddis.setFecha_disposicion(rs.getString("fecha_disposicion"));
							ddis.setEstado(rs.getInt("estado"));

							listadispocicion.add(ddis);
						}
						rs3.close();
						pstm3.close();

						ds.setListadisposicion(listadispocicion);

						String sql4 = " select 	d.seguimiento_documento_id,	d.documento_id, d.situacion_id, "
								+ " ds.situacion,d.fecha_seguimiento, d.estado from 	seguimiento_documento as d,"
								+ " situacion as ds where d.situacion_id = ds.situacion_id and  d.documento_id = ? "
								+ " order by situacion_documento_id asc ";

						PreparedStatement pstm4 = cn.prepareStatement(sql);

						pstm4.setString(1, ds.getDocumento_id());

						ResultSet rs4 = pstm3.executeQuery();

						while (rs4.next()) {

							Situacion_documento_vista sdv = new Situacion_documento_vista();
							// asignar valores al objeto d
							sdv.setSeguimiento_documento_id(rs.getInt("seguimiento_documento_id"));
							sdv.setDocumento_id(rs.getString("documento_id"));
							sdv.setSituacion_id(rs.getInt("situacion_id"));
							sdv.setSituacion(rs.getString("situacion"));
							sdv.setFecha_seguimiento(rs.getString("fecha_seguimiento"));
							sdv.setEstado(rs.getInt("estado"));

							listaseguimiento.add(sdv);
						}
						rs4.close();
						pstm4.close();

						ds.setListaseguimiento(listaseguimiento);

						lista.add(ds);

					}
					// cerrar cursor
					rs.close();
					pstm.close();

				}

				// conexion a la base de datos

			}

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

}
