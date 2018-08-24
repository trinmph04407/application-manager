package vn.poly.group2.pro2111.classes.repositories;

import java.util.List;

import vn.poly.group2.pro2111.common.entities.Lecturer;

public interface LecturerRepository {
	
	List<Lecturer> search(String code);
}
