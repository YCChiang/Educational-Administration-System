package service;

import java.util.List;

import entity.Comment;

public interface administratorCommentService {
	public List<Comment>findCommentList();
	public int modify(Comment C);
}
