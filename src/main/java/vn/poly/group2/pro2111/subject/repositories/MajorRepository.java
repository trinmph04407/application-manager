/**
 * 
 */
package vn.poly.group2.pro2111.subject.repositories;

import java.util.List;

import vn.poly.group2.pro2111.common.bases.BaseRepositoryInterface;
import vn.poly.group2.pro2111.common.entities.Major;

/**
 * Major repository
 * 
 * @author minht
 * 
 */
public interface  MajorRepository extends BaseRepositoryInterface{
	
	  List<Major> search(String code);
}
