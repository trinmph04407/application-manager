/**
 * 
 */
package vn.poly.group2.pro2111.subject.form;


/**
 * Subject search form
 * 
 * @author minht
 * 
 */
public class SubjectSearchForm {
	
	/*=====================================================================================================
     *===== PRIVATE PROPERTIES                                                                        =====
     *=====================================================================================================*/
	
	/**
     * SUBJECT.NAME
     */
	private String name;
	
	/**
     * SUBJECT.LECTURERID
     */
	private Long lecturerId;
	
	/**
     * SUBJECT.MAJORID
     */
	private Long majorId;
		
	private Long pn;

	/*=====================================================================================================
     *===== CONSTRUCTOR METHOD                                                                        =====
     *=====================================================================================================*/
	
	/**
	 * Default constructor
	 */
	public SubjectSearchForm() {
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
	 * @return the pn
	 */
	public Long getPn() {
		return pn;
	}

	/**
	 * @param pn the pn to set
	 */
	public void setPn(Long pn) {
		this.pn = pn;
	}

	
	
	
}
