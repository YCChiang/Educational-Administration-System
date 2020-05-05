package test;
import dao.impl.*;
import entity.User;
public class logintest {
	public static void main(String args[]) {
		userDaoimpl udi = new userDaoimpl();
		User u1 = udi.login("2017011316", "2017011316", "学生");
		System.out.println(u1.getname());
	}
}
