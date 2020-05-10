package dao;

import java.util.List;

import entity.ClassInfo;

public interface ClassInfoDao{
	public int insert(ClassInfo grade);
	public ClassInfo selectOne(String class_id);
	public List<ClassInfo> selectByIdAndYear(String id, String year);
	public List<ClassInfo> selectByTeacherid(String teacher_id);
	public List<ClassInfo> selectByTeacheridAndYear(String teacher_id, String year);
	public List<ClassInfo> selectByName(String class_name);
	public List<ClassInfo> selectByNameAndYear(String class_name, String year);
	public int update(ClassInfo classinfo);
	public List<ClassInfo> selectAll();
	public List<ClassInfo> selectByYear(String year);
}
