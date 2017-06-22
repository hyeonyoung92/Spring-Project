package kr.co.hyeonyoung.dao;

public class DaoFactory {
	/* UserDao�� �ƴ� �ٸ� DAO�� ��������� ������?? */
	/* ConnetionMaker ����Ŭ���� ���� �� �������� �ߺ��� �߻��� */
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
