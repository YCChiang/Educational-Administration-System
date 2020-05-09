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
		if(info.getAge()<0)
			return 2;	//年龄有问题
		Student old = DAO.searchByStudentid(info.getId());
		if(old == null)
			return 3 ;	//此id不对应人学生
		return DAO.modify(info);
	}

	@Override
	public int modfiyTeacher(Teacher info) {
		TeacherDaoimpl DAO = new TeacherDaoimpl();
		Teacher old = DAO.searchByTeacherid(info.getId());
		if(old == null)
			return 3;	//此id不对应教师
		return DAO.modify(info);
	}

	@Override
	public int addStudent(Student info) {
		StudentDaoimpl DAO = new StudentDaoimpl();
		Student old = DAO.searchByStudentid(info.getId());
		if(old!=null)
			return 2;	//此学号id已经被使用
		return DAO.insert(info);
	}

	@Override
	public int addTeacher(Teacher info) {
		TeacherDaoimpl DAO = new TeacherDaoimpl();
		Teacher old = DAO.searchByTeacherid(info.getId());
		if(old!=null)
			return 2;	//此工号已经被使用
		return DAO.insert(info);
	}

}
