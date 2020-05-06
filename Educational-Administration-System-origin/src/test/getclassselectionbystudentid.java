package test;

import dao.impl.classselectionDaoimpl;
import entity.ClassSelection;
import entity.Student;

public class getclassselectionbystudentid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		classselectionDaoimpl c1 = new classselectionDaoimpl();
		Student s = new Student();
		s.setId("201801121");
		ClassSelection[] C = c1.searchbystudentid(s);
		int size =C.length;
		for(int i = 0 ; i< size ; i++) {
			System.out.println(C[i].getClass_name());
		}
	}

}
