package dao;

import java.util.List;

import entity.ClassSchedule;

public interface ClassScheduleDAO {
	public int inset(ClassSchedule classSchedule);
	public List<ClassSchedule> selectByClass_id(String class_id);
}