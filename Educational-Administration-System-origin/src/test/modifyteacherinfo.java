package test;

import dao.impl.teacherDaoimpl;
import entity.Teacher;

public class modifyteacherinfo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Teacher t =new Teacher();
		teacherDaoimpl t1 = new teacherDaoimpl();
		t.setId("0011");
		t.setDepartment("石油学院");
		t.setGender(1);
		t.setName("赵忠厚");
		t.setTel("110");
		t.setTitle("教授");
		if(t1.modify(t)==1) {
			System.out.println("修改成功");
		}
		else {
			System.out.println("error");
		}
	}

}
