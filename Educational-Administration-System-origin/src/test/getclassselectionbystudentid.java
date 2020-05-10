package test;

import java.util.List;

import dao.impl.ElectiveInfoDaoImpl;
import entity.ElectiveInfo;


public class getclassselectionbystudentid {

	public static void main(String[] args) {
		ElectiveInfoDaoImpl c1 = new ElectiveInfoDaoImpl();
		List<ElectiveInfo> C = c1.selectByStudentid("201801121");
		for(ElectiveInfo info: C) {
			
		}
	}

}
