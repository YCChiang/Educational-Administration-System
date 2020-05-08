package test;

import java.util.List;

import dao.impl.commentDaoimpl;
import entity.Comment;

public class getcommentbyteacherid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		commentDaoimpl c = new commentDaoimpl();
		List<Comment> ci = c.searchByTeacherid("0011");
	}

}
