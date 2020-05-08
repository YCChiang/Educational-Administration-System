package dao;

import java.util.List;

import entity.Comment;

public interface CommentDao {
	public Comment[] searchcommentbyteacherid(String teacher_id);
	public int insert(Comment c);
	public int modify(Comment c);
	public List<Comment> searchall();
}
