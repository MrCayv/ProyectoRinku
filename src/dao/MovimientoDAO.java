package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DBConexion;
import model.Movimiento;
import utilidades.Fechas;

public class MovimientoDAO {	
	public static boolean guardar(Movimiento movimiento) {
		DBConexion con = new DBConexion();
		PreparedStatement stmt;

		String sql = 
				  "INSERT INTO movimientos(id_empleado, fecha, cant_entregas, cubrio_turno, usu_creador, creado, usu_modificador, modificado, status) "
				+ "VALUES (?, ?, ?, ?, ?, NOW(), NULL, NOW(), 1)";
		try {
			stmt = con.getConnection().prepareStatement(sql);

			stmt.setInt(1, movimiento.getId_empleado());
			stmt.setDate(2, movimiento.getFecha());
			stmt.setInt(3, movimiento.getCant_entregas());
			stmt.setInt(4, movimiento.getCubrio_turno());
			stmt.setInt(5, movimiento.getUsu_creador());

			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		} finally {
			con.cerrar();
		}

		return true;
	}

	public static boolean editar(Movimiento movimiento) {
		DBConexion con = new DBConexion();
		PreparedStatement stmt;

		String sql = 
				    "UPDATE movimientos SET "
				  + "    id_empleado = ?, "
				  + "    fecha = ?, "
				  + "    cant_entregas = ?, "
				  + "    cubrio_turno = ?, "
				  + "    usu_modificador = ?, "
				  + "    modificado = NOW() "
				  + "WHERE id = ?";
		try {
			stmt = con.getConnection().prepareStatement(sql);

			stmt.setInt(1, movimiento.getId_empleado());
			stmt.setDate(2, movimiento.getFecha());
			stmt.setInt(3, movimiento.getCant_entregas());
			stmt.setInt(4, movimiento.getCubrio_turno());
			stmt.setInt(5, movimiento.getUsu_modificador());
			stmt.setInt(6, movimiento.getId());

			stmt.executeUpdate();
		} catch (SQLException e) {
			return false;
		} finally {
			con.cerrar();
		}

		return true;
	}

	public static boolean eliminar(int id, int usu_modificador) {
		DBConexion con = new DBConexion();
		PreparedStatement stmt;

		String sql = 
			    "UPDATE movimientos SET "
			  + "    status = 0, "
			  + "    usu_modificador = ?, "
			  + "    modificado = NOW() "
			  + "WHERE id = ?";
		try {
			stmt = con.getConnection().prepareStatement(sql);

			stmt.setInt(1, usu_modificador);
			stmt.setInt(2, id);

			stmt.executeUpdate();
		} catch (SQLException e) {
			return false;
		} finally {
			con.cerrar();
		}

		return true;
	}

	public static Movimiento buscar(int id) {
		String sql = 
				  "SELECT M.*, T.nombre AS trabajador "
                + "FROM movimientos AS M "
                + "    INNER JOIN trabajadores AS T "
                + "    ON M.id_empleado = T.id "
                + "WHERE M.id = " + id;
		return registro(sql);
	}

	public static ArrayList<Movimiento> consultar() {
		String sql = 
				  "SELECT M.*, T.nombre AS trabajador "
                + "FROM movimientos M " 
                + "    INNER JOIN trabajadores AS T " 
                + "    ON M.id_empleado = T.id "
                + "WHERE M.status = 1 "
                + "ORDER BY M.fecha DESC";

		return consulta(sql);
	}
	
	public static ArrayList<Movimiento> consultar(int mes, int year) {
		String sql = 
				  "SELECT M.*, T.nombre AS trabajador "
                + "FROM movimientos M " 
                + "    INNER JOIN trabajadores AS T " 
                + "    ON M.id_empleado = T.id "
                + "WHERE M.status = 1 "
                + "    AND M.fecha BETWEEN '" + Fechas.getPrimerDiaMes(mes, year) + "' AND '" + Fechas.getUltimoDiaMes(mes, year) + "' "
                + "ORDER BY M.fecha DESC";

		return consulta(sql);
	}
	
	public static ArrayList<Movimiento> consultar(int id_empleado, int mes, int year) {
		String sql = 
				  "SELECT M.*, T.nombre AS trabajador "
                + "FROM movimientos M " 
                + "    INNER JOIN trabajadores AS T " 
                + "    ON M.id_empleado = T.id "
                + "WHERE M.status = 1 "
                + "    AND id_empleado = " + id_empleado + " "
                + "    AND M.fecha BETWEEN '" + Fechas.getPrimerDiaMes(mes, year) + "' AND '" + Fechas.getUltimoDiaMes(mes, year) + "' "
                + "ORDER BY M.fecha DESC";
		
		return consulta(sql);
	}

//==========================================================================================================================

	public static Movimiento registro(String sql) {
		Movimiento registro = null;
		DBConexion con = new DBConexion();
        try {
        	PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) 
                registro = getRegistro(rs);
        } catch (Exception e) {
            return null;
        } finally {
            con.cerrar();
        }
        return registro;
    }

	public static ArrayList<Movimiento> consulta(String sql) {
        ArrayList<Movimiento> lista = new ArrayList<Movimiento>();
        DBConexion con = new DBConexion();
        try {
        	PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) 
                lista.add(getRegistro(rs));
        } catch (Exception e) {
            return null;
        } finally {
        	con.cerrar();
        }
        return lista;
    }

	public static Movimiento getRegistro(ResultSet rs) throws SQLException {
		Movimiento registro = new Movimiento();

        registro.setId(rs.getInt("id"));
        registro.setId_empleado(rs.getInt("id_empleado"));
        registro.setFecha(rs.getDate("fecha"));
        registro.setCant_entregas(rs.getInt("cant_entregas"));
        registro.setCubrio_turno(rs.getInt("cubrio_turno"));
        registro.setUsu_creador(rs.getInt("usu_creador"));
        registro.setCreado(rs.getTimestamp("creado"));
        registro.setUsu_modificador(rs.getInt("usu_modificador"));
        registro.setModificado(rs.getTimestamp("modificado"));
        registro.setStatus(rs.getInt("status"));
        registro.setTrabajador(rs.getString("trabajador"));

        return registro;
    }
}