package com.ss.utopia.api.service;

/**
 * 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

/**
 * @author Walter Chang
 *
 */
@Component
public class ConnectionUtil {

	public final String user = "root";
	public final String password = "4Bible1234"; // REMEMBER TO DELETE
	public final String driver = "com.mysql.cj.jdbc.Driver";
	public final String url = "jdbc:mysql://localhost/utopia";
	
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, password);
		conn.setAutoCommit(Boolean.FALSE);
		return conn;
	}

}

