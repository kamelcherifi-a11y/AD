package a1.Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private static String url ="jdbc:mariadb://localhost:3306/colegio";
	private static String user = "pepito";
	private static String pass = "123";
	
	public static Connection conectar() {
		try {
			Connection conexion = DriverManager.getConnection(url, user, pass);
			if(conexion==null)
				return null;
			return conexion;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
