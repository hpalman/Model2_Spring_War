package com.model2.spring.jdbc.comm;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConn {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	String user_id = "scott";
	String user_pw = "tiger";
	String qry = "";
	
	private Connection conn = null; // DB에 connection된 객체를 저장
	public Connection getConn() { 
		try {
			/* Driver Loading */
			Class.forName(driver);
			
			conn = DriverManager.getConnection(dbUrl, user_id, user_pw);
			
		} catch (Exception e) {
			
		}
		return conn;
	}
}
