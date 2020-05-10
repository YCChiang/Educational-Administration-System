package service.impl;

import java.util.List;

import dao.impl.ClassScheduleDAOImpl;
import entity.ClassSchedule;
import service.ClassScheduleSerivce;

public class ClassScheduleServiceImpl implements ClassScheduleSerivce {
	ClassScheduleDAOImpl classscheduleDAO = new ClassScheduleDAOImpl();
	
	@Override
	public int add(ClassSchedule schedule) {
		return classscheduleDAO.inset(schedule);
	}

	@Override
	public List<ClassSchedule> findByClassId(String class_id) {
		return classscheduleDAO.selectByClass_id(class_id);
	}

}
