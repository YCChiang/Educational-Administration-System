package test;

import dao.impl.makeupDaoimpl;
import entity.Makeup;
import entity.Student;

public class insertmakeupandsearchbyid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s =new Student();
		s.setId("2017011316");
		Makeup M = new Makeup();
		M.setStudent_id("2017011316");
		M.setStudent_name("sss");
		M.setClass_id("0001");
		makeupDaoimpl mdi = new makeupDaoimpl();
		mdi.insert(M);
		Makeup [] ans = mdi.searchbystudentid(s);
		for(int i = 0 ; i< ans.length;i++) {
			System.out.print(ans[i].getClass_id());
		}
	}

}
