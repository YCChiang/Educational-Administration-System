package service;

import java.util.List;

import entity.Comment;

public interface TeacherCommentService {
	public List<Comment> findCommentList(String teacher_id);
}
