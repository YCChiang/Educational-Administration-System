package test;

import dao.impl.StudentDaoimpl;
import entity.Student;

public class searchstudentinfo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s ;
		StudentDaoimpl t1 = new StudentDaoimpl();
		s = t1.searchByStudentid("1");
		if(s!=null) {
			System.out.println(s.getName());
		}
		else {
			System.out.println("查无此人");
		}
	}

}
