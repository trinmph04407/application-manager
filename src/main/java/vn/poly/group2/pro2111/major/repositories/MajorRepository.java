/**
 * 
 */
package vn.poly.group2.pro2111.major.repositories;

import java.util.List;

import vn.poly.group2.pro2111.common.entities.Major;

/**
 * Major repository
 * 
 * @author minht
 * 
 */
public interface  MajorRepository {
	
	 Long count(Long lecturerId, String name);
	 
	 List<Major> select(Long lecturerId, String name, int offset, int limit);
	 
	 Major select(Long id);
	 
	 Long insert(Major major);
	 
	 Long update(Major major);
	 
	 boolean remove(Long id);
	 
	 boolean check(String code);
}
