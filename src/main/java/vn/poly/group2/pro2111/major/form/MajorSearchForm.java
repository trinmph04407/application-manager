/**
 * 
 */
package vn.poly.group2.pro2111.major.form;

/**
 *  Major search form
 * 
 * @author minht
 * 
 */
public class MajorSearchForm {
	
	/*=====================================================================================================
     *===== PRIVATE PROPERTIES                                                                        =====
     *=====================================================================================================*/
	
	/**
     * MAJOR.LECTURERID
     */
	private Long lecturerId;
	
	/**
     * MAJOR.NAME
     */
	private String name;
	
	private Long pn;

	/*=====================================================================================================
     *===== GETTER & SETTER                                                                           =====
     *=====================================================================================================*/
	
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
