package vn.poly.group2.pro2111.account.form;

import javax.validation.constraints.Size;

public class AccountUpdateForm {
	private Long id;
	private String username;
	private String email;
	
	@Size(min = 5,message = "Mật khẩu tối thiểu 5 ký tự")
	private String password;
	private int role;
	private Long lecturerId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public Long getLecturerId() {
		return lecturerId;
	}
	public void setLecturerId(Long lecturerId) {
		this.lecturerId = lecturerId;
	}
	
	
	
}
