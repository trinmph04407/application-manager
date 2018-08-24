package vn.poly.group2.pro2111.account.dto;


public class AccountDto {
	private Long id;
	private Long lecturerId;
	private String email;
	private String lecturerCode;
	private String lecturerName;
	private String username;
	private String password;
	private String rspassword="123456";
	private int role;
	
	


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRspassword() {
		return rspassword;
	}

	public void setRspassword(String rspassword) {
		this.rspassword = rspassword;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	
	public String getLecturerCode() {
		return lecturerCode;
	}

	public void setLecturerCode(String lecturerCode) {
		this.lecturerCode = lecturerCode;
	}

	public String getLecturerName() {
		return lecturerName;
	}

	public void setLecturerName(String lecturerName) {
		this.lecturerName = lecturerName;
	}



}
