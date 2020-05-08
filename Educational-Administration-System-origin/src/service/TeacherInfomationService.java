package service;

import entity.Teacher;

public interface TeacherInfomationService {
	public Teacher findById(String id);
	public int modify(Teacher t);
}
