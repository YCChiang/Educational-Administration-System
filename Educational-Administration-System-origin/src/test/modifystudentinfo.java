package test;

import dao.impl.StudentDaoimpl;
import entity.Student;

public class modifystudentinfo {

	public static void main(String[] args) {
		Student t =new Student();
		StudentDaoimpl t1 = new StudentDaoimpl();
		t.setId("1");
		t.setDepartment("石油学院");
		t.setGender(1);
		t.setName("赵忠厚");
		t.setTel("110");
		t.setAge(20);
		t.setSpecialty("物探");
		t.setClassinfo("物探17-1");
		if(t1.modify(t)==1) {
			System.out.println("修改成功");
		}
		else {
			System.out.println("error");
		}
	}

}
