package service.impl;

import dao.impl.ElectiveInfoDaoImpl;
import service.removeClassService;

public class removeClassServiceimpl implements removeClassService {

	@Override
	public int remove(String student_id, String class_id) {
		ElectiveInfoDaoImpl DAO = new ElectiveInfoDaoImpl();
		if(DAO.isSelected(student_id, class_id)==1) {
			
		}
		else {
			return 2;	//未选该课
		}
		return DAO.remove(student_id, class_id);
	}
	
}
