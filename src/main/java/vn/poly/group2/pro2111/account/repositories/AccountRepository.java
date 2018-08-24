package vn.poly.group2.pro2111.account.repositories;

import java.util.List;

import vn.poly.group2.pro2111.common.entities.Account;
import vn.poly.group2.pro2111.common.entities.Lecturer;

public interface AccountRepository {
	public List<Account> getList();
	
	public List<Account> select(Long lecturerId, String username, int offset, int limit);

	public Long count(Long lecturerId, String username);

	public Long insert(Account account);
	
	public boolean removeUsername(String username);
	public Account getUsername(String username);
	
	public Account getIdAccount(Long id);
	
	public Long update(Account account);
	
	public boolean remove(Long id);
	
	public boolean checkId(Long id);
	
	public boolean checkUsername(String username);
	
}
