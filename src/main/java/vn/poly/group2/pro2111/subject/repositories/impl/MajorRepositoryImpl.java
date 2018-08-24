/**
 * 
 */
package vn.poly.group2.pro2111.subject.repositories.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import vn.poly.group2.pro2111.common.bases.BaseRepository;
import vn.poly.group2.pro2111.common.entities.Major;
import vn.poly.group2.pro2111.subject.repositories.MajorRepository;

/**
 * Major repository implement
 * 
 * @author minht
 * 
 */

@Repository("empMajorRepositoryImpl")
public class MajorRepositoryImpl  extends BaseRepository implements MajorRepository{

	@Override
	@SuppressWarnings("unchecked")
	public List<Major> search(String code) {
		
		// Build query string with default conditional
		 StringBuilder queryStb = new StringBuilder("from Major ");
		 
	        // Add order conditional
	        queryStb.append(" order by code");

	        // Build query
	        Query query = this.getCurrentSession().createQuery(queryStb.toString());

	       
	        return query.list();
	}
}
