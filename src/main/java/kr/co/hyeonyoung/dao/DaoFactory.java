package kr.co.hyeonyoung.dao;

public class DaoFactory {
	/* UserDao가 아닌 다른 DAO의 생성기능을 넣으면?? */
	/* ConnetionMaker 구현클래스 선정 및 생성에서 중복이 발생함 */
	public UserDao userDao() {
		return new UserDao(connectionMaker());
	}
	
	public AccountDao accountDao() {
		return new AccountDao(connectionMaker());
	}
	
	public MessageDao messageDao() {
		return new MessageDao(connectionMaker());
	}
	
	public ConnectionMaker connectionMaker() {
		return new DConnectionMaker();
	}
}
