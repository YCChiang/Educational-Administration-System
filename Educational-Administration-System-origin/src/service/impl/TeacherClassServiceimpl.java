package service.impl;

import dao.impl.classgradeDaoimpl;
import dao.impl.classinfoDaoimpl;
import entity.ClassGrade;
import entity.ClassInfo;
import service.TeacherClassService;

public class TeacherClassServiceimpl implements TeacherClassService{

	@Override
	public int addClassinfo(ClassInfo Classinfo) {
		classinfoDaoimpl DAO = new classinfoDaoimpl();
		return DAO.insert(Classinfo);
	}

	@Override
	public int addClassgrade(ClassGrade classgrade) {
		classgradeDaoimpl DAO = new classgradeDaoimpl();
		return DAO.insert(classgrade);
	}

	@Override
	public ClassInfo[] findclassinfoList(String teacher_id) {
		// TODO Auto-generated method stub
		classinfoDaoimpl DAO = new classinfoDaoimpl();
		return DAO.selectbyteacherid(teacher_id);
	}

}
