/*
 *@Author P.Tuong
 *@Date Jul 18, 2018
 *@Version 1.0
*/
package vn.poly.group2.pro2111.account.repositories.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import vn.poly.group2.pro2111.account.repositories.LecturerRepository;
import vn.poly.group2.pro2111.common.bases.BaseRepository;
import vn.poly.group2.pro2111.common.entities.Lecturer;

@Repository("accLecturerRepositoryImpl")
public class LecturerRepositoryImpl extends BaseRepository implements LecturerRepository {

	@Override
	@SuppressWarnings("unchecked")
	public List<Lecturer> search(Long id) {
		 StringBuilder queryStb = new StringBuilder("from Lecturer ");

	        // Add order conditional
	        queryStb.append(" order by id");

	        // Build query
	        Query query = this.getCurrentSession().createQuery(queryStb.toString());

	      

	        return query.list();
	}

}
