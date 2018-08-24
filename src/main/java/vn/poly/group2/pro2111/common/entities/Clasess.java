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
@Table(name = "CLASS")
public class Clasess {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "CODE")
	private String code;

	@Column(name = "MAJORID")
	private Long majorid;

	@Column(name = "LECTURERID")
	private Long lecturerid;

	@ManyToOne
	@JoinColumn(name = "MAJORID", insertable = false, updatable = false)
	private Major major;

	@ManyToOne
	@JoinColumn(name = "LECTURERID", insertable = false, updatable = false)
	private Lecturer lecturer;

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public Lecturer getLecturer() {
		return lecturer;
	}

	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}

	public Clasess() {
		super();
	}

	public Clasess(Long id, String code, Long majorid, Long lecturerid) {
		super();
		this.id = id;
		this.code = code;
		this.majorid = majorid;
		this.lecturerid = lecturerid;
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

	public Long getMajorid() {
		return majorid;
	}

	public void setMajorid(Long majorid) {
		this.majorid = majorid;
	}

	public Long getLecturerid() {
		return lecturerid;
	}

	public void setLecturerid(Long lecturerid) {
		this.lecturerid = lecturerid;
	}

}
