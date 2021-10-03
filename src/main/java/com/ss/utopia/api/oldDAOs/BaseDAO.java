package com.ss.utopia.api.oldDAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ss.utopia.api.service.ConnectionUtil;

@Component
public abstract class BaseDAO<T> {


	@Autowired
	ConnectionUtil conn;
	

	protected void save(String statement, Object[] params) throws SQLException, ClassNotFoundException {
		PreparedStatement pstmt = conn.getConnection().prepareStatement(statement);
		int c = 1;
		if (params != null) {
			for (Object o : params) {
				pstmt.setObject(c++, o);
			}
		}
		pstmt.execute();
	}
	
	protected Integer savePK(String statement, Object[] params) throws SQLException, ClassNotFoundException {
		PreparedStatement pstmt = conn.getConnection().prepareStatement(statement, Statement.RETURN_GENERATED_KEYS);
		if (params != null) {
			int c = 1;
			for (Object o : params) {
				pstmt.setObject(c++, o);
			}
		}
		pstmt.execute();

		ResultSet rs = pstmt.getGeneratedKeys();
		while(rs.next()) {
			return rs.getInt(1); //check if this is 0 or 1;

		}

		return null;
	}
	protected List<T> read(String statement, Object[] params) throws SQLException, ClassNotFoundException{
		PreparedStatement pstmt = conn.getConnection().prepareStatement(statement);
		int c = 1;
		if (params != null) {
			for (Object o : params) {
				pstmt.setObject(c++, o);
			}
		}
		ResultSet rs = pstmt.executeQuery();
		return extractData(rs);
		
	}
	


	 abstract protected List<T> extractData(ResultSet rs) throws SQLException, ClassNotFoundException;
	
}
