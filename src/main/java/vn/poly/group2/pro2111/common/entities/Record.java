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
@Table(name = "RECORD")
public class Record {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "LECTURERID")
	private Long lecturerId;

	@Column(name = "TYPERECORD")
	private boolean typeRecord;

	@Column(name = "DATERECORD")
	private String dateRecord;

	@Column(name = "NOTE")
	private String note;

	@ManyToOne
	@JoinColumn(name = "LECTURERID", insertable = false, updatable = false)
	private Lecturer lecturer;

	public Record() {
		super();
	}

	public boolean isTypeRecord() {
		return typeRecord;
	}

	public void setTypeRecord(boolean typeRecord) {
		this.typeRecord = typeRecord;
	}

	public Long getLecturerId() {
		return lecturerId;
	}

	public void setLecturerId(Long lecturerId) {
		this.lecturerId = lecturerId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDateRecord() {
		return dateRecord;
	}

	public void setDateRecord(String dateRecord) {
		this.dateRecord = dateRecord;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Lecturer getLecturer() {
		return lecturer;
	}

	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}

}
