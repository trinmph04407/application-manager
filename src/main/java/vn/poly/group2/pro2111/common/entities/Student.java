package vn.poly.group2.pro2111.common.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "CODE")
	private String code;

	@Column(name = "NAME")
	private String name;

	@Column(name = "PHOTO")
	private String photo;

	@Column(name = "PHONE")
	private String phone;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "NOTE")
	private String note;

	@Column(name = "CLASSID")
	private Long classid;

	@Column(name = "MAJORID")
	private Long majorid;

	@ManyToOne
	@JoinColumn(name = "CLASSID", insertable = false, updatable = false)
	private Clasess clasess;

	@ManyToOne
	@JoinColumn(name = "MAJORID", insertable = false, updatable = false)
	private Major major;

	public Student() {
		super();
	}

	public Student(Long id, String code, String name, String phone, String photo, String email, String note,
			Long classid, Long majorid, Clasess clasess, Major major) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.phone = phone;
		this.photo = photo;
		this.email = email;
		this.note = note;
		this.classid = classid;
		this.majorid = majorid;
		this.clasess = clasess;
		this.major = major;
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

	public Clasess getClasess() {
		return clasess;
	}

	public void setClasess(Clasess clasess) {
		this.clasess = clasess;
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

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

}
