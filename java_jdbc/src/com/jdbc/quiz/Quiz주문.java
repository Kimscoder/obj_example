package com.jdbc.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.dto.주문VO;

public class Quiz주문 {
	
	public void output3() throws Exception{
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String username = "mire001";
		String password = "admin";
		
		Class.forName(driverName);
		
		Connection conn= DriverManager.getConnection(url,username,password);
		
		String sql = "select * from 주문";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		List<주문VO>주문리스트 = new ArrayList<주문VO>();
		while(rs.next()) {
			주문VO 주문  = new 주문VO();
			
			주문.set주문번호(rs.getString("주문번호"));
			주문.set주문고객(rs.getString("주문고객"));
			주문.set주문제품(rs.getString("주문제품"));
			주문.set수량(rs.getInt("수량"));
			주문.set배송지(rs.getString("배송지"));
			주문.set주문일자(rs.getDate("주문일자"));
			주문리스트.add(주문);
			
			
		}
		if(!주문리스트.isEmpty())for(주문VO 주문 : 주문리스트) {
			System.out.println(주문.get주문번호()+"\t"
								+주문.get주문고객()+"\t"
								+주문.get주문제품()+"\t"
								+주문.get수량()+"\t"
								+주문.get배송지()+"\t"
								+주문.get주문일자());
			System.out.println(주문);
			}
		if(stmt!= null) stmt.close();
		if(conn!= null) conn.close();
	}
}
