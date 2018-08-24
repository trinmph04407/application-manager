package vn.poly.group2.pro2111.student.repositories.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.poly.group2.pro2111.common.bases.BaseRepository;
import vn.poly.group2.pro2111.common.entities.Clasess;
import vn.poly.group2.pro2111.common.entities.Major;
import vn.poly.group2.pro2111.common.entities.Student;
import vn.poly.group2.pro2111.student.repositories.StudentRepository;

@Repository
public class StudentRepositoryImpl extends BaseRepository implements StudentRepository {

	@Override
	public Long count(String code, String name) {
		StringBuilder queryStb = new StringBuilder("select count(*) from Student ");

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> select(String code, String name, int offset, int limit) {
		StringBuilder queryStb = new StringBuilder("from Student ");

		if (StringUtils.isNoneBlank(code, name)) {
			queryStb.append(" where code like :code and name like :name ");
		} else if (StringUtils.isNotBlank(code)) {
			queryStb.append(" where code like :code ");
		} else if (StringUtils.isNotBlank(name)) {
			queryStb.append(" where name like :name ");
		}
		queryStb.append(" order by code");
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
	public Student selectStudent(Long id) {
		Student student = this.getCurrentSession().get(Student.class, id);
		return student;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean checkId(String code) {
		List<Student> list = null;
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Student where code = '" + code + "' ";
		Query query = session.createQuery(hql);
		list = query.list();
		if (list.size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean insert(Student student) {
		super.insert(student);
		return true;
	}

	@Override
	public boolean update(Student student) {
		super.update2(student);
		return true;
	}

	@Override
	public boolean remove(Long id) {
		Session session = this.getCurrentSession();
		Student student = session.get(Student.class, id);
		session.delete(student);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Clasess> listClass() {
		return this.getCurrentSession().createQuery("From Clasess").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Major> listMajor() {
		return this.getCurrentSession().createQuery("From Major").list();
	}

}
