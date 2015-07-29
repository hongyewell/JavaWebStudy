package entity;

public class Users {

	
	//默认保留构造方法
	public Users()
	{
		
	}
	
	public Users(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public Users(Integer id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}

	private Integer id;
	private String username;
	private String password;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
