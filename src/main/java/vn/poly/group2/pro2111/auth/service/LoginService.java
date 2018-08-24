package vn.poly.group2.pro2111.auth.service;

public interface LoginService {
	public boolean checkAdmin(String username, String password, int role);
	
	public boolean checkLecturer(String username, String password, int role);
}
