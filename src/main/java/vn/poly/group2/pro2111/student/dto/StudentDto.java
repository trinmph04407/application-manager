package vn.poly.group2.pro2111.student.dto;

import vn.poly.group2.pro2111.common.entities.Clasess;
import vn.poly.group2.pro2111.common.entities.Major;

public class StudentDto {
	private Long id;
	private String code;
	private String name;
	private String photo;
	private String phone;
	private String email;
	private String note;
	private Long classid;
	private Clasess clasess;
	private Long majorid;
	private Major major;

	public StudentDto() {
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

	public Clasess getClasess() {
		return clasess;
	}

	public void setClasess(Clasess clasess) {
		this.clasess = clasess;
	}

	public Long getMajorid() {
		return majorid;
	}

	public void setMajorid(Long majorid) {
		this.majorid = majorid;
	}

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

}
