/*
 *@Author P.Tuong
 *@Date Jul 17, 2018
 *@Version 1.0
*/
package vn.poly.group2.pro2111.record.repositories.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import vn.poly.group2.pro2111.common.bases.BaseRepository;
import vn.poly.group2.pro2111.common.entities.Record;
import vn.poly.group2.pro2111.record.repositories.RecordRepository;

@Repository
public class RecordRepositoryImpl extends BaseRepository implements RecordRepository {

	@Override
	@SuppressWarnings("unchecked")
	public List<Record> select(Long lecturerId, String typeRecord, int offset, int limit) {

		StringBuilder queryStb = new StringBuilder("from Record");

		if (StringUtils.isNoneBlank(typeRecord) && lecturerId != null) {
			queryStb.append(" where lecturerId like :lecturerId AND typeRecord = :typeRecord ");
		} else if (lecturerId != null) {
			queryStb.append(" where lecturerId like :lecturerId ");
		} else if (StringUtils.isNotBlank(typeRecord)) {
			queryStb.append(" where typeRecord = :typeRecord ");
		}

		Query query = this.getCurrentSession().createQuery(queryStb.toString());
		if (lecturerId != null) {
			query.setString("lecturerId", "%" + lecturerId + "%");
		}
		if (StringUtils.isNotBlank(typeRecord)) {
			query.setString("typeRecord","%" + typeRecord  + "%");
		}

		return query.setFirstResult(offset).setMaxResults(limit).list();
	}

	@Override
	public Long count(Long lecturerId, String typeRecord) {
		StringBuilder queryStb = new StringBuilder("select count(1) from Record");

		if (StringUtils.isNoneBlank(typeRecord) && lecturerId != null) {
			queryStb.append(" where lecturerId like :lecturerId AND typeRecord = :typeRecord ");
		} else if (lecturerId != null) {
			queryStb.append(" where lecturerId like :lecturerId ");
		} else if (StringUtils.isNotBlank(typeRecord)) {
			queryStb.append(" where typeRecord = :typeRecord ");
		}

		Query query = this.getCurrentSession().createQuery(queryStb.toString());
		if (lecturerId != null) {
			query.setString("lecturerId", "%" + lecturerId + "%");
		}
		if (StringUtils.isNotBlank(typeRecord)) {
			query.setString("typeRecord","%" + typeRecord + "%");
		}

		return (Long) query.uniqueResult();
	}

	@Override
	public Long insert(Record record) {
		return (Long) super.insert(record);
	}

	@Override
	public Long update(Record record) {
		return (Long) super.update(record);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Record> ListRecord() {

		List<Record> listRecord = this.getCurrentSession().createQuery("From Record").list();
		return listRecord;
	}

	@Override
	public Record getIdRecord(Long id) {
		Record record = null;
		try {
			record = this.getCurrentSession().get(Record.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return record;
	}

	@Override
	public boolean remove(Long id) {
		Session session = this.getCurrentSession();
		Record record = session.get(Record.class, id);
		session.delete(record);
		return true;
	}


}
