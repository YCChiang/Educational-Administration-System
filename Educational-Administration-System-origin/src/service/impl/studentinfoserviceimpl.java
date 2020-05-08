package service.impl;

import dao.impl.StudentDaoimpl;
import entity.Student;
import service.StudentInfomationService;

public class studentinfoserviceimpl implements StudentInfomationService{

	@Override
	public Student findById(String id) {
		// TODO Auto-generated method stub
		StudentDaoimpl Dao = new StudentDaoimpl();
		Student stu = Dao.searchByStudentid(id);
		return stu;
	}

}
