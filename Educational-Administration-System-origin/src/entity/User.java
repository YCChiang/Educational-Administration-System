package entity;

/*
 * 此类对应账号表
 */
public class User {
	private String name;
	private String password;
	private String type;
	
	
	public void setname(String name) {
		this.name = name;
	}
	public String getname() {
		return this.name;
	}
	
	public void setpassword(String password) {
		this.password = password;
	}
	
	public String getpassword() {
		return this.password;
	}
	
	public void settype(String type) {
		this.type = type;
	}
	
	public String gettype() {
		return this.type;
	}
}
