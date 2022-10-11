package com.thinking.machine;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/java_react?useSSL=false&allowPublicKeyRetrieval=true";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "root";
	
	private Connection con;
	public  Connection getMyConnection() throws SQLException, ClassNotFoundException {
		if(con==null || con.isClosed()) {
			Class.forName(DRIVER_CLASS);
			con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		}
		return con;
	}
	
}
