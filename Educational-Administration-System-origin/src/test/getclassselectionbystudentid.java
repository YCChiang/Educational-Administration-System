package test;

import java.util.List;

import dao.impl.ElectiveInfoDaoImpl;
import entity.ElectiveInfo;


public class getclassselectionbystudentid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ElectiveInfoDaoImpl c1 = new ElectiveInfoDaoImpl();
		List<ElectiveInfo> C = c1.selectByStudentid("201801121");
		for(ElectiveInfo info: C) {
			
		}
	}

}
