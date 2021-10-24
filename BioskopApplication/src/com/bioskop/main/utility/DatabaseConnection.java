package com.bioskop.main.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
	//singleton java
	
	private static Connection con = null;
	
	private static String url = "jdbc:mysql://localhost:3306/bioskop?useSSL=false";
	private static String user = "root";
	private static String password ="";
	
	public static Connection getConnection() {
		
		if (con==null) {
			try {
				 con = DriverManager.getConnection(url, user, password);
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		return con;
	}

}
