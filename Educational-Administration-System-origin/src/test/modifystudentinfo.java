package test;

import dao.impl.studentDaoimpl;
import dao.impl.teacherDaoimpl;
import entity.Student;
import entity.Teacher;

public class modifystudentinfo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student t =new Student();
		studentDaoimpl t1 = new studentDaoimpl();
		t.setId("1");
		t.setDepartment("石油学院");
		t.setGender(1);
		t.setName("赵忠厚");
		t.setTel("110");
		t.setAge(20);
		t.setSpecialty("物探");
		t.setClassinfo("物探17-1");
		if(t1.modifyinfo(t)==1) {
			System.out.println("修改成功");
		}
		else {
			System.out.println("error");
		}
	}

}
