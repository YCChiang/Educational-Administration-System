package dao;

import entity.Makeup;
import entity.Student;

public interface makeupDao {
	public int insert(Makeup M);
	public Makeup[] searchbystudentid(Student S);
}
