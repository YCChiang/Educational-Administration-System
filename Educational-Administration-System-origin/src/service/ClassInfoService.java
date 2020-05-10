package service;

import java.util.List;

import entity.ClassInfo;

public interface ClassInfoService {
	public List<ClassInfo> findByName(String name);
	public List<ClassInfo> findByNameAndYear(String name, String year);
	public ClassInfo findOne(String Id);
	public List<ClassInfo> findByIdAndYear(String Id, String year);
	public List<ClassInfo> findByTeacher_id(String teacher_id);
	public List<ClassInfo> findByTeacher_idAndYear(String teacher_id,String year);
	public List<ClassInfo> findByYear(String year);
	public int modify(ClassInfo classinfo);
	public int add(ClassInfo classinfo);
}
