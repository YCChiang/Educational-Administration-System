package service.impl;

import java.util.List;

import dao.impl.commentDaoimpl;
import entity.Comment;
import service.administratorCommentService;

public class administratorCommentServiceimpl implements administratorCommentService {

	@Override
	public List<Comment> findCommentList() {
		commentDaoimpl DAO = new commentDaoimpl();
		return DAO.searchall();
	}

	@Override
	public int modify(Comment C) {
		// TODO Auto-generated method stub
		return 0;
	}

}
