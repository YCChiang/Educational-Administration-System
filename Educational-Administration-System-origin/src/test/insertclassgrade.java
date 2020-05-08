package test;

import dao.impl.ClassInfoDaoimpl;
import entity.ClassInfo;

public class insertclassgrade {
	public static void main(String[] args) {
		ClassInfo C = new ClassInfo();
		C.setId("001");
		C.setName("数据结构");
		C.setHour(2);
		C.setCapacity(18);
		C.setCredit(2);
		C.setTeacher_id("0011");
		C.setTeacher_name("连远峰");
		ClassInfoDaoimpl c1 = new ClassInfoDaoimpl();
		if(c1.insert(C)==1) {
			
		}
		else {
			System.out.println("error");
		}
		
	}
}
