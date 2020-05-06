package test;

import dao.impl.classgradeDaoimpl;
import entity.ClassGrade;
import entity.Student;

public class searchbystudentid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student t =new Student();
		t.setId("2017011315");
		t.setDepartment("石油学院");
		t.setGender(1);
		t.setName("赵忠厚");
		t.setTel("110");
		t.setAge(20);
		t.setSpecialty("物探");
		t.setClassinfo("物探17-1");
		classgradeDaoimpl cdl = new classgradeDaoimpl();
		ClassGrade[] C = cdl.searchbystudentid(t);
		for(int i = 0 ; i< C.length ; i++)
			System.out.println(C[i].getGrade());
	}

}
