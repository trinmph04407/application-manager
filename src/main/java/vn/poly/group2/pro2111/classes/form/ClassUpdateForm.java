/*
 *@Author P.Tuong
 *@Date Jul 13, 2018
 *@Version 1.0
*/
package vn.poly.group2.pro2111.classes.form;

import javax.validation.constraints.NotNull;

public class ClassUpdateForm {
	
	private String code;
	
	@NotNull(message = "{errors.notEmpty}")
	private String majorid;
	
	@NotNull(message = "{errors.notEmpty}")
	private String lecturerid;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMajorid() {
		return majorid;
	}

	public void setMajorid(String majorid) {
		this.majorid = majorid;
	}

	public String getLecturerid() {
		return lecturerid;
	}

	public void setLecturerid(String lecturerid) {
		this.lecturerid = lecturerid;
	}

}
