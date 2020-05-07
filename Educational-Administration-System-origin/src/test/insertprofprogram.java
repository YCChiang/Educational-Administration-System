package test;

import dao.impl.profprogramDaoimpl;
import entity.ProfProgram;

public class insertprofprogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		profprogramDaoimpl p = new profprogramDaoimpl();
		ProfProgram PP = new ProfProgram();
		PP.setClass_id("1");
		PP.setClass_name("数据结构");
		PP.setCredit(1);
		PP.setId(1);
		PP.setSpecialty("计算机科学与技术培养方案");
		if(p.insert(PP)==1) {
			System.out.println("插入成功");
		}
		else
			System.out.println("插入失败");
	}

}
