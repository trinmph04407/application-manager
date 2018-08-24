package vn.poly.group2.pro2111.auth.repositories.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import vn.poly.group2.pro2111.auth.repositories.LoginRepository;
import vn.poly.group2.pro2111.common.bases.BaseRepository;
import vn.poly.group2.pro2111.common.entities.Account;

@Repository
public class LoginRepositoryImpl extends BaseRepository implements LoginRepository {

	@SuppressWarnings("unchecked")
	@Override
	public boolean checkAdmin(String username, String password) {
		int role_admin = 1;
		String sql = "FROM Account WHERE username = '" + username + "' AND password = '" + password + "' AND role = '"
				+ role_admin + "'";
		List<Account> list = this.getCurrentSession().createQuery(sql).list();
		if (list.size() > 0) {
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean checkLecturer(String username, String password) {
		int role_user = 0;
		String sql = "FROM Account WHERE username = '" + username + "' AND password = '" + password + "' AND role = '"
				+ role_user + "'";
		List<Account> list = this.getCurrentSession().createQuery(sql).list();
		if (list.size() > 0) {
			return true;
		}
		return false;
	}

}
