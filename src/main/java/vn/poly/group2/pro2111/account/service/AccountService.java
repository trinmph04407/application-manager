package vn.poly.group2.pro2111.account.service;

import java.util.List;

import vn.poly.group2.pro2111.account.dto.AccLecturerDto;
import vn.poly.group2.pro2111.account.dto.AccountDto;
import vn.poly.group2.pro2111.common.dto.ListDataDto;
import vn.poly.group2.pro2111.common.entities.Lecturer;

public interface AccountService {
	public ListDataDto<AccountDto> getListAccount(Long lecturerId, String username, Long pn);

	public List<AccLecturerDto> lecturers(Long id);

	public Long create(AccountDto accountDto);
	
	public boolean removeUsername(String username);
	
	public AccountDto getUsername(String username);

	public AccountDto getIdAccount(Long id);
	
	public Long update(AccountDto accountDto);
	
	public boolean remove(Long id);
	
	public boolean reset(AccountDto accountDto);
	
	public boolean checkId(Long id);
	
	public boolean checkUsername(String username);
	
	 public void sendEmail(String email);
	
}
