/*
 *@Author P.Tuong
 *@Date Jul 17, 2018
 *@Version 1.0
*/
package vn.poly.group2.pro2111.record.form;

import org.hibernate.validator.constraints.NotEmpty;

public class RecordUpdateForm {
	private Long id;
	private Long lecturerId;
	private String typeRecord;
	
	@NotEmpty(message = "{errors.notEmpty}")
	private String dateRecord;
	private String note;
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
	public String getTypeRecord() {
		return typeRecord;
	}
	public void setTypeRecord(String typeRecord) {
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
