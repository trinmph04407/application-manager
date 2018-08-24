package vn.poly.group2.pro2111.classes.repositories.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.poly.group2.pro2111.classes.repositories.MajorRepository;
import vn.poly.group2.pro2111.common.bases.BaseRepository;
import vn.poly.group2.pro2111.common.entities.Major;

@Transactional
@Repository("empMajorRepositoryImpl1")
public class MajorReponsitoryImpl  extends BaseRepository implements MajorRepository {

	@Override
	@SuppressWarnings("unchecked")
	public List<Major> search(String code) {
		StringBuilder queryStb = new StringBuilder("from Major ");

		queryStb.append(" order by name");

		// Build query
		Query query = this.getCurrentSession().createQuery(queryStb.toString());

		return query.list();
	}

}
