package vn.poly.group2.pro2111.student.form;

import vn.poly.group2.pro2111.common.entities.Clasess;

public class StudentListForm {
	private Long id;
	private String code;
	private String name;
	private String phone;
	private String photo;
	private String email;
	private String node;
	private Clasess clasess;

	public StudentListForm() {
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

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	public Clasess getClasess() {
		return clasess;
	}

	public void setClasess(Clasess clasess) {
		this.clasess = clasess;
	}

	

}
