package service;
import java.util.List;

import entity.ProfProgram;
public interface studentprofprogramService {
	public List<ProfProgram> findProfProgramList(String specialty);
}
