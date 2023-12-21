package com.jdbc.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.dto.제품VO;

public class Quiz제품 {
	public void output2() throws Exception{
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String username = "mire001";
		String password = "admin";
		
		Class.forName(driverName);
		
		Connection conn= DriverManager.getConnection(url,username,password);
		
		String sql = "select * from 제품";
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery(sql);
		
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
		if(stmt != null) stmt.close();
		if(conn != null) conn.close();
	}
}
