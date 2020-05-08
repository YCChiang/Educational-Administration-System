package service.impl;

import dao.impl.TeacherDaoimpl;
import entity.Teacher;
import service.TeacherInfomationService;

public class TeacherInformationServiceimpl implements TeacherInfomationService{

	@Override
	public Teacher findById(String id) {
		TeacherDaoimpl Dao = new TeacherDaoimpl();
		return Dao.searchByTeacherid(id);
	}

	@Override
	public int modify(Teacher t) {
		TeacherDaoimpl DAO = new TeacherDaoimpl();
		return DAO.modify(t);
	}

}
