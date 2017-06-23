package kr.co.hyeonyoung.dao;   

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;

import javax.naming.Context;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

public class UserDaoTest {
	private UserDao dao;
	private User user1;
	private User user2;
	private User user3;
	
	/*
		1. �׽�Ʈ Ŭ�������� @Test�� ���� public�̰� void���̸� �Ķ���Ͱ� ���� �׽�Ʈ �޼ҵ带 ��� ã�´�.
		2. �׽�Ʈ Ŭ������ ������Ʈ�� �ϳ� �����.
		3. @Before�� ���� �޼ҵ尡 ������ �����Ѵ�.
		4. @Test�� ���� �޼ҵ带 �ϳ� ȣ���ϰ� �׽�Ʈ ����� �����صд�.
		5. @After�� ���� �޼ҵ尡 ������ �����Ѵ�.
		6. ������ �׽�Ʈ �޼ҵ忡 ���� 2~5���� �ݺ��Ѵ�.
		7. ��� �׽�Ʈ�� ����� �����ؼ� �����ش�.
	*/
	@Before
	public void setUp() {
		ApplicationContext context = new GenericXmlApplicationContext("kr/co/hyeonyoung/dao/applicationContext.xml");
		this.dao = context.getBean("userDao", UserDao.class);
		
		this.user1 = new User("aaa", "aa", "1234");
		this.user2 = new User("bbb", "bb", "12345");
		this.user3 = new User("ccc", "cc", "123456");
	} 
	/*// id ���� �ش��ϴ� ����� ������ ���ٸ�?
	@Test(expected=EmptyResultDataAccessException.class)
	public void getUserFailure() throws SQLException, ClassNotFoundException {
		
		dao.deleteAll();
		assertThat(dao.getCount(), is(0));
		
		dao.get("unknown_id");
		
	}*/
	
	//=================���3====================================
	@Test
	public void addAndGet() throws SQLException, ClassNotFoundException {
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
		/*// ���3-2 -> ���3-3
		User user1 = new User("aaaa", "bbb", "1234");
		User user2 = new User("bbbb", "aaa", "1234");
		*/
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
