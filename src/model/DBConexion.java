package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConexion {
	private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement stmt = null;
    private Statement s = null;
    private String url;
	
	public DBConexion() {
		conectar();
	}
	
	public void conectar(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            url = "jdbc:mysql://localhost:3306/rinku?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
            con = DriverManager.getConnection(url, "root", "root1234");
            s = con.createStatement();
        } catch(Exception e) {
        	System.out.println("no se pudo conectar a la base de datos");
            System.out.println(e);
        }
        
    }
	
	public ResultSet executeQuery(String sql) throws Exception{
        stmt = con.prepareStatement(sql);
        rs = stmt.executeQuery();
        return rs;
    }
    
    public void executeUpdate(String sql) throws Exception{
        s.executeUpdate(sql);
    }
    
    public Connection getConnection(){
        return con;
    }
    
    public void cerrar() {
        try {
            con.close();
            con = null;
            rs = null;
            s = null;
            stmt = null;
        } catch (Exception e) {
        	System.out.println("No se pudo cerrar la conexion de la base de datos");
        }
    }
}
