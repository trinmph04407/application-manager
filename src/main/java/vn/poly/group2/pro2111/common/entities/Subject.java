/**
 * 
 */
package vn.poly.group2.pro2111.common.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Subject Entity
 * 
 * @author minht
 * 
 */

@Entity
@Table(name = "SUBJECT")
public class Subject {
	
    /*=====================================================================================================
     *===== PRIVATE PROPERTIES                                                                        =====
     *=====================================================================================================*/
	
	/**
     * SUBJECT.ID
     */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	/**
     * SUBJECT.MAJORID
     */
	@Column(name = "MAJORID")
	private Long majorId;
	
	/**
     * SUBJECT.LECTURERID
     */
	@Column(name = "LECTURERID")
	private Long lecturerId;
	
	/**
     * SUBJECT.CODE
     */
	@Column(name = "CODE")
	private String code;
	
	/**
     * SUBJECT.NAME
     */
	@Column(name = "NAME")
	private String name;
	
	/**
     * SUBJECT.MAJOR
     */
	@ManyToOne
	@JoinColumn(name = "MAJORID", insertable = false, updatable = false)
	private Major major;
	
	/**
     * SUBJECT.LECTURER
     */
	@ManyToOne
	@JoinColumn(name = "LECTURERID", insertable = false, updatable = false)
	private Lecturer lecturer;
	
    /*=====================================================================================================
     *===== CONSTRUCTOR METHOD                                                                        =====
     *=====================================================================================================*/
	
	/**
	 * Default constructor
	 */
	public Subject() {
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
	 * @return the major
	 */
	public Major getMajor() {
		return major;
	}

	/**
	 * @param major the major to set
	 */
	public void setMajor(Major major) {
		this.major = major;
	}

	/**
	 * @return the lecturer
	 */
	public Lecturer getLecturer() {
		return lecturer;
	}

	/**
	 * @param lecturer the lecturer to set
	 */
	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}

}
