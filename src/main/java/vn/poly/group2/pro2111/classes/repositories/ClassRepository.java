package vn.poly.group2.pro2111.classes.repositories;

import java.util.List;

import vn.poly.group2.pro2111.common.entities.Clasess;
import vn.poly.group2.pro2111.common.entities.Student;

public interface ClassRepository {

	Long count(Long majorid, Long lecturerid);

	List<Clasess> select(Long majorid, Long lecturerid, int offset, int limit);

	Clasess select(Long id);

	boolean insert(Clasess clasess);
	
	boolean update(Clasess clasess);

	boolean remove(Long id);
	
	boolean checkId(String code);

	public List<Student> listStudent();}
