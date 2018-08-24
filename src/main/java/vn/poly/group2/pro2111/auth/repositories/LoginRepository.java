package vn.poly.group2.pro2111.auth.repositories;

public interface LoginRepository {

	public boolean checkAdmin(String username, String password);
	
	public boolean checkLecturer(String username, String password);
}
