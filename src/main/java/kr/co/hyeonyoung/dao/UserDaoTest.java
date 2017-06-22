package kr.co.hyeonyoung.dao;

import java.sql.SQLException;

public class UserDaoTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		UserDao dao = new DaoFactory().userDao();
		
		User user = new User();
		user.setId("puple");
		user.setName("hyerin");
		user.setPassword("2222");
		
		dao.add(user);
		
		System.out.println(user.getId() + "등록성공");
		
		User user2 = dao.get(user.getId());
		
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		System.out.println(user2.getId() + "조회성공");
		
		// 방식 1
		/*UserDao dao = new UserDao();
		User user = new User();
		user.setId("cherry");
		
		user.setName("hyeonyoung");
		user.setPassword("1111");
		
		dao.add(user);
		
		System.out.println(user.getId() + "등록성공");
		
		User user2 = dao.get(user.getId());
		
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		System.out.println(user2.getId() + "조회성공");*/
	}
}
