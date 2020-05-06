package test;

import dao.impl.classselectionDaoimpl;
import entity.ClassSelection;

public class insertclassselection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassSelection cs = new ClassSelection();
		cs.setClass_id("0001");
		cs.setClass_name("数值分析");
		cs.setStudent_id("201801121");
		cs.setStudent_name("彭聪");
		cs.setTeacher_id("0012");
		cs.setTeacher_name("刘伟峰");
		classselectionDaoimpl c = new classselectionDaoimpl();
		if(c.insert(cs)==1) {
			System.out.println("1");
		}
		else {
			System.out.println("0");
		}
	}

}
