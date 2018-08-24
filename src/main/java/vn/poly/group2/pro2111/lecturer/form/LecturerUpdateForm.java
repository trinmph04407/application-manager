package vn.poly.group2.pro2111.lecturer.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class LecturerUpdateForm {

	@NotEmpty(message = "{errors.notEmpty}")
	@Size(max = 50)
	private String code;

	@NotEmpty(message = "{errors.notEmpty}")
	@Size(max = 50)
	private String name;

	private String photo;
	
	@NotEmpty(message = "{errors.notEmpty}")
	private String email;
	
	@NotEmpty(message = "{errors.notEmpty}")
	private String phone;
	
	@NotNull(message = "{errors.notEmpty}")
	private float salary;

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
