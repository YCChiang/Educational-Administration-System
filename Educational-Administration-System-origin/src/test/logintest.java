package test;
import dao.impl.*;
import entity.user;
public class logintest {
	public static void main(String args[]) {
		userDaoimpl udi = new userDaoimpl();
		user u1 = udi.login("2017011316", "2017011316", "Ñ§Éú");
		System.out.println(u1.getname());
	}
}
