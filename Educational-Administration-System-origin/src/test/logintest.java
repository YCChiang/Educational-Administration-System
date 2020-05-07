package test;
import dao.impl.*;
import entity.User;
public class logintest {
	public static void main(String args[]) {
		userDaoimpl udi = new userDaoimpl();
		System.out.print("start");
		User user = udi.searchByName("2017011294");
		if(user != null) {
			if(user.getpassword() == "666666") {
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
