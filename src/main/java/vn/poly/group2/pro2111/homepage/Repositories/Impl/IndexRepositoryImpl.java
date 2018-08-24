/*
 * (C) Copyright 2018
 *
 * @auth Nguyen Van Doan
 * @date Aug 16, 2018
 */
package vn.poly.group2.pro2111.homepage.Repositories.Impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import vn.poly.group2.pro2111.common.bases.BaseRepository;
import vn.poly.group2.pro2111.homepage.Repositories.IndexRepository;

@Repository
public class IndexRepositoryImpl extends BaseRepository implements IndexRepository {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> listTop() {
		String hql = "SELECT r.lecturer.code, r.lecturer.name, r.lecturer.photo,"
				+ " SUM(case when r.typeRecord=1 then 1 else 0 end)"
				+ " FROM Record r "
				+ " GROUP BY r.lecturer.code"
				+ " ORDER BY SUM(typeRecord) DESC";
		Query query = this.getCurrentSession().createQuery(hql);
		List<Object[]> list = query.list();
		return list;
	}

}
