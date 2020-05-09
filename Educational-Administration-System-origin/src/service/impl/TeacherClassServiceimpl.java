package service.impl;

import java.util.List;

import dao.impl.ClassGradeDaoimpl;
import dao.impl.ClassInfoDaoimpl;
import dao.impl.ElectiveInfoDaoImpl;
import entity.ClassGrade;
import entity.ClassInfo;
import service.TeacherClassService;

public class TeacherClassServiceimpl implements TeacherClassService{

	@Override
	public int addClassinfo(ClassInfo Classinfo) {
		ClassInfoDaoimpl DAO = new ClassInfoDaoimpl();
		ClassInfo old = DAO.selectById(Classinfo.getId());
		if(old!=null) {           //课程号重复,无法添加
			return 2;
		}
		if(Classinfo.getCapacity() <=0)   //课容量不应该小于0
			return 3 ; 
		return DAO.insert(Classinfo);  //插入此条课程
	}

	@Override
	public int addClassgrade(ClassGrade classgrade) {
		ClassGradeDaoimpl DAO = new ClassGradeDaoimpl();
		if(classgrade.getGrade()>0||classgrade.getGrade()>100)
			return 3;	//提示成绩不合理，重新输入
		ClassGrade old = DAO.selectByStudentidandClassID(classgrade.getStudent_id(), classgrade.getClass_id());
		if(old!=null)
			return 2 ;        //提示已经输入过此人的成绩
		
		ElectiveInfoDaoImpl EDAO = new ElectiveInfoDaoImpl();
		if(EDAO.selectByClass_idAndStudent_id(classgrade.getStudent_id(),classgrade.getClass_id())==null)
				return 4;	//提示没有该学生选课或
		
		if(classgrade.getGrade() < 60)
			classgrade.setMakeup("补考");   	//如果成绩低于60需要补考
		else
			classgrade.setMakeup("无补考");  //成绩大于等于60不需要补考
		return DAO.insert(classgrade);
	}

	@Override
	public List<ClassInfo> findclassinfoList(String teacher_id) {
		// TODO Auto-generated method stub
		ClassInfoDaoimpl DAO = new ClassInfoDaoimpl();
		return DAO.selectByTeacherid(teacher_id);
	}

}
