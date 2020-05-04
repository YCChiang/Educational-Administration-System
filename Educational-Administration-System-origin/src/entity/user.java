package entity;


public class user {
	private String name;
	private String password;
	private String type;
	
	/*public static boolean connect() {
		String url = "jdbc:mariadb://127.0.0.1:3306/eas";
		String name = "manager";
		String ps = "manager";
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,name,ps);
		}catch(Exception e) {
			e.printStackTrace();
			
		}	
		return true;
	}*/
	
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
