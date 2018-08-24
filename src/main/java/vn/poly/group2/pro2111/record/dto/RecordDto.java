/*
 *@Author P.Tuong
 *@Date Jul 17, 2018
 *@Version 1.0
*/
package vn.poly.group2.pro2111.record.dto;


public class RecordDto {
	private Long id;
	private Long lecturerId;
	private String lecturerName;
	private boolean typeRecord;
	private String dateRecord;
	private String note;
	
	

	
	public String getLecturerName() {
		return lecturerName;
	}

	public void setLecturerName(String lecturerName) {
		this.lecturerName = lecturerName;
	}

	
	public RecordDto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public Long getLecturerId() {
		return lecturerId;
	}

	public void setLecturerId(Long lecturerId) {
		this.lecturerId = lecturerId;
	}

	public String getlecturerName() {
		return lecturerName;
	}

	public void setlecturerName(String lecturerName) {
		this.lecturerName = lecturerName;
	}

	public boolean isTypeRecord() {
		return typeRecord;
	}

	public void setTypeRecord(boolean typeRecord) {
		this.typeRecord = typeRecord;
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

}
