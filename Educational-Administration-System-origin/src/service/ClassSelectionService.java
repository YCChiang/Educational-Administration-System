package service;

import java.util.List;

import entity.ClassSelection;
public interface ClassSelectionService {
	public int save(ClassSelection cs);
	public List<ClassSelection> findByStudent_id(String student_id);
	public List<ClassSelection> findByClass_id(int class_id);
}
