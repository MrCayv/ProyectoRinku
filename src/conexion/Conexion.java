package conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;
import javax.swing.JOptionPane;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class Conexion {
	private BasicDataSource dataSource = null;
	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	public Conexion() {
		conectar();
	}
	
	private void conectar() {
		if(dataSource == null) {
			dataSource = new BasicDataSource();
			dataSource.setDriverClassName("com.mysql.jc.jdbc.Driver");
			dataSource.setUsername("root");
			dataSource.setPassword("root1234");
			dataSource.setUrl("jdbc:mysql://localhost:3306/rinku");
			dataSource.setInitialSize(20);
			dataSource.setMaxIdle(15);
			dataSource.setMaxTotal(20);
			dataSource.setMaxWaitMillis(5000);
			
			try {
				con = dataSource.getConnection();
				stmt = con.createStatement();
			} catch (SQLException e) {
				System.out.println("Error en conexión a la base de datos");
			}
		}
	}
	
	public Connection getConnection(){
        return con;
    }
	
	public void closeConnection() {
        try {
            con.close();
            con = null;
            stmt = null;
        } catch (Exception e) {
        	System.out.println("Error al cerrar la conexion de la base de datos");
        }
    }
}
