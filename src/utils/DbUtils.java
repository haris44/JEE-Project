package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {

	public DbUtils(){
		
	}
	
	public Connection getConnection(){
		try {
			Class.forName("org.hsqldb.jdbcDriver");
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}

		try {
			return DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9003");
		}catch (SQLException e) {
			return null;
		}
	}
}
