package test;

import dao.impl.classinfoDaoimpl;
import entity.ClassInfo;

public class getclassinfobyteacherid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		classinfoDaoimpl c = new classinfoDaoimpl();
		ClassInfo[] ci = c.selectbyteacherid("0011");
		int size = ci.length;
		for(int i = 0 ; i< size ; i++)
			System.out.println(ci[i].getName());
	}

}
