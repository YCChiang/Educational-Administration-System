package service;

import java.util.List;

import entity.ElectiveInfo;
public interface ElectiveInfoService {
	public int save(ElectiveInfo cs);
	public List<ElectiveInfo> findByStudent_id(String student_id);
	public List<ElectiveInfo> findByClass_id(String class_id);
}
