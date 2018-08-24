package vn.poly.group2.pro2111.lecturer.dto;

public class LecturerDto {

	private Long id;

	private String code;

	private String name;

	private String photo;

	private String email;

	private String phone;

	private float salary;

	public LecturerDto() {
		super();
	}

	public LecturerDto(Long id, String code, String name, String photo, String email, String phone, float salary) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.photo = photo;
		this.email = email;
		this.phone = phone;
		this.salary = salary;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

}
