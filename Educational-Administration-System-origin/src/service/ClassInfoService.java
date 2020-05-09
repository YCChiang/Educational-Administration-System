package service;

import java.util.List;

import entity.ClassInfo;

public interface ClassInfoService {
	public List<ClassInfo> findByName(String name);
	public ClassInfo findById(String Id);
	public List<ClassInfo> findByTeacher_id(String teacher_id);
	public List<ClassInfo> findByYear(String year);
	public int modify(ClassInfo classinfo);
}
