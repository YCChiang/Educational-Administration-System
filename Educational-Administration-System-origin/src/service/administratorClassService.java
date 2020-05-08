package service;

import java.util.List;

import entity.ClassInfo;

public interface administratorClassService {
	public List<ClassInfo> findClassInfoList();
	public int modify(ClassInfo classinfo);
}
