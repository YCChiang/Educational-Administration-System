package test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dao.impl.CommentDaoimpl;
import entity.Comment;

public class getcommentbyteacherid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CommentDaoimpl c = new CommentDaoimpl();
		List<Comment> ci = c.searchByTeacherid("0011");
		if(!ci.isEmpty()) {
			for(Comment comment:ci){
				System.out.print(comment.getContent());
			}
		}
		List<Integer> days = new ArrayList<Integer>();
		days.add(1);
		days.add(2);
		days.add(3);
		String str = days.stream().map(String::valueOf).collect(Collectors.joining(","));
		System.out.print(str);
	}

}
