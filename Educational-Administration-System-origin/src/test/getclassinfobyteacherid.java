package test;

import java.util.List;

import dao.impl.classinfoDaoimpl;
import entity.ClassInfo;

public class getclassinfobyteacherid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		classinfoDaoimpl c = new classinfoDaoimpl();
		List<ClassInfo> ci = c.selectByTeacherid("0011");
	}

}
