package kr.co.hyeonyoung.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import javax.sql.DataSource;

import org.springframework.core.env.SystemEnvironmentPropertySource;

public class UserDao {
	// 방식1
	/*private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/Spring?useUnicode=true&characterEncoding=UTF-8", "root", "12345678");
		
		return c;
	}*/
	
	// 방식2
	/*public abstract Connection getConnection() throws ClassNotFoundException, SQLException;
	
	public void add(User user) throws ClassNotFoundException, SQLException {
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement(
				"insert into users(id, name, password) values(?,?,?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		ps.executeUpdate();
		
		ps.close();
		
	}
	
	public User get(String id) throws ClassNotFoundException, SQLException {
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement(
				"select * from users where id=?");
		
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		
		User user = new User();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		
		rs.close();
		ps.close();
		return user;
	}
	*/
	
	/*// 방식3
	private ConnectionMaker connectionMaker;
	
	public UserDao(ConnectionMaker connectionMaker) {
		connectionMaker = new DConnectionMaker(); // 구체적인 클래스 	
		this.connectionMaker = connectionMaker;
	}*/
	
	//방식4
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
	public void add(User user) throws ClassNotFoundException, SQLException {
		Connection c = dataSource.getConnection();
		PreparedStatement ps = c.prepareStatement(
				"insert into users(id, name, password) values(?,?,?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		ps.executeUpdate();
			
		
		ps.close();	
	}
	
	public User get(String id) throws ClassNotFoundException, SQLException {
		Connection c = dataSource.getConnection();
		PreparedStatement ps = c.prepareStatement(
				"select * from users where id=?");
		
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		User user = null;
		if(rs.next()) {
			user = new User();
			user.setId(rs.getString("id"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
		}
				
		rs.close();
		ps.close();
		return user;
	}
	
	// 테이블의 모든 레코드 삭제
	public void deleteAll() throws SQLException {
		Connection c = dataSource.getConnection();
		
		PreparedStatement ps = c.prepareStatement("delete from users");
		
		ps.executeUpdate();
		
		ps.close();
		c.close();
	}
	
	// 테이블의 레코드 수 반환
	public int getCount() throws SQLException {
		Connection c = dataSource.getConnection();
		
		PreparedStatement ps = c.prepareStatement("select count(*) from users");
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		int count = rs.getInt(1);
		
		rs.close();
		ps.close();
		c.close();
		
		return count;
	}
	
	
	
}
