package dao;

import java.util.List;

import entity.ProfProgram;

public interface profprogramDao {
	public int insert(ProfProgram p);
	public List<ProfProgram> searchBySpecialty(String specialty);
}
