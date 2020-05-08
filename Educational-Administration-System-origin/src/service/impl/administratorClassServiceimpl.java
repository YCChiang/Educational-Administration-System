package service.impl;

import java.util.List;

import dao.impl.ClassInfoDaoimpl;
import entity.ClassInfo;
import service.administratorClassService;

public class administratorClassServiceimpl implements administratorClassService{

	@Override
	public List<ClassInfo> findClassInfoList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modify(ClassInfo classinfo) {
		// TODO Auto-generated method stub
		ClassInfoDaoimpl DAO = new ClassInfoDaoimpl();
		return DAO.modify(classinfo);
	}

}
