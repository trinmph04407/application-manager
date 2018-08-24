/**
 * 
 */
package vn.poly.group2.pro2111.major.dto;

/**
 * Lecturer DTO
 * 
 * @author minht
 */
public class LecturerDto {
	
	/*=====================================================================================================
     *===== PRIVATE PROPERTIES                                                                        =====
     *=====================================================================================================*/
	
	/**
     * LECTURER.ID
     */
	private Long id;
	
	/**
     * LECTURER.CODE
     */
	private String code;
	
	/**
     * LECTURER.NAME
     */
	private String name;

	/**
     * LECTURER.PHOTO
     */	
	private String photo;

	/**
     * LECTURER.EMAIL
     */
	private String email;

	/**
     * LECTURER.PHONE
     */
	private String phone;

	/**
     * LECTURER.SALARY
     */
	private float salary;
	
	/*=====================================================================================================
     *===== CONSTRUCTOR METHOD                                                                        =====
     *=====================================================================================================*/

	/**
	 * Default constructor
	 */
	public LecturerDto() {
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
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the salary
	 */
	public float getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	
}
