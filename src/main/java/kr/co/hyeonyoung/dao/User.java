package kr.co.hyeonyoung.dao;

public class User {
	public String id;
	public String name;
	public String password;
	
	public User(String id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}
	
	public User() {} // 명시적으로 생성자를 추가했을 때는 디폴트 생성자도 함께 정의해주어야 함.
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
