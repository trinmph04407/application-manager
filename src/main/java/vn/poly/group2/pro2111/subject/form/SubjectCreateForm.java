/**
 * 
 */
package vn.poly.group2.pro2111.subject.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Subject create form
 * 
 * @author minht
 * 
 */
public class SubjectCreateForm {
	
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
	@NotEmpty(message = "{errors.notEmpty}")
	@Size(max = 50,message = "tối đa 50 kí tự")
	private String code;
	
	/**
     * SUBJECT.NAME
     */
	@NotEmpty(message = "{errors.notEmpty}")
	@Size(max = 200,message = "tối đa 200 kí tự")
	private String name;
	
	/**
     * SUBJECT.MAJORID
     */
	@NotNull(message = "{errors.notEmpty}")
	private Long majorId;
	
	/**
     * SUBJECT.LECTURERID
     */
	@NotNull(message = "{errors.notEmpty}")
	private Long lecturerId;
	
	/*=====================================================================================================
     *===== CONSTRUCTOR METHOD                                                                        =====
     *=====================================================================================================*/
	
	/**
	 * Default constructor
	 */
	public SubjectCreateForm() {
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
	
	
}
