package test;

import dao.impl.teacherDaoimpl;
import entity.Teacher;

public class searchteacherinfo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Teacher t ;
		teacherDaoimpl t1 = new teacherDaoimpl();
		t = t1.searchbyteacherid("0011");
		if(t!=null) {
			System.out.println(t.getName());
		}
		else {
			System.out.println("查无此人");
		}
	}

}
