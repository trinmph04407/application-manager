/**
 * 
 */
package vn.poly.group2.pro2111.subject.repositories;

import java.util.List;

import vn.poly.group2.pro2111.common.bases.BaseRepositoryInterface;
import vn.poly.group2.pro2111.common.entities.Subject;

/**
 * Subject repository
 * 
 * @author minht
 * 
 */

public interface SubjectRepository extends BaseRepositoryInterface  {
	
	Long count(Long majorId,Long lecturerId, String name);
	
	List<Subject> select(Long majorId,Long lecturerId,  String name, int offset, int limit);

	Subject select(Long id);
	
	Long insert(Subject subject);
	
	Long update(Subject subject);
	
	boolean remove(Long id);
	
	boolean check(String code);
	
	
}
