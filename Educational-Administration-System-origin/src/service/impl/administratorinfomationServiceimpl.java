package service.impl;

import dao.impl.StudentDaoimpl;
import dao.impl.TeacherDaoimpl;
import entity.Student;
import entity.Teacher;
import service.administratorinfomationService;

public class administratorinfomationServiceimpl implements administratorinfomationService{
	StudentDaoimpl studentDao = new StudentDaoimpl();
	TeacherDaoimpl teacherDao = new TeacherDaoimpl();
	@Override
	public int modifyStudent(Student info) {
		if(info.getAge()<0)
			return 2;	//年龄有问题
		Student old = studentDao.searchByStudentid(info.getId());
		if(old == null)
			return 3 ;	//此id不对应人学生
		return studentDao.modify(info);
	}

	@Override
	public int modfiyTeacher(Teacher info) {		
		Teacher old = teacherDao.searchByTeacherid(info.getId());
		if(old == null)
			return 3;	//此id不对应教师
		return teacherDao.modify(info);
	}

	@Override
	public int addStudent(Student info) {
		Student old = studentDao.searchByStudentid(info.getId());
		if(old!=null)
			return 2;	//此学号id已经被使用
		return studentDao.insert(info);
	}

	@Override
	public int addTeacher(Teacher info) {
		Teacher old = teacherDao.searchByTeacherid(info.getId());
		if(old!=null)
			return 2;	//此工号已经被使用
		return teacherDao.insert(info);
	}

}
