package service.impl;

import dao.impl.TeacherDaoimpl;
import entity.Teacher;
import service.TeacherInfomationService;

public class TeacherInformationServiceimpl implements TeacherInfomationService{
	TeacherDaoimpl DAO = new TeacherDaoimpl();
	@Override
	public Teacher findById(String id) {
		return DAO.searchByTeacherid(id);
	}

	@Override
	public int modify(Teacher t) {
		return DAO.modify(t);
	}

}
