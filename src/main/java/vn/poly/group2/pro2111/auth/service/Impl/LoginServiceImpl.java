package vn.poly.group2.pro2111.auth.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.poly.group2.pro2111.auth.repositories.LoginRepository;
import vn.poly.group2.pro2111.auth.service.LoginService;
import vn.poly.group2.pro2111.common.bases.BaseService;

@Service
public class LoginServiceImpl extends BaseService implements LoginService {
	@Autowired
	LoginRepository loginRepository;

	@Override
	public boolean checkAdmin(String username, String password,int role) {
		
		return loginRepository.checkAdmin(username, password);
	}

	@Override
	public boolean checkLecturer(String username, String password,int role) {
		// TODO Auto-generated method stub
		return loginRepository.checkLecturer(username, password);
	}

}
