package service.impl;

import java.util.List;

import dao.impl.ProfprogramDaoimpl;
import entity.ProfProgram;
import service.studentprofprogramService;

public class studentprofprogramServiceimpl implements studentprofprogramService {
	ProfprogramDaoimpl DAO = new ProfprogramDaoimpl();
	@Override
	public List<ProfProgram> findProfProgramList(String specialty) {
		return DAO.searchBySpecialty(specialty);
	}

}
