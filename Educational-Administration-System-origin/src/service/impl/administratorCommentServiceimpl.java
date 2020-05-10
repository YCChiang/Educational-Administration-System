package service.impl;

import java.util.List;

import dao.impl.CommentDaoimpl;
import entity.Comment;
import service.administratorCommentService;

public class administratorCommentServiceimpl implements administratorCommentService {
	CommentDaoimpl DAO = new CommentDaoimpl();
	@Override
	public List<Comment> findCommentList() {
		return DAO.searchall();
	}

	@Override
	public int modify(Comment C) {
		return 0;
	}

}
