package service.impl;

import dao.impl.ProfprogramDaoimpl;
import entity.ProfProgram;
import service.profprogramService;

public class profprogramServiceimpl implements profprogramService {
	ProfprogramDaoimpl PPDAO = new ProfprogramDaoimpl();
	@Override
	public int add(ProfProgram info) {
		return PPDAO.insert(info);
	}

}
