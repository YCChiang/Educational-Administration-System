package service.impl;

import java.util.List;

import dao.impl.CommentDaoimpl;
import entity.Comment;
import service.TeacherCommentService;

public class TeacherCommentServiceimpl implements TeacherCommentService {

	@Override
	public List<Comment> findCommentList(String teacher_id) {
		CommentDaoimpl DAO = new CommentDaoimpl();
		return DAO.searchByTeacherid(teacher_id);
	}
	
}
