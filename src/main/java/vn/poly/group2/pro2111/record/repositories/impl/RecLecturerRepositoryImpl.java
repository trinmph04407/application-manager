/*
 *@Author P.Tuong
 *@Date Jul 19, 2018
 *@Version 1.0
*/
package vn.poly.group2.pro2111.record.repositories.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import vn.poly.group2.pro2111.common.bases.BaseRepository;
import vn.poly.group2.pro2111.common.entities.Lecturer;
import vn.poly.group2.pro2111.record.repositories.RecLecturerRepository;
@Repository("recLecturerRepositoryImpl")
public class RecLecturerRepositoryImpl extends BaseRepository implements RecLecturerRepository {
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Lecturer> search(String name) {
		 StringBuilder queryStb = new StringBuilder("from Lecturer ");

	        // Add order conditional
	        queryStb.append(" order by name");

	        // Build query
	        Query query = this.getCurrentSession().createQuery(queryStb.toString());

	      

	        return query.list();
	}
}
