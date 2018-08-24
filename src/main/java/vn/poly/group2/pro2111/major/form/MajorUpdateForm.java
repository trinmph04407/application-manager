/**
 * 
 */
package vn.poly.group2.pro2111.major.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 *  Major update form
 *  
 * @author minht
 * 
 */
public class MajorUpdateForm {

	/*=====================================================================================================
     *===== PRIVATE PROPERTIES                                                                        =====
     *=====================================================================================================*/
	
	/**
     * MAJOR.CODE
     */
	private String code;
	
	/**
     * MAJOR.NAME
     */
	@NotEmpty(message = "{errors.notEmpty}")
	@Size(max = 200,message = "tối đa 200 kí tự")
	private String name;
	
	/**
     * MAJOR.LECTURERID
     */
	@NotNull(message = "{errors.notEmpty}")
	private Long lecturerId;

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
	 * Default constructor
	 */
	public MajorUpdateForm() {
		super();
	}
	
	/*=====================================================================================================
     *===== GETTER & SETTER                                                                           =====
     *=====================================================================================================*/
	
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
