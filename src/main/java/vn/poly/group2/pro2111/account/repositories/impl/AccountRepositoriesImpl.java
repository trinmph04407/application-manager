package vn.poly.group2.pro2111.account.repositories.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import vn.poly.group2.pro2111.account.repositories.AccountRepository;
import vn.poly.group2.pro2111.common.bases.BaseRepository;
import vn.poly.group2.pro2111.common.entities.Account;
import vn.poly.group2.pro2111.common.entities.Lecturer;

@Repository
public class AccountRepositoriesImpl extends BaseRepository implements AccountRepository {
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Account> getList(){
		List<Account> list = this.getCurrentSession().createQuery("from Account").list();
		return list;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Account> select(Long lecturerId, String username, int offset, int limit) {

		StringBuilder queryStb = new StringBuilder("from Account");


		if (StringUtils.isNoneBlank(username) && lecturerId != null) {
			queryStb.append(" where lecturerId = :lecturerId AND username like :username ");
		} 
		else if (lecturerId != null) {
			queryStb.append(" where lecturerId = :lecturerId ");
		} else if (StringUtils.isNotBlank(username)) {
			queryStb.append(" where username like :username ");
		}

		Query query = this.getCurrentSession().createQuery(queryStb.toString());
		if (lecturerId != null) {
            query.setLong("lecturerId", lecturerId);
        }
		if (StringUtils.isNotBlank(username)) {
			query.setString("username", username);
		}

		return query.setFirstResult(offset).setMaxResults(limit).list();
	}

	@Override
	public Long count(Long lecturerId, String username) {
		StringBuilder queryStb = new StringBuilder("select count(1) from Account");
		if (StringUtils.isNoneBlank(username) && lecturerId != null) {
			queryStb.append(" where lecturerId = :lecturerId AND username like :username ");
		} 
		else if (lecturerId != null) {
			queryStb.append(" where lecturerId = :lecturerId ");
		} else if (StringUtils.isNotBlank(username)) {
			queryStb.append(" where username like :username ");
		}

		Query query = this.getCurrentSession().createQuery(queryStb.toString());
		if (lecturerId != null) {
            query.setLong("lecturerId", lecturerId);
        }
		if (StringUtils.isNotBlank(username)) {
			query.setString("username", username);
		}

		return (Long) query.uniqueResult();
	}

	@Override
	public Long insert(Account account) {

		return (Long) super.insert(account);
	}
	
	@Override
	public Long update(Account account) {

		return (Long) super.update(account);
	}



	@Override
	public Account getIdAccount(Long id) {
		Account account = null;
		try {
			account = this.getCurrentSession().get(Account.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return account;
	}
	
	@Override
	public Account getUsername(String username) {
		Account account = null;
		try {
			account = this.getCurrentSession().get(Account.class, username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return account;
	}
	
	
	@Override
	public boolean removeUsername(String username) {
		Session session = this.getCurrentSession();
		Account account = session.get(Account.class, username);
		session.delete(account);
		return true;
	}
	
	
	@Override
	public boolean remove(Long id) {
		Session session = this.getCurrentSession();
		Account account = session.get(Account.class, id);
		session.delete(account);
		return true;
	}
	
	
	@Override
	@SuppressWarnings("unchecked")
	public boolean checkId(Long id) {
		List<Account> list = null;
		Query query = this.getCurrentSession().createQuery("from Account where lecturerId = '" + id + "' ");
		list = query.list();
		if (list.size() > 0) {
			return true;
		}
		return false;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public boolean checkUsername(String username) {
		List<Account> list = null;
		Query query = this.getCurrentSession().createQuery("from Account where username = '" + username + "' ");
		list = query.list();
		if (list.size() > 0) {
			return true;
		}
		return false;
	}

}
