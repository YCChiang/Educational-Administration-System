package service;

import java.util.List;

import entity.ElectiveInfo;
public interface ElectiveInfoService {
	public int add(ElectiveInfo cs);
	public List<String> findByStudent_id(String student_id);
	public List<String> findByClass_id(String class_id);
}
