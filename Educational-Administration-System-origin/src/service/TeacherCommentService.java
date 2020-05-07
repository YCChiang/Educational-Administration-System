package service;

import entity.Comment;

public interface TeacherCommentService {
	public Comment[] findCommentList(String teacher_id);
}
