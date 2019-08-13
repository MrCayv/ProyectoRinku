package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DBConexion;
import model.Trabajador;

public class TrabajadorDAO {	
	public static boolean guardar(Trabajador trabajador) {
		DBConexion con = new DBConexion();
		PreparedStatement stmt;

		String sql = 
				  "INSERT INTO trabajadores(nombre, rol, tipo, usu_creador, creado, usu_modificador, modificado, status) "
				+ "VALUES (?, ?, ?, ?, NOW(), NULL, NOW(), 1)";
		try {
			stmt = con.getConnection().prepareStatement(sql);

			stmt.setString(1, trabajador.getNombre());
			stmt.setInt(2, trabajador.getRol());
			stmt.setInt(3, trabajador.getTipo());
			stmt.setInt(4, trabajador.getUsu_creador());

			stmt.executeUpdate();
		} catch (SQLException e) {
			return false;
		} finally {
			con.cerrar();
		}

		return true;
	}

	public static boolean editar(Trabajador trabajador) {
		DBConexion con = new DBConexion();
		PreparedStatement stmt;

		String sql = 
				    "UPDATE trabajadores SET "
				  + "    nombre = ?, "
				  + "    rol = ?, "
				  + "    tipo = ?, "
				  + "    usu_modificador = ?, "
				  + "    modificado = NOW() "
				  + "WHERE id = ?";
		try {
			stmt = con.getConnection().prepareStatement(sql);

			stmt.setString(1, trabajador.getNombre());
			stmt.setInt(2, trabajador.getRol());
			stmt.setInt(3, trabajador.getTipo());
			stmt.setInt(4, trabajador.getUsu_modificador());
			stmt.setInt(5, trabajador.getId());

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
			    "UPDATE trabajadores SET "
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

	public static Trabajador buscar(int id) {
		String sql = 
				  "SELECT * "
                + "FROM trabajadores "
                + "WHERE id = " + id;
		return registro(sql);
	}

	public static ArrayList<Trabajador> consultar() {
		String sql = 
				  "SELECT * "
                + "FROM trabajadores "
                + "WHERE status = 1";

		return consulta(sql);
	}

//==========================================================================================================================

	public static Trabajador registro(String sql) {
		Trabajador registro = null;
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

	public static ArrayList<Trabajador> consulta(String sql) {
        ArrayList<Trabajador> lista = new ArrayList<Trabajador>();
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

	public static Trabajador getRegistro(ResultSet rs) throws SQLException {
		Trabajador registro = new Trabajador();

        registro.setId(rs.getInt("id"));
        registro.setNombre(rs.getString("nombre"));
        registro.setRol(rs.getInt("rol"));
        registro.setTipo(rs.getInt("tipo"));
        registro.setUsu_creador(rs.getInt("usu_creador"));
        registro.setCreado(rs.getTimestamp("creado"));
        registro.setUsu_modificador(rs.getInt("usu_modificador"));
        registro.setModificado(rs.getTimestamp("modificado"));
        registro.setStatus(rs.getInt("status"));

        return registro;
    }
}