package com.jdbc.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class SelctMain {
		
	public static void main(String[] args) throws Exception {
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
		
		sql = "select * from 제품";
		rs = stmt.executeQuery(sql);
		List<제품VO>제품리스트 = new ArrayList<제품VO>();
		while(rs.next()) {
			제품VO 제품 = new 제품VO();
			
			제품.set단가(rs.getInt("단가"));
			제품.set재고량(rs.getInt("재고량"));
			제품.set제조업체(rs.getString("제조업체"));
			제품.set제품명(rs.getString("제품명"));
			제품.set제품번호(rs.getString("제품번호"));
			제품리스트.add(제품);
			
		}
		if(!제품리스트.isEmpty())for(제품VO 제품 : 제품리스트) {
			System.out.println(제품.get단가()+"\t"+
								제품.get재고량()+"\t"
								+제품.get제조업체()+"\t"
								+제품.get제품명()+"\t"
								+제품.get제품번호());
		}
		sql = "select * from 주문";
		rs = stmt.executeQuery(sql);
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
