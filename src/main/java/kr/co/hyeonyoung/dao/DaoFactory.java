package kr.co.hyeonyoung.dao;

public class DaoFactory {
	/* UserDao�� �ƴ� �ٸ� DAO�� ��������� ������?? */
	/* ConnetionMaker ����Ŭ���� ���� �� �������� �ߺ��� �߻��� */
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
