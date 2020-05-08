package test;
import dao.impl.*;
import entity.User;
public class logintest {
	public static void main(String args[]) {
		UserDaoimpl udi = new UserDaoimpl();
		System.out.print("start");
		User user = udi.searchByName("2017011294");
		if(user != null) {
			if(user.getpassword().equals("2017011294")) {
				System.out.print("login in ssuccess");
			}
			else {
				System.out.print("wrong password");
			}
		}
		else {
			System.out.print("wrong user name");
		}
	}
}
