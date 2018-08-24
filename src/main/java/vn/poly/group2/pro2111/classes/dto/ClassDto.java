package vn.poly.group2.pro2111.classes.dto;

public class ClassDto {

	private Long id;
	private Long idClass;

	private String code;

	private Long majorid;

	private Long lecturerid;

	private String majorName1;

	private String lecturerName1;

	public ClassDto() {
		super();
	}

	public String getMajorname() {
		return majorname;
	}

	public void setMajorname(String majorname) {
		this.majorname = majorname;
	}

	private String majorname;

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

	public Long getLecturerid() {
		return lecturerid;
	}

	public void setLecturerid(Long lecturerid) {
		this.lecturerid = lecturerid;
	}

	public Long getMajorid() {
		return majorid;
	}

	public void setMajorid(Long majorid) {
		this.majorid = majorid;
	}

	public String getMajorName1() {
		return majorName1;
	}

	public void setMajorName1(String majorName1) {
		this.majorName1 = majorName1;
	}

	public String getLecturerName1() {
		return lecturerName1;
	}

	public void setLecturerName1(String lecturerName1) {
		this.lecturerName1 = lecturerName1;
	}

	public Long getIdClass() {
		return idClass;
	}

	public void setIdClass(Long idClass) {
		this.idClass = idClass;
	}
	
	

}
