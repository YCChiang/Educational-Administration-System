package dao;

import java.sql.Time;
import java.util.List;

import entity.ClassSchedule;

public interface ClassScheduleDAO {
	public int inset(ClassSchedule classSchedule);
	public List<ClassSchedule> selectByClass_id(String class_id);
	public List<ClassSchedule> selectByClass_idsAndDayAndTime(List<String> class_ids,int day, Time time);
}
