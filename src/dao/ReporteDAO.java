package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DBConexion;
import model.Reporte;
import utilidades.Fechas;

public class ReporteDAO {	

	public static ArrayList<Reporte> reporte(int mes, int year) {
		String sql = 
				  "SELECT T.id AS id_empleado, T.nombre AS nombre, \r\n" + 
				  "		CASE T.rol \r\n" + 
				  "			WHEN 1 THEN 'Chofer'\r\n" + 
				  "			WHEN 2 THEN 'Cargador'\r\n" + 
				  "			WHEN 3 THEN 'Auxiliar'\r\n" + 
				  "			ELSE '' \r\n" + 
				  "		END AS rol, \r\n" + 
				  "		CASE T.tipo \r\n" + 
				  "			WHEN 1 THEN 'Interno'\r\n" + 
				  "			WHEN 2 THEN 'Externo'\r\n" + 
				  "			ELSE '' \r\n" + 
				  "		END AS tipo, \r\n" + 
				  "		count(T.id) AS dias, SUM(M.cant_entregas) AS entregas, SUM(M.cubrio_turno) AS horas_cubrir,\r\n" + 
				  "		count(T.id)*240 AS importe_dias, SUM(M.cant_entregas)*5 AS importe_entregas,\r\n" + 
				  "		CASE T.rol \r\n" + 
				  "			WHEN 1 THEN SUM(M.cubrio_turno)*10\r\n" + 
				  "			WHEN 2 THEN SUM(M.cubrio_turno)*5\r\n" + 
				  "			WHEN 3 THEN 0\r\n" + 
				  "			ELSE 0 \r\n" + 
				  "		END AS importe_bonos\r\n" + 
				  "FROM movimientos AS M\r\n" + 
				  "	INNER JOIN trabajadores AS T\r\n" + 
				  "	ON M.id_empleado = T.id\r\n" + 
				  "WHERE M.status = 1\r\n" + 
				  "	AND T.status = 1\r\n" +
				  "    AND M.fecha BETWEEN '" + Fechas.getPrimerDiaMes(mes, year) + "' AND '" + Fechas.getUltimoDiaMes(mes, year) + "' " +
				  "GROUP BY T.id, T.nombre";

		return consulta(sql);
	}
	
//==========================================================================================================================

	public static ArrayList<Reporte> consulta(String sql) {
        ArrayList<Reporte> lista = new ArrayList<Reporte>();
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

	public static Reporte getRegistro(ResultSet rs) throws SQLException {
		Reporte registro = new Reporte();

        registro.setId_empleado(rs.getInt("id_empleado"));
        registro.setNombre(rs.getString("nombre"));
        registro.setRol(rs.getString("rol"));
        registro.setTipo(rs.getString("tipo"));
        registro.setDias(rs.getInt("dias"));
        registro.setEntregas(rs.getInt("entregas"));
        registro.setHoras_cubrir(rs.getInt("horas_cubrir"));
        registro.setImporte_dias(rs.getInt("importe_dias"));
        registro.setImporte_entregas(rs.getInt("importe_entregas"));
        registro.setImporte_bonos(rs.getInt("importe_bonos"));

        return registro;
    }
}