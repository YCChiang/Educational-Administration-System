package service.impl;

import dao.impl.CommentDaoimpl;
import entity.Comment;
import service.StudentCommentService;

public class StudentCommentServiceimpl implements StudentCommentService{

	@Override
	public int add(Comment c) {
		// TODO Auto-generated method stub
		CommentDaoimpl DAO = new CommentDaoimpl();
		return DAO.insert(c);
	}
	
}
