package com.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertMain {

	public static void main(String[] args) throws Exception {
		String driverClassName ="oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String username = "mire001";
		String password = " admin";
		

		Class.forName(driverClassName);
		
		Connection conn= DriverManager.getConnection(url,username,password);
		
		String sql = "insert into 고객(고객아이디,고객이름,나이,등급,직업,적립금) "+
						"values('mama','mama',21,'gold,'학생',100)";
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		
		if(stmt != null)stmt.close();
		if(conn != null)conn.close();
	}

}
