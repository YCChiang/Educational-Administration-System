package test;

import dao.impl.commentDaoimpl;
import entity.Comment;

public class getcommentbyteacherid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		commentDaoimpl c = new commentDaoimpl();
		Comment[] ci = c.searchcommentbyteacherid("0011");
		int size = ci.length;
		for(int i = 0 ; i< size ; i++)
			System.out.println(ci[i].getContent());
	}

}
