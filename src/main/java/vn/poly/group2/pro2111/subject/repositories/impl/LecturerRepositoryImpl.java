/**
 * 
 */
package vn.poly.group2.pro2111.subject.repositories.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import vn.poly.group2.pro2111.common.bases.BaseRepository;
import vn.poly.group2.pro2111.common.entities.Lecturer;
import vn.poly.group2.pro2111.subject.repositories.LecturerRepository;

/**
 *  Lecturer repository implement
 * 
 * @author minht
 * 
 */
@Repository("empLecturerRepositoryImpl")
public class LecturerRepositoryImpl extends BaseRepository implements LecturerRepository {

	@Override
	@SuppressWarnings("unchecked")
	public List<Lecturer> search(String code) {
		
		// Build query string with default conditional
		 StringBuilder queryStb = new StringBuilder("from Lecturer ");
		 
	        // Add order conditional
	        queryStb.append(" order by code");

	        // Build query
	        Query query = this.getCurrentSession().createQuery(queryStb.toString());
 
	        return query.list();
	}

}
