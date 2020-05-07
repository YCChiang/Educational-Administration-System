package test;

import java.util.List;

import dao.impl.classselectionDaoimpl;
import entity.ClassSelection;


public class getclassselectionbystudentid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		classselectionDaoimpl c1 = new classselectionDaoimpl();
		List<ClassSelection> C = c1.selectByStudentid("201801121");
		int size =C.size();
		for(int i = 0 ; i< size ; i++) {

		}
	}

}
