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
		1. 테스트 클래스에서 @Test가 붙은 public이고 void형이며 파라미터가 없는 테스트 메소드를 모두 찾는다.
		2. 테스트 클래스의 오브젝트를 하나 만든다.
		3. @Before가 붙은 메소드가 있으면 실행한다.
		4. @Test가 붙은 메소드를 하나 호출하고 테스트 결과를 저장해둔다.
		5. @After가 붙은 메소드가 있으면 실행한다.
		6. 나머지 테스트 메소드에 대해 2~5번을 반복한다.
		7. 모든 테스트의 결과를 종합해서 돌려준다.
	*/
	@Before
	public void setUp() {
		ApplicationContext context = new GenericXmlApplicationContext("kr/co/hyeonyoung/dao/applicationContext.xml");
		this.dao = context.getBean("userDao", UserDao.class);
		
		this.user1 = new User("aaa", "aa", "1234");
		this.user2 = new User("bbb", "bb", "12345");
		this.user3 = new User("ccc", "cc", "123456");
	} 
	/*// id 값에 해당하는 사용자 정보가 없다면?
	@Test(expected=EmptyResultDataAccessException.class)
	public void getUserFailure() throws SQLException, ClassNotFoundException {
		
		dao.deleteAll();
		assertThat(dao.getCount(), is(0));
		
		dao.get("unknown_id");
		
	}*/
	
	//=================방식3====================================
	@Test
	public void addAndGet() throws SQLException, ClassNotFoundException {
		// 방식3-1
		/*// 모든 테이블의 레코드 삭제
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
		/*// 방식3-2 -> 방식3-3
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
	//=================방식2====================================
	//public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		
		/*
		 1. 자바에서 손쉽게 실행 가능한  main()을 이용
		 2. 테스트할 대상인  UserDao의 오브젝트를 가져와 메소드를 호출
		 3. 테스트에 사용할 입력 값을 코드에서 만들어 넣어줌
		 4. 테스트의 결과를 콘솔에 출력
		 5. 각 단계의 작업이 에러 없이 끝나면 콘솔에 성공 메시지 출력
		*/
		/*ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);*/
		
		/*ApplicationContext context = new GenericXmlApplicationContext("kr/co/hyeonyoung/dao/applicationContext.xml");
		UserDao dao = context.getBean("userDao", UserDao.class);
		
		User user = new User();
		user.setId("watermelon");
		user.setName("zzz");
		user.setPassword("1111");
		
		dao.add(user);
		
		System.out.println(user.getId() + "등록성공");
		
		User user2 = dao.get(user.getId());
		
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		System.out.println(user2.getId() + "조회성공");*/
		
		//=============방식 1==================
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
	//}
}
