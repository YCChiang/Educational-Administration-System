package service.impl;

import java.util.List;

import dao.impl.ClassGradeDaoimpl;
import dao.impl.ClassInfoDaoimpl;
import dao.impl.ElectiveInfoDaoImpl;
import entity.ClassGrade;
import entity.ClassInfo;
import service.TeacherClassService;

public class TeacherClassServiceimpl implements TeacherClassService{
	ClassInfoDaoimpl IDAO = new ClassInfoDaoimpl();
	ClassGradeDaoimpl GDAO = new ClassGradeDaoimpl();
	ElectiveInfoDaoImpl EDAO = new ElectiveInfoDaoImpl();
	
	@Override
	public int addClassinfo(ClassInfo Classinfo) {
		ClassInfo old = IDAO.selectById(Classinfo.getId());
		if(old!=null) {           //课程号重复,无法添加
			return 2;
		}
		if(Classinfo.getCapacity() <=0)   //课容量不应该小于0
			return 3 ; 
		return IDAO.insert(Classinfo);  //插入此条课程
	}

	@Override
	public int addClassgrade(ClassGrade classgrade) {
		if(classgrade.getGrade()>0||classgrade.getGrade()>100)
			return 3;	//提示成绩不合理，重新输入
		ClassGrade old = GDAO.selectByStudentidandClassID(classgrade.getStudent_id(), classgrade.getClass_id());
		if(old!=null)
			return 2 ;        //提示已经输入过此人的成绩
		if(EDAO.selectByClass_idAndStudent_id(classgrade.getStudent_id(),classgrade.getClass_id())==null)
				return 4;	//提示没有该学生选课或
		
		if(classgrade.getGrade() < 60)
			classgrade.setMakeup("补考");   	//如果成绩低于60需要补考
		else
			classgrade.setMakeup("无补考");  //成绩大于等于60不需要补考
		return GDAO.insert(classgrade);
	}

	@Override
	public List<ClassInfo> findclassinfoList(String teacher_id) {
		// TODO Auto-generated method stub
		return IDAO.selectByTeacherid(teacher_id);
	}

}
