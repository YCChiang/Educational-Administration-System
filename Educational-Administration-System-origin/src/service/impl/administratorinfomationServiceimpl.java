package service.impl;

import dao.impl.studentDaoimpl;
import dao.impl.teacherDaoimpl;
import entity.Student;
import entity.Teacher;
import service.administratorinfomationService;

public class administratorinfomationServiceimpl implements administratorinfomationService{

	@Override
	public int modifyStudent(Student info) {
		studentDaoimpl DAO = new studentDaoimpl();
		return DAO.modify(info);
	}

	@Override
	public int modfiyTeacher(Teacher info) {
		teacherDaoimpl DAO = new teacherDaoimpl();
		return DAO.modify(info);
	}

}
