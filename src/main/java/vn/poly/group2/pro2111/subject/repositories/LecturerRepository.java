/**
 * 
 */
package vn.poly.group2.pro2111.subject.repositories;

import java.util.List;

import vn.poly.group2.pro2111.common.bases.BaseRepositoryInterface;
import vn.poly.group2.pro2111.common.entities.Lecturer;

/**
 * Lecturer repository
 * 
 * @author minht
 * 
 */
public interface LecturerRepository extends BaseRepositoryInterface{
		
	List<Lecturer> search(String code);
}
