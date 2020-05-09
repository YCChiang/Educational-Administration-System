package service;

import java.util.List;

import entity.ClassInfo;

public interface ClassInfoService {
	public List<ClassInfo> findByName(String name);
	public ClassInfo findById(String Id);
}
