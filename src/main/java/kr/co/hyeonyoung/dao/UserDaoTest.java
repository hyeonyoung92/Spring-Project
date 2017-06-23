package kr.co.hyeonyoung.dao;   

import java.sql.SQLException;

import javax.naming.Context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserDaoTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		/*
		 1. �ڹٿ��� �ս��� ���� ������  main()�� �̿�
		 2. �׽�Ʈ�� �����  UserDao�� ������Ʈ�� ������ �޼ҵ带 ȣ��
		 3. �׽�Ʈ�� ����� �Է� ���� �ڵ忡�� ����� �־���
		 4. �׽�Ʈ�� ����� �ֿܼ� ���
		 5. �� �ܰ��� �۾��� ���� ���� ������ �ֿܼ� ���� �޽��� ���
		*/
		/*ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);*/
		ApplicationContext context = new GenericXmlApplicationContext("kr/co/hyeonyoung/dao/applicationContext.xml");
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
		System.out.println(user2.getId() + "��ȸ����");
		
		// ��� 1
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
	}
}
