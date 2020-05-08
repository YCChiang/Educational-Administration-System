package service.impl;

import java.util.List;

import dao.impl.ClassGradeDaoimpl;
import dao.impl.ClassInfoDaoimpl;
import entity.ClassGrade;
import entity.ClassInfo;
import service.TeacherClassService;

public class TeacherClassServiceimpl implements TeacherClassService{

	@Override
	public int addClassinfo(ClassInfo Classinfo) {
		ClassInfoDaoimpl DAO = new ClassInfoDaoimpl();
		return DAO.insert(Classinfo);
	}

	@Override
	public int addClassgrade(ClassGrade classgrade) {
		ClassGradeDaoimpl DAO = new ClassGradeDaoimpl();
		return DAO.insert(classgrade);
	}

	@Override
	public List<ClassInfo> findclassinfoList(String teacher_id) {
		// TODO Auto-generated method stub
		ClassInfoDaoimpl DAO = new ClassInfoDaoimpl();
		return DAO.selectByTeacherid(teacher_id);
	}

}
