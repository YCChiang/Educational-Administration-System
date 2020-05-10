package service;

import java.util.List;

import entity.ClassSchedule;

public interface ClassScheduleSerivce {
	public int add(ClassSchedule schedule);
	public List<ClassSchedule> findByClassId(String class_id);
}
