package service.impl;

import dao.impl.teacherDaoimpl;
import entity.Teacher;
import service.TeacherInfomationService;

public class TeacherInformationServiceimpl implements TeacherInfomationService{

	@Override
	public Teacher findById(String id) {
		teacherDaoimpl Dao = new teacherDaoimpl();
		return Dao.searchbyteacherid(id);
	}

}
