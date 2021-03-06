package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DBConexion;
import model.Usuario;

public class UsuarioDAO {	
	public static boolean guardar(Usuario usuario) {
		DBConexion con = new DBConexion();
		PreparedStatement stmt;

		String sql = 
				  "INSERT INTO usuarios(usuario, password, nombre, usu_creador, creado, usu_modificador, modificado, status) "
				+ "VALUES (?, ?, ?, ?, NOW(), NULL, NOW(), 1)";
		try {
			stmt = con.getConnection().prepareStatement(sql);

			stmt.setString(1, usuario.getUsuario());
			stmt.setString(2, usuario.getPassword());
			stmt.setString(3, usuario.getNombre());
			stmt.setInt(4, usuario.getUsu_creador());

			stmt.executeUpdate();
		} catch (SQLException e) {
			return false;
		} finally {
			con.cerrar();
		}

		return true;
	}

	public static boolean editar(Usuario usuario) {
		DBConexion con = new DBConexion();
		PreparedStatement stmt;

		String sql = 
				    "UPDATE usuarios SET "
				  + "    usuario = ?, "
				  + "    nombre = ?, "
				  + "    usu_modificador = ?, "
				  + "    modificado = NOW() "
				  + "WHERE id = ?";
		try {
			stmt = con.getConnection().prepareStatement(sql);

			stmt.setString(1, usuario.getUsuario());
			stmt.setString(2, usuario.getNombre());
			stmt.setInt(3, usuario.getUsu_modificador());
			stmt.setInt(4, usuario.getId());

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
			    "UPDATE usuarios SET "
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

	public static Usuario buscar(int id) {
		String sql = 
				  "SELECT * "
                + "FROM usuarios "
                + "WHERE id = " + id;
		return registro(sql);
	}

	public static ArrayList<Usuario> consultar() {
		String sql = 
				  "SELECT * "
                + "FROM usuarios "
                + "WHERE status = 1";

		return consulta(sql);
	}

//==========================================================================================================================

	public static Usuario registro(String sql) {
		Usuario registro = null;
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

	public static ArrayList<Usuario> consulta(String sql) {
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
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

	public static Usuario getRegistro(ResultSet rs) throws SQLException {
		Usuario registro = new Usuario();

        registro.setId(rs.getInt("id"));
        registro.setUsuario(rs.getString("usuario"));
        registro.setNombre(rs.getString("nombre"));
        registro.setUsu_creador(rs.getInt("usu_creador"));
        registro.setCreado(rs.getTimestamp("creado"));
        registro.setUsu_modificador(rs.getInt("usu_modificador"));
        registro.setModificado(rs.getTimestamp("modificado"));
        registro.setStatus(rs.getInt("status"));

        return registro;
    }
}