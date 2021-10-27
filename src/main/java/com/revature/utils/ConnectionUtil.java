package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ConnectionUtil {

	private static Logger log = LoggerFactory.getLogger(ConnectionUtil.class);
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			log.error(e.getStackTrace().toString());
		}
		
		String url = "jdbc:postgresql://javafs-mydb.cxais73emmx9.us-east-2.rds.amazonaws.com:5432/javafs210927";
		String username = "postgres"; 
		String password = "password"; 
		
		return DriverManager.getConnection(url, username, password);
	}
}