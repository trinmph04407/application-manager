/**
 * 
 */
package vn.poly.group2.pro2111.major.repositories.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import vn.poly.group2.pro2111.common.bases.BaseRepository;
import vn.poly.group2.pro2111.common.entities.Major;
import vn.poly.group2.pro2111.major.repositories.MajorRepository;

/**
 * Major repository implement
 * 
 * @author minht
 * 
 */
@Repository
public class MajorRepositoryImpl extends BaseRepository implements MajorRepository {

	@Override
	public Long count(Long lecturerId, String name) {

		// Build query string with default conditional
		StringBuilder queryStb = new StringBuilder("select count(1) from Major");

		// Add lecturerId && name condition
		if (StringUtils.isNoneBlank(name) && lecturerId != null) {
			queryStb.append(" where name like :name and lecturerId = :lecturerId");

		// Add lecturerId condition
		} else if (lecturerId != null) {
			queryStb.append(" where lecturerId = :lecturerId ");
		}

		// Add name condition
		else if (StringUtils.isNotBlank(name)) {
			queryStb.append(" where name like :name ");
		}

		// Build query
		Query query = this.getCurrentSession().createQuery(queryStb.toString());

		// Set lecturerId parameter
		if (lecturerId != null) {
			query.setLong("lecturerId", lecturerId);
		}

		// Set name parameter
		if (StringUtils.isNotBlank(name)) {
			query.setString("name", "%" + name + "%");
		}

		return (Long) query.uniqueResult();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Major> select(Long lecturerId, String name, int offset, int limit) {

		// Build query string with default conditional
		StringBuilder queryStb = new StringBuilder("from Major ");

		// Add lecturerId && name condition
		if (StringUtils.isNoneBlank(name) && lecturerId != null) {
			queryStb.append(" where name like :name and lecturerId = :lecturerId");
		}

		// Add lecturerId condition
		else if (lecturerId != null) {
			queryStb.append(" where lecturerId = :lecturerId ");
		}

		// Add name condition
		else if (StringUtils.isNotBlank(name)) {
			queryStb.append(" where name like :name ");
		}
		
		// Add order conditional
		queryStb.append(" order by name");

		// Build query
		Query query = this.getCurrentSession().createQuery(queryStb.toString());

		// Set lecturerId parameter
		if (lecturerId != null) {
			query.setLong("lecturerId", lecturerId);
		}

		// Set name parameter
		if (StringUtils.isNotBlank(name)) {
			query.setString("name", "%" + name + "%");
		}

		return query.setFirstResult(offset).setMaxResults(limit).list();
	}

	/*
	 * (non-Javadoc) select id major
	 */
	@Override
	public Major select(Long id) {
		Major entity = this.getCurrentSession().get(Major.class, id);
		return entity;
	}

	/*
	 * (non-Javadoc) create major
	 */
	@Override
	public Long insert(Major major) {
		return (Long) super.insert(major);
	}

	/*
	 * (non-Javadoc) update major
	 */
	@Override
	public Long update(Major major) {
		return (Long) super.update(major);
	}

	/*
	 * (non-Javadoc) remove major
	 */
	@Override
	public boolean remove(Long id) {
		Session session = this.getCurrentSession();
		Major major = session.get(Major.class, id);
		session.delete(major);
		return true;
	}

	/*
	 * (non-Javadoc) check code
	 */
	@Override
	@SuppressWarnings("unchecked")
	public boolean check(String code) {
		
		List<Major> list = null;
		
		// Build session
		Session session = this.getCurrentSession();
		
		// statement 
		String sql = "from Major where code = '" + code + "' ";
		
		// Build query
		Query query = session.createQuery(sql);
		list = query.list();
		if (list.size() > 0) {
			return true;
		}
		return false;
	}

}
