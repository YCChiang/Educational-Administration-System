package service.impl;

import java.util.List;

import dao.impl.ProfprogramDaoimpl;
import entity.ProfProgram;
import service.studentprofprogramService;

public class studentprofprogramServiceimpl implements studentprofprogramService {

	@Override
	public List<ProfProgram> findProfProgramList(String specialty) {
		ProfprogramDaoimpl DAO = new ProfprogramDaoimpl();
		return DAO.searchBySpecialty(specialty);
	}

}
