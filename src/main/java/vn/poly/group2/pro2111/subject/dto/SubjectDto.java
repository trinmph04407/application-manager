/**
 * 
 */
package vn.poly.group2.pro2111.subject.dto;

/**
 * SUBJECT DTO
 * 
 * @author minht
 * 
 */
public class SubjectDto {
	
	/*=====================================================================================================
     *===== PRIVATE PROPERTIES                                                                        =====
     *=====================================================================================================*/
	
	/**
     * SUBJECT.ID
     */
	private Long id;
	
	/**
     * SUBJECT.CODE
     */
	private String code;
	
	/**
     * SUBJECT.NAME
     */
	private String name;
	
	/**
     * MAJOR.ID
     */
	private Long majorId;
	
	/**
     * MAJOR.NAME
     */
	private String majorName;
	
	/**
     * LECTURER.NAME
     */
	private String lecturerName;
	
	/**
     * LECTURER.ID
     */
	private Long lecturerId;
	
	/*=====================================================================================================
     *===== GETTER & SETTER                                                                         =====
     *=====================================================================================================*/
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the majorId
	 */
	public Long getMajorId() {
		return majorId;
	}

	/**
	 * @param majorId the majorId to set
	 */
	public void setMajorId(Long majorId) {
		this.majorId = majorId;
	}

	/**
	 * @return the lecturerId
	 */
	public Long getLecturerId() {
		return lecturerId;
	}

	/**
	 * @param lecturerId the lecturerId to set
	 */
	public void setLecturerId(Long lecturerId) {
		this.lecturerId = lecturerId;
	}

	/**
	 * @return the majorName
	 */
	public String getMajorName() {
		return majorName;
	}

	/**
	 * @param majorName the majorName to set
	 */
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	/**
	 * @return the lecturerName
	 */
	public String getLecturerName() {
		return lecturerName;
	}

	/**
	 * @param lecturerName the lecturerName to set
	 */
	public void setLecturerName(String lecturerName) {
		this.lecturerName = lecturerName;
	}	
	
}
