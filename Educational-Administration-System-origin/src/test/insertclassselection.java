package test;

import dao.impl.ElectiveInfoDaoImpl;
import entity.ElectiveInfo;

public class insertclassselection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ElectiveInfo cs = new ElectiveInfo();
		cs.setClass_id("0001");
		cs.setStudent_id("201801121");
		ElectiveInfoDaoImpl c = new ElectiveInfoDaoImpl();
		if(c.insert(cs)==1) {
			System.out.println("1");
		}
		else {
			System.out.println("0");
		}
	}

}
