package service.impl;

import dao.impl.StudentDaoimpl;
import entity.Student;
import service.StudentInfomationService;

public class studentinfoserviceimpl implements StudentInfomationService{
	StudentDaoimpl DAO= new StudentDaoimpl();
	@Override
	public Student findById(String id) {
		Student stu = DAO.searchByStudentid(id);
		return stu;
	}

}
