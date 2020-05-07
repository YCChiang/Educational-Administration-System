package dao;

import java.util.List;

import entity.ClassInfo;

public interface classinfoDao{
	public int insert(ClassInfo grade);
	public ClassInfo selectByClass_id(String class_id);
	public List<ClassInfo> selectByTeacherid(String teacher_id);
	public List<ClassInfo> selectByClass_name(String class_name);
}
