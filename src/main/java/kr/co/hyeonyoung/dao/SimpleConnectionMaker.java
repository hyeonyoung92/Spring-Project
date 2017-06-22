package kr.co.hyeonyoung.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleConnectionMaker {
	public Connection makerNewConnection() throws ClassNotFoundException,
	SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/Spring?useUnicode=true&characterEncoding=UTF-8", "root", "12345678");
		
		return c;
	}
}
