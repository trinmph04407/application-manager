package vn.poly.group2.pro2111.lecturer.repositories.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.poly.group2.pro2111.common.bases.BaseRepository;
import vn.poly.group2.pro2111.common.entities.Lecturer;
import vn.poly.group2.pro2111.lecturer.repositories.LecturerRepository;

@Transactional
@Repository
public class LecturerRepositoryImpl extends BaseRepository implements LecturerRepository {

	@Override
	public Long count(String code, String name) {

		StringBuilder queryStb = new StringBuilder("select count(1) from Lecturer");

		if (StringUtils.isNoneBlank(code, name)) {
			queryStb.append(" where code like :code and name like :name ");
		} else if (StringUtils.isNotBlank(code)) {
			queryStb.append(" where code like :code ");
		} else if (StringUtils.isNotBlank(name)) {
			queryStb.append(" where name like :name ");
		}

		Query query = this.getCurrentSession().createQuery(queryStb.toString());

		if (StringUtils.isNotBlank(code)) {
			query.setString("code", "%" + code + "%");
		}
		if (StringUtils.isNotBlank(name)) {
			query.setString("name", "%" + name + "%");
		}

		return (Long) query.uniqueResult();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Lecturer> select(String code, String name, int offset, int limit) {

		StringBuilder queryStb = new StringBuilder("from Lecturer");

		if (StringUtils.isNoneBlank(code, name)) {
			queryStb.append(" where code like :code and name like :name ");
		} else if (StringUtils.isNotBlank(code)) {
			queryStb.append(" where code like :code ");
		} else if (StringUtils.isNotBlank(name)) {
			queryStb.append(" where name like :name ");
		}

		Query query = this.getCurrentSession().createQuery(queryStb.toString());

		if (StringUtils.isNotBlank(code)) {
			query.setString("code", "%" + code + "%");
		}
		if (StringUtils.isNotBlank(name)) {
			query.setString("name", "%" + name + "%");
		}

		return query.setFirstResult(offset).setMaxResults(limit).list();
	}

	@Override
	public boolean deleteLecturer(Long id) {
		Session session = this.getCurrentSession();
		Lecturer lecturer = session.get(Lecturer.class, id);
		session.delete(lecturer);
		return true;
	}

	@Override
	public boolean insertLecturer(Lecturer lecturer) {
		super.insert(lecturer);
		return true;
	}

	@Override
	public Lecturer getLecturerId(Long id) {
		Lecturer lecturer =  this.getCurrentSession().get(Lecturer.class, id);
        return lecturer;
	}

	@Override
	public boolean editLecturer(Lecturer lecturer) {
		super.update2(lecturer);
		return true;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean checkId(String code) {
		List<Lecturer> list = null;
		Session session = this.getCurrentSession();
		String hql = "from Lecturer where code = '" + code + "' ";
		Query query = session.createQuery(hql);
		list = query.list();
		if (list.size() > 0) {
			return true;
		}
		return false;
	}

}
