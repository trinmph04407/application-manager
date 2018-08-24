package vn.poly.group2.pro2111.classes.repositories.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.poly.group2.pro2111.classes.repositories.ClassRepository;
import vn.poly.group2.pro2111.common.bases.BaseRepository;
import vn.poly.group2.pro2111.common.entities.Clasess;
import vn.poly.group2.pro2111.common.entities.Student;

@Transactional
@Repository
public class ClassRepositoryImpl extends BaseRepository implements ClassRepository {

	@Override
	public Long count(Long majorid, Long lecturerid) {
		StringBuilder queryStb = new StringBuilder("select count(1) from Clasess");

		if (majorid != null && lecturerid != null) {
			queryStb.append(" where majorid = :majorid and lecturerid = :lecturerid");
		} else if (lecturerid != null) {
			queryStb.append(" where lecturerid like :lecturerid ");
		} else if (majorid != null) {
			queryStb.append(" where majorid = :majorid ");
		}
		Query query = this.getCurrentSession().createQuery(queryStb.toString());

		if (majorid != null) {
			query.setLong("majorid", majorid);
		}

		if (lecturerid != null) {
			query.setLong("lecturerid", lecturerid);
		}

		return (Long) query.uniqueResult();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Clasess> select(Long majorid, Long lecturerid, int offset, int limit) {

		StringBuilder queryStb = new StringBuilder("from Clasess ");

		if (majorid != null && lecturerid != null) {
			queryStb.append(" where majorid = :majorid and lecturerid = :lecturerid");
		} else if (lecturerid != null) {
			queryStb.append(" where lecturerid like :lecturerid ");
		} else if (majorid != null) {
			queryStb.append(" where majorid = :majorid ");
		}

		Query query = this.getCurrentSession().createQuery(queryStb.toString());

		if (majorid != null) {
			query.setLong("majorid", majorid);
		}

		if (lecturerid != null) {
			query.setLong("lecturerid", lecturerid);
		}

		return query.setFirstResult(offset).setMaxResults(limit).list();
	}

	@Override
	public Clasess select(Long id) {
		Clasess clasess = this.getCurrentSession().get(Clasess.class, id);
		return clasess;
	}

	@Override
	public boolean insert(Clasess clasess) {
		super.insert(clasess);
		return true;
	}

	@Override
	public boolean update(Clasess clasess) {
		super.update2(clasess);
		return true;
	}

	@Override
	public boolean remove(Long id) {
		Session session = this.getCurrentSession();
		Clasess clasess = session.get(Clasess.class, id);
		session.delete(clasess);
		return true;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean checkId(String code) {
		List<Clasess> list = null;
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Clasess where code = '" + code + "' ";
		Query query = session.createQuery(hql);
		list = query.list();
		if (list.size() > 0) {
			return true;
		}
		return false;
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<Student> listStudent(){
		List<Student> list =this.getCurrentSession().createSQLQuery("from Student").list();
		return 	 list;
	}

}
