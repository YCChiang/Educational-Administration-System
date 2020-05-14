package test;

import dao.impl.TeacherDaoimpl;
import entity.Teacher;

public class searchteacherinfo {

	public static void main(String[] args) {
		Teacher t ;
		TeacherDaoimpl t1 = new TeacherDaoimpl();
		t = t1.searchByTeacherid("0187");
		if(t!=null) {
			System.out.println(t.getName());
		}
		else {
			System.out.println("查无此人");
		}
	}

}
