package service.impl;

import dao.impl.commentDaoimpl;
import entity.Comment;
import service.TeacherCommentService;

public class TeacherCommentServiceimpl implements TeacherCommentService {

	@Override
	public Comment[] findCommentList(String teacher_id) {
		commentDaoimpl DAO = new commentDaoimpl();
		return DAO.searchcommentbyteacherid(teacher_id);
	}
	
}
