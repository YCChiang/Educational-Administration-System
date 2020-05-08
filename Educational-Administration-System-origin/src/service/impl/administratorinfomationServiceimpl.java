package service.impl;

import dao.impl.StudentDaoimpl;
import dao.impl.TeacherDaoimpl;
import entity.Student;
import entity.Teacher;
import service.administratorinfomationService;

public class administratorinfomationServiceimpl implements administratorinfomationService{

	@Override
	public int modifyStudent(Student info) {
		StudentDaoimpl DAO = new StudentDaoimpl();
		return DAO.modify(info);
	}

	@Override
	public int modfiyTeacher(Teacher info) {
		TeacherDaoimpl DAO = new TeacherDaoimpl();
		return DAO.modify(info);
	}

}
