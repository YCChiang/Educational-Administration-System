package test;

import java.util.List;

import dao.impl.ClassInfoDaoimpl;
import entity.ClassInfo;

public class getclassinfobyteacherid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassInfoDaoimpl c = new ClassInfoDaoimpl();
		List<ClassInfo> ci = c.selectByTeacherid("1");
		for(ClassInfo info: ci) {
			System.out.print(info.getName());
		}
	}

}
