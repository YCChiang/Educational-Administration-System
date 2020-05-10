package service.impl;

import dao.impl.CommentDaoimpl;
import entity.Comment;
import service.StudentCommentService;

public class StudentCommentServiceimpl implements StudentCommentService{
	CommentDaoimpl DAO = new CommentDaoimpl();
	@Override	
	public int add(Comment c) {
		if(c.getContent().length() <3)
			return 2;		//评教过短,请重新输入
		return DAO.insert(c);
	}
	
}
