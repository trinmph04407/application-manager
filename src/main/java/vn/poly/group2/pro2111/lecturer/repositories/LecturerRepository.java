package vn.poly.group2.pro2111.lecturer.repositories;

import java.util.List;

import vn.poly.group2.pro2111.common.entities.Lecturer;

public interface LecturerRepository {
	
	Long count(String code, String name);

	List<Lecturer> select(String code, String name, int offset, int limit);

	boolean deleteLecturer(Long id);

	boolean insertLecturer(Lecturer lecturer);
	
	Lecturer getLecturerId(Long id);

	boolean editLecturer(Lecturer lecturer);
	
	boolean checkId(String code);
	
}
