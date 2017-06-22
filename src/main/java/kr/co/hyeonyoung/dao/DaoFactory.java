package kr.co.hyeonyoung.dao;

public class DaoFactory {
	/* UserDao가 아닌 다른 DAO의 생성기능을 넣으면?? */
	/* ConnetionMaker 구현클래스 선정 및 생성에서 중복이 발생함 */
	public UserDao userDao() {
		ConnectionMaker connectionMaker = new DConnectionMaker();
		UserDao userDao = new UserDao(connectionMaker);
		
		return userDao;
	}
	
	public AccountDao accountDao() {
		return new AccountDao(new DConnectionMaker());
	}
	
	public MessageDao messageDao() {
		return new MessageDao(new DConnectionMaker());
	}
	
}
