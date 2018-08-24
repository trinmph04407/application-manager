package vn.poly.group2.pro2111.account.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


public class AccountCreateForm {
	private Long lecturerId;
	
	@NotNull(message = "{errors.notEmpty}")
	@NotEmpty(message = "{errors.notEmpty}")
	@Size(min = 5, max = 24,message = "Tài khoản phải trên 5 ký tự")
	private String username;

	
	@NotNull(message = "{errors.notEmpty}")
	@NotEmpty(message = "{errors.notEmpty}")
	@Size(min = 5,message = "Mật khẩu phải trên 5 ký tự")
	private String password;
	
	private int role;

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
