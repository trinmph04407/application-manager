package vn.poly.group2.pro2111.classes.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class ClassCreateForm {
	
	@NotEmpty(message = "{errors.notEmpty}")
	@Size(max = 50)
	private String code;
	
	@NotNull(message = "{errors.notEmpty}")
	private Long majorid;
	
	@NotNull(message = "{errors.notEmpty}")
	private Long lecturerid;

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
