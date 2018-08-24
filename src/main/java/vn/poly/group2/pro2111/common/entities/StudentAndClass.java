/*
 *@Author P.Tuong
 *@Date Jul 31, 2018
 *@Version 1.0
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

@Entity
@Table(name = "STUDENTANDCLASS")
public class StudentAndClass {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name = "CLASSID")
	private Long idClass;
	
	
	@Column(name = "STUDENTID")
	private Long idStudent;
	
	@ManyToOne
	@JoinColumn(name ="CLASSID",insertable = false, updatable= false)
	private Clasess classes;
	
	@ManyToOne
	@JoinColumn(name ="STUDENTID",insertable = false, updatable= false)
	private Student student;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdClass() {
		return idClass;
	}

	public void setIdClass(Long idClass) {
		this.idClass = idClass;
	}

	public Long getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(Long idStudent) {
		this.idStudent = idStudent;
	}

	public Clasess getClasses() {
		return classes;
	}

	public void setClasses(Clasess classes) {
		this.classes = classes;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	
}
