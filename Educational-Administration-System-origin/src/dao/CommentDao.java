package dao;

import entity.Comment;

public interface CommentDao {
	public Comment[] searchcommentbyteacherid(String teacher_id);
	public int insert(Comment c);
}
