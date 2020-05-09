package dao;

import java.util.List;

import entity.ClassInfo;

public interface ClassInfoDao{
	public int insert(ClassInfo grade);
	public ClassInfo selectByClass_id(String class_id);
	public List<ClassInfo> selectByTeacherid(String teacher_id);
	public List<ClassInfo> selectByClass_name(String class_name);
	public int update(ClassInfo classinfo);
	public List<ClassInfo> selectAll();
	public List<ClassInfo> selectByYear(String year);
}
