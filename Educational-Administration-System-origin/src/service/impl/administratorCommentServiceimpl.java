package service.impl;

import java.util.List;

import dao.impl.CommentDaoimpl;
import entity.Comment;
import service.administratorCommentService;

public class administratorCommentServiceimpl implements administratorCommentService {

	@Override
	public List<Comment> findCommentList() {
		CommentDaoimpl DAO = new CommentDaoimpl();
		return DAO.searchall();
	}

	@Override
	public int modify(Comment C) {
		// TODO Auto-generated method stub
		return 0;
	}

}
