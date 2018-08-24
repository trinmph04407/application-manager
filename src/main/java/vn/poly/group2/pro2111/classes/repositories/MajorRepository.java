package vn.poly.group2.pro2111.classes.repositories;

import java.util.List;

import vn.poly.group2.pro2111.common.entities.Major;

public interface MajorRepository {
	
	List<Major> search(String code);
}
