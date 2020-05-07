package service;

import java.util.List;

import entity.ClassGrade;
import entity.ClassInfo;

public interface TeacherClassService {
	public int addClassinfo(ClassInfo Classinfo); //提交课程信息
	public int addClassgrade(ClassGrade classgrade); //添加课程成绩
	public List<ClassInfo> findclassinfoList(String teacher_id); //查询老师教授课程
}
