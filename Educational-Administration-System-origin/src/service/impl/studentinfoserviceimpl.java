package service.impl;

import dao.impl.studentDaoimpl;
import entity.Student;
import service.StudentInfomationService;

public class studentinfoserviceimpl implements StudentInfomationService{

	@Override
	public Student findById(String id) {
		// TODO Auto-generated method stub
		studentDaoimpl Dao = new studentDaoimpl();
		Student stu = Dao.searchbystudentid(id);
		return stu;
	}

}
