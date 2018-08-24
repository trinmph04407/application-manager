package vn.poly.group2.pro2111.student.form;

import org.hibernate.validator.constraints.NotEmpty;

public class StudentCreateForm {
	private Long id;
	@NotEmpty(message = "{errors.notEmpty}")
	private String code;
	@NotEmpty(message = "{errors.notEmpty}")
	private String name;
	@NotEmpty(message = "{errors.notEmpty}")
	private String phone;
	@NotEmpty(message = "{errors.notEmpty}")
	private String photo;
	@NotEmpty(message = "{errors.notEmpty}")
	private String email;
	@NotEmpty(message = "{errors.notEmpty}")
	private String note;
	private Long classid;
	private Long majorid;

	public StudentCreateForm() {
		super();
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Long getClassid() {
		return classid;
	}

	public void setClassid(Long classid) {
		this.classid = classid;
	}

	public Long getMajorid() {
		return majorid;
	}

	public void setMajorid(Long majorid) {
		this.majorid = majorid;
	}

}
