package service.impl;

import java.util.ArrayList;
import java.util.List;
import entity.ClassInfo;
import entity.ClassSchedule;
import entity.ElectiveInfo;
import entity.Teacher;
import service.ClassInfoService;

import dao.impl.ClassInfoDaoimpl;
import dao.impl.ElectiveInfoDaoImpl;
import dao.impl.ClassScheduleDAOImpl;
import dao.impl.TeacherDaoimpl;

public class ClassInfoServiceImpl implements ClassInfoService {
	ClassInfoDaoimpl classinfoDao = new ClassInfoDaoimpl();
	ElectiveInfoDaoImpl electiveinfoDao = new ElectiveInfoDaoImpl();
	ClassScheduleDAOImpl classscheduleDAO = new ClassScheduleDAOImpl();
	TeacherDaoimpl teacherDao = new TeacherDaoimpl();
	
	@Override
	public List<ClassInfo> findByName(String name) {
		return classinfoDao.selectByName(name);
	}

	@Override
	public ClassInfo findOne(String Id) {
		return classinfoDao.selectOne(Id);
	}
	
	public List<ClassInfo> findByStudentIdAndYear(String student_id, String year){
		List<ElectiveInfo> temp = electiveinfoDao.selectByStudentid(student_id);
		List<ClassInfo> classes = new ArrayList<ClassInfo>();
		if(!temp.isEmpty()) {
			for(ElectiveInfo t:temp) {
				ClassInfo info = classinfoDao.selectOne(t.getClass_id());
				if(info.getYear().equals(year))
					classes.add(info);
			}
			System.out.print("classinfoDao");
		}
		return classes;
	}
	
	public boolean IsConflictToOther(ClassInfo classInfo, String student_id) {
		List<ElectiveInfo> electiveInfo = electiveinfoDao.selectByStudentid(student_id);
		List<String> conflictClass = new ArrayList<String>();
		
		// 查看选择的课程是否与已选课程在教学周上有冲突
		if(!electiveInfo.isEmpty()) {
			for(ElectiveInfo e:electiveInfo) {
				ClassInfo temp = classinfoDao.selectOne(e.getClass_id());
				if(temp.getEnd_week() > classInfo.getStart_week() && temp.getStart_week() < classInfo.getStart_week()) {
					conflictClass.add(e.getClass_id());					
				}
				else if(temp.getStart_week() > classInfo.getStart_week() && temp.getStart_week() < classInfo.getEnd_week()) {
					conflictClass.add(e.getClass_id());	
				}				
			}			
		}
		
		// 查看在教学周上有冲突的课程，在上课时间是否有冲突
		if(!conflictClass.isEmpty()) {			
			List<ClassSchedule> schedule = classscheduleDAO.selectByClass_id(classInfo.getId());
			for(ClassSchedule s:schedule) {
				List<ClassSchedule> temp = classscheduleDAO.selectByClass_idsAndDayAndTime(conflictClass, s.getDay(), s.getTime());
				if(!temp.isEmpty()){
					return true;
				}
			}
		}
		return false;
	}
	
	
	/*
	 * 通过课程名称查找课程
	 * IsFall: false为只查找课容量不为0的课程，0true为包括课容量为0的课程
	 * IsConflict: false为只查找与自己选课不冲突的课程，true为包括冲突课程
	 */
	public List<ClassInfo> seachClassByName(String name, String year,String student_id, boolean IsFull, boolean IsConflict) {
		List<ClassInfo> Infos = findByNameAndYear(name, year);		
		if(!Infos.isEmpty())
		{
			if(!IsFull) {
				for(ClassInfo info:Infos) {
					if(info.getCapacity() == electiveinfoDao.selectByClassID(info.getId()).size()) {
						Infos.remove(info);
					}
				}
			}
			
			if(!IsConflict) {
				for(ClassInfo info:Infos) {
					if(IsConflictToOther(info, student_id)) {
						Infos.remove(info);
					}
				}
			}
		}
		return Infos;
	}
	
	public List<ClassInfo> seachClassById(String id, String year,String student_id, boolean IsFull, boolean IsConflict) {
		List<ClassInfo> Infos = findByIdAndYear(id, year);
		if(!Infos.isEmpty())
		{
			if(!IsFull) {
				for(ClassInfo info:Infos) {
					if(info.getCapacity() == electiveinfoDao.selectByClassID(info.getId()).size()) {
						Infos.remove(info);
					}
				}
			}
			
			if(!IsConflict) {
				for(ClassInfo info:Infos) {
					if(IsConflictToOther(info, student_id)) {
						Infos.remove(info);
					}
				}
			}
		}
		return Infos;
	}

	@Override
	public List<ClassInfo> findByTeacher_id(String teacher_id) {
		return classinfoDao.selectByTeacherid(teacher_id);
	}

	@Override
	public List<ClassInfo> findByYear(String year) {
		return classinfoDao.selectByYear(year);
	}

	@Override
	public int modify(ClassInfo classinfo) {
		return classinfoDao.update(classinfo);
	}

	@Override
	public int add(ClassInfo classinfo) {
		return classinfoDao.insert(classinfo);
	}

	@Override
	public List<ClassInfo> findByTeacher_idAndYear(String teacher_id, String year) {
		return classinfoDao.selectByTeacheridAndYear(teacher_id, year);
	}

	@Override
	public List<ClassInfo> findByNameAndYear(String name, String year) {
		return classinfoDao.selectByNameAndYear(name, year);
	}

	@Override
	public List<ClassInfo> findByIdAndYear(String id, String year) {
		return classinfoDao.selectByIdAndYear(id, year);
	}

	@Override
	public ClassInfo findByIdAndTeacher_id(String Id, String teacher_id) {
		return classinfoDao.selectByTeacheridandClassid(teacher_id, Id);
	}

	public Massage addOne(ClassInfo classinfo) {
		Massage msg = new Massage();
		if(findOne(classinfo.getId()) == null) {
			Teacher teacher = teacherDao.searchByTeacherid(classinfo.getTeacher_id());
			if(teacher != null) {
				classinfo.setTeacher_name(teacher.getName());
				if(add(classinfo) == 1) {
					msg.setIsError(false);
					msg.setContent("导入课程成功！");
				}
				else {
					msg.setIsError(true);
					msg.setContent("输入信息错误！");
				}
			}
			else {
				msg.setIsError(true);
				msg.setContent("教师id不存在！");
			}
		}
		else {
			msg.setIsError(true);
			msg.setContent("此课程id已存在，无法插入");
		}
		return msg;
	}
}
