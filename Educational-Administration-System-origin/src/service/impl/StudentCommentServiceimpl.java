package service.impl;

import dao.impl.commentDaoimpl;
import entity.Comment;
import service.StudentCommentService;

public class StudentCommentServiceimpl implements StudentCommentService{

	@Override
	public int add(Comment c) {
		// TODO Auto-generated method stub
		commentDaoimpl DAO = new commentDaoimpl();
		return DAO.insert(c);
	}
	
}
