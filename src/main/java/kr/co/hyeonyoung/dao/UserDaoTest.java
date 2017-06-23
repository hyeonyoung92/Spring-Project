package kr.co.hyeonyoung.dao;   

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;

import javax.naming.Context;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserDaoTest {
	//=================���3====================================
	@Test
	public void addAndGet() throws SQLException, ClassNotFoundException {
		ApplicationContext context = new GenericXmlApplicationContext("kr/co/hyeonyoung/dao/applicationContext.xml");
		
		UserDao dao = context.getBean("userDao", UserDao.class);
		
		
		// ���3-1
		/*// ��� ���̺��� ���ڵ� ����
		dao.deleteAll();
		assertThat(dao.getCount(), is(0));
		
		
		User user = new User();
		user.setId("hy.lee");
		user.setName("hylee");
		user.setPassword("1234");
		
		dao.add(user);
		assertThat(dao.getCount(), is(1));
		
		User user2 = dao.get(user.getId());
		
		assertThat(user2.getName(), is(user.getName()));
		assertThat(user2.getPassword(), is(user.getPassword()));
		*/
		// ���3-2 -> ���3-3
		User user1 = new User("aaaa", "bbb", "1234");
		User user2 = new User("bbbb", "aaa", "1234");
		
		dao.deleteAll();
		assertThat(dao.getCount(), is(0));
		
		dao.add(user1);
		dao.add(user2);
		assertThat(dao.getCount(), is(2));
		
		User userget1 = dao.get(user1.getId());
		assertThat(userget1.getName(), is(user1.getName()));
		assertThat(userget1.getPassword(), is(user1.getPassword()));
		
		User userget2 = dao.get(user2.getId());
		assertThat(userget2.getName(), is(user2.getName()));
		assertThat(userget2.getPassword(), is(user2.getPassword()));
	}
	
	public static void main(String[] args) {
		JUnitCore.main("kr.co.hyeonyoung.dao.UserDaoTest");
	}
	//=================���2====================================
	//public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		
		/*
		 1. �ڹٿ��� �ս��� ���� ������  main()�� �̿�
		 2. �׽�Ʈ�� �����  UserDao�� ������Ʈ�� ������ �޼ҵ带 ȣ��
		 3. �׽�Ʈ�� ����� �Է� ���� �ڵ忡�� ����� �־���
		 4. �׽�Ʈ�� ����� �ֿܼ� ���
		 5. �� �ܰ��� �۾��� ���� ���� ������ �ֿܼ� ���� �޽��� ���
		*/
		/*ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);*/
		
		/*ApplicationContext context = new GenericXmlApplicationContext("kr/co/hyeonyoung/dao/applicationContext.xml");
		UserDao dao = context.getBean("userDao", UserDao.class);
		
		User user = new User();
		user.setId("watermelon");
		user.setName("zzz");
		user.setPassword("1111");
		
		dao.add(user);
		
		System.out.println(user.getId() + "��ϼ���");
		
		User user2 = dao.get(user.getId());
		
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		System.out.println(user2.getId() + "��ȸ����");*/
		
		//=============��� 1==================
		/*UserDao dao = new UserDao();
		User user = new User();
		user.setId("cherry");
		
		user.setName("hyeonyoung");
		user.setPassword("1111");
		
		dao.add(user);
		
		System.out.println(user.getId() + "��ϼ���");
		
		User user2 = dao.get(user.getId());
		
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		System.out.println(user2.getId() + "��ȸ����");*/
	//}
}
