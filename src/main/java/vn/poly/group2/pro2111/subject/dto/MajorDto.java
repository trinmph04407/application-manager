/**
 * 
 */
package vn.poly.group2.pro2111.subject.dto;

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
	
	
}
