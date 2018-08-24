/**
 * 
 */
package vn.poly.group2.pro2111.major.dto;

/**
 * Major DTO
 * 
 * @author minht
 * 
 */
public class MajorDto {
	
    /*=====================================================================================================
     *===== PRIVATE PROPERTIES                                                                        =====
     *=====================================================================================================*/
	
	/**
     * MAJOR.ID
     */
	private Long id;
	
	/**
     * MAJOR.CODE
     */
	private String code;
	
	/**
     * MAJOR.NAME
     */
	private String name;
	
	/**
     * LECTURER.NAME
     */
	private String lecturerName;
	
	/**
     * LECTURER.ID
     */
	private Long lecturerId;
	
    /*=====================================================================================================
     *===== CONSTRUCTOR METHOD                                                                        =====
     *=====================================================================================================*/
	
	/**
	 * Default constructor
	 */
	public MajorDto() {
		super();
	}
	
    /*=====================================================================================================
     *===== GETTER & SETTER                                                                           =====
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
	
	
	
	
}
