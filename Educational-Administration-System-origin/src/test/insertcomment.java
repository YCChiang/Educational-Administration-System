package test;

import dao.impl.commentDaoimpl;
import entity.Comment;

public class insertcomment {

	public static void main(String[] args) {
		commentDaoimpl Cdi = new commentDaoimpl();
		Comment C = new Comment();
		C.setClass_id("001");
		C.setClass_name("化工导论");
		C.setContent("老师很严格");
		C.setTeacher_id("0022");
		C.setTeacher_name("蓝老师");
		if(Cdi.insert(C)==1) {
			System.out.println("插入成功");
		}
		else {
			System.out.println("插入失败");
		}

	}

}
