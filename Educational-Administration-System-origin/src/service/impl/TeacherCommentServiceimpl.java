package service.impl;

import java.util.List;

import dao.impl.commentDaoimpl;
import entity.Comment;
import service.TeacherCommentService;

public class TeacherCommentServiceimpl implements TeacherCommentService {

	@Override
	public List<Comment> findCommentList(String teacher_id) {
		commentDaoimpl DAO = new commentDaoimpl();
		return DAO.searchByTeacherid(teacher_id);
	}
	
}
