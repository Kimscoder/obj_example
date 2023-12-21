package com.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;

import com.jdbc.datasource.DataSource;
//extends DataSource 오류나는 이유 : 상속관계를 맺으면 
//생성자를 만들때 부모계체의 속성을 들고옴
//생성자를 생성안해도 컴파일러가 기본생성자를 넣어줌
public class MocDataSource extends DataSource{
	private static MocDataSource instance = new MocDataSource();
	
	
	//static 은 상속안댐
	public static DataSource getInstance() {
		return instance;
	}
	
	private String driverName = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private String username = "mire001";
	private String password = "admin";
	
	public Connection getConnection() throws Exception{
		Class.forName(driverName);
		Connection conn = DriverManager.getConnection(url,username,password);
		return conn;
	}
}
