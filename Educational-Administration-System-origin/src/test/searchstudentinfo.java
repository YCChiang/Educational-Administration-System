package test;

import dao.impl.studentDaoimpl;
import entity.Student;

public class searchstudentinfo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s ;
		studentDaoimpl t1 = new studentDaoimpl();
		s = t1.searchByStudentid("1");
		if(s!=null) {
			System.out.println(s.getName());
		}
		else {
			System.out.println("查无此人");
		}
	}

}
