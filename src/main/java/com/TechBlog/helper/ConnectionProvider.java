package com.TechBlog.helper;
import java.sql.*;

public class ConnectionProvider {
	
	public static Connection con;
	public static Connection getConnection() {
		
		try {
			
			if(con == null) {
				//driver class load
				Class.forName("com.mysql.jdbc.Driver");
				
				//create a connection...
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techblog","root","birbal123");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
