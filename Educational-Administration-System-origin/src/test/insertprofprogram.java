package test;

import dao.impl.ProfprogramDaoimpl;
import entity.ProfProgram;

public class insertprofprogram {

	public static void main(String[] args) {
		ProfprogramDaoimpl p = new ProfprogramDaoimpl();
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
