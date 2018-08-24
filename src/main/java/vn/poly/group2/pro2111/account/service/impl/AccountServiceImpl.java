package vn.poly.group2.pro2111.account.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.tools.ant.taskdefs.email.Mailer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import vn.poly.group2.pro2111.account.dto.AccLecturerDto;
import vn.poly.group2.pro2111.account.dto.AccountDto;
import vn.poly.group2.pro2111.account.repositories.AccountRepository;
import vn.poly.group2.pro2111.account.repositories.LecturerRepository;
import vn.poly.group2.pro2111.account.service.AccountService;
import vn.poly.group2.pro2111.common.bases.BaseService;
import vn.poly.group2.pro2111.common.dto.ListDataDto;
import vn.poly.group2.pro2111.common.dto.ListPagingDto;
import vn.poly.group2.pro2111.common.entities.Account;
import vn.poly.group2.pro2111.common.entities.Lecturer;
import vn.poly.group2.pro2111.common.utils.DataTransformUtil;

@Service
public class AccountServiceImpl extends BaseService implements AccountService {
	@Autowired
	@Qualifier("accLecturerRepositoryImpl")
	LecturerRepository lecturerRepository;

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	private  MailSender mailSender;
	
	@Override
	public ListDataDto<AccountDto> getListAccount(Long lecturerId, String username, Long pn) {
		ListDataDto<AccountDto> listDataDto = new ListDataDto<AccountDto>();

		// Calculating paging
		ListPagingDto pagingDto = listDataDto.getPaging();
		pagingDto.setCurrentPage(pn);

		// Count record
		Long totalRecords = accountRepository.count(lecturerId, username);
		pagingDto.setTotalRecords(totalRecords);

		if (totalRecords.intValue() == 0) {
			return listDataDto;
		}

		List<Account> accountList = accountRepository.select(lecturerId, username, pagingDto.getOffset(),
				pagingDto.getLimit());

		// cast account dto with lecturer entity
		List<AccountDto> accountDtoList = new ArrayList<>();
		for (Account account : accountList) {

			AccountDto accountDto = (AccountDto) DataTransformUtil.transform(account, AccountDto.class);

			Lecturer lecturer = account.getLecturer();
			accountDto.setLecturerId(lecturer.getId());
			accountDto.setLecturerCode(lecturer.getCode());
			accountDto.setLecturerName(lecturer.getName());

			accountDtoList.add(accountDto);
		}
		// Set list into data dto
		listDataDto.setList(accountDtoList);

		// Return data
		return listDataDto;
	}

	@Override
	public Long create(AccountDto accountDto) {
		Account account = (Account) DataTransformUtil.transform(accountDto, Account.class);

		return accountRepository.insert(account);
	}

	@Override
	public AccountDto getIdAccount(Long id) {
		Account account = accountRepository.getIdAccount(id);
		return (AccountDto) DataTransformUtil.transform(account, AccountDto.class);
	}
	

	@Override
	public boolean remove(Long id) {
		AccountDto accountDto = new AccountDto();
		Account account = accountRepository.getIdAccount(id);
		account.setUsername(accountDto.getUsername());
		return accountRepository.remove(id);
	}
	
	@Override
	public AccountDto getUsername(String username) {
		Account account = accountRepository.getUsername(username);
		return (AccountDto) DataTransformUtil.transform(account, AccountDto.class);
	}
	@Override
	public boolean removeUsername(String username) {
		AccountDto accountDto = new AccountDto();
		Account account = accountRepository.getUsername(username);
		account.setUsername(accountDto.getUsername());
		return accountRepository.removeUsername(username);
	}

	@Override
	public List<AccLecturerDto> lecturers(Long id) {
		List<Lecturer> lecturerList = lecturerRepository.search(id);

		List<AccLecturerDto> lecturerDtoList = new ArrayList<>();
		for (Lecturer lecturer : lecturerList) {
			lecturerDtoList.add((AccLecturerDto) DataTransformUtil.transform(lecturer, AccLecturerDto.class));
		}

		return lecturerDtoList;
	}

	@Override
	public Long update(AccountDto accountDto) {

		Account entity = accountRepository.getIdAccount(accountDto.getId());
		
		entity.setLecturerId(accountDto.getLecturerId());
		entity.setUsername(accountDto.getUsername());
		entity.setPassword(accountDto.getPassword());
		entity.setRole(accountDto.getRole());
		return accountRepository.update(entity);

	}

	@Override
	public boolean reset(AccountDto accountDto) {
		Account entity = accountRepository.getIdAccount(accountDto.getId());
		entity.setPassword(accountDto.getRspassword());
		accountRepository.update(entity);
		return true;
	}
	
	@Override
	public boolean checkId(Long id) {
		
		return accountRepository.checkId(id);
	}

	@Override
	public boolean checkUsername(String username) {
		
		return accountRepository.checkUsername(username);
	}
	
	
	 @Override
	    public void sendEmail(String email) {
	        SimpleMailMessage message = new SimpleMailMessage();

	        message.setFrom("tuongnpph04601@fpt.edu.vn");
	        message.setTo(email);
	        message.setSubject("Thông báo ");
	        message.setText("Password của bạn đã được reset: 123456");
	        mailSender.send(message);
	    }

}
