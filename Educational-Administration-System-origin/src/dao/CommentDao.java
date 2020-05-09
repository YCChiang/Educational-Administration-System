package dao;

import java.util.List;

import entity.Comment;

public interface CommentDao {
	public List<Comment> searchByTeacherid(String teacher_id);
	public int insert(Comment c);
	public int update(Comment c);
	public List<Comment> searchall();
	public List<Comment> searchByStudnetid(String student_id);
	public List<Comment> searchByTeacheridAndClassId(String teacher_id, String class_id);
}
