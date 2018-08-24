package vn.poly.group2.pro2111.student.repositories;

import java.util.List;

import vn.poly.group2.pro2111.common.entities.Clasess;
import vn.poly.group2.pro2111.common.entities.Major;
import vn.poly.group2.pro2111.common.entities.Student;

public interface StudentRepository {
	Long count(String code, String name);

	List<Student> select(String code, String name, int offset, int limit);

	Student selectStudent(Long id);

	boolean checkId(String code);

	boolean insert(Student student);

	boolean update(Student student);

	boolean remove(Long id);

	List<Clasess> listClass();

	List<Major> listMajor();
}
