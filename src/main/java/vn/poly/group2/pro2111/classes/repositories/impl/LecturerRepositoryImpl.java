package vn.poly.group2.pro2111.classes.repositories.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.poly.group2.pro2111.classes.repositories.LecturerRepository;
import vn.poly.group2.pro2111.common.bases.BaseRepository;
import vn.poly.group2.pro2111.common.entities.Lecturer;

@Transactional
@Repository("empLecturerRepositoryImpl1")
public class LecturerRepositoryImpl extends BaseRepository implements LecturerRepository {

	@Override
	@SuppressWarnings("unchecked")
	public List<Lecturer> search(String code) {

		StringBuilder queryStb = new StringBuilder("from Lecturer ");

		queryStb.append(" order by code");

		// Build query
		Query query = this.getCurrentSession().createQuery(queryStb.toString());

		return query.list();
	}

}
