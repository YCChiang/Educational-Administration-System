package dbconnect;
import java.sql.*;
public class connect {
	public static Connection getConnection() {
		String url = "jdbc:mariadb://127.0.0.1:3306/educationalas";
		String name = "manager";
		String ps = "manager";
		/*String name = "root";
		String ps = "3826";*/
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,name,ps);
			return con;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("数据库登录失败！");
			System.exit(0);
			return null;
		}	
	}
}
