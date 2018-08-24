/*
 * (C) Copyright 2018
 *
 * @auth Nguyen Van Doan
 * @date Aug 14, 2018
 */
package vn.poly.group2.pro2111.statics.repositories.Impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import vn.poly.group2.pro2111.common.bases.BaseRepository;
import vn.poly.group2.pro2111.statics.repositories.StaticsRepository;

@Repository
public class StaticsRepositoryImpl extends BaseRepository implements StaticsRepository  {

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> listStatics() {
		String hql = "SELECT r.lecturer.code, r.lecturer.name," 
				+ " SUM(case when r.typeRecord=1 then 1 else 0 end), "
				+ " SUM(case when r.typeRecord=0 then 1 else 0 end) " + " FROM Record r " + " GROUP BY r.lecturer.code";
		Query query = this.getCurrentSession().createQuery(hql);
		List<Object[]> list = query.list();
		return list;
	}
	
}
