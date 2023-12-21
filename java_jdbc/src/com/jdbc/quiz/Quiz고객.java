package com.jdbc.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.dto.고객VO;
public class Quiz고객 {

	public void output1() throws Exception{
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String username = "mire001";
		String password = "admin";
		
		Class.forName(driverName);
		
		Connection conn= DriverManager.getConnection(url,username,password);
		
		String sql="select * from 고객";
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery(sql);
		
		List<고객VO>고객리스트 = new ArrayList<고객VO>();
		
		while(rs.next()) {
			고객VO 고객 = new 고객VO();
			고객.set고객아이디(rs.getString("고객아이디"));
			고객.set고객이름(rs.getString("고객이름"));
			고객.set나이(rs.getInt("나이"));
			고객.set등급(rs.getString("등급"));
			고객.set직업(rs.getString("직업"));
			고객.set적립금(rs.getInt("적립금"));
			고객리스트.add(고객);
		}
		if(stmt != null) stmt.close();
		if(conn != null) conn.close();
		
	}
}
