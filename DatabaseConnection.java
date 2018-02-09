package com.sporty.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

	public final static String driver="com.mysql.jdbc.Driver";
	public final static String url="jdbc:mysql://localhost:3306/sports?autoReconnect=true";
	public final static String user="root";
	public final static String password="9999";
	public  static Connection con = null;
	public static String path = "src/com.sporty.dao/download.jpg";
	public static String path2 = "src/images/imagesnew.jpg";
	
	public static Connection getConnection() {
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		return con;
	}
}
