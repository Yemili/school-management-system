package com.yemili.org.student.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
/*import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;*/
import jakarta.persistence.Table;

@Entity
@Table(name = "examtype_marks")
public class ExamTypeMarks {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	
	
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "student_id") private Student student;
	 */  // This specifies the column name in the database
	//@JoinColumn(name = "student_id")
	@Column(name = "student_id")
	private int studentId;

	@Column(name = "tamil_marks")
	private int tamil_marks;
	
	@Column(name = "english_marks")
	private int english_marks;
	
	@Column(name = "maths_marks")
	private int maths_marks;
	
	@Column(name = "science_marks")
	private int science_marks;
	
	@Column(name = "social_marks")
	private int social_marks;
	
	@Column(name = "total")
	private int total;
	
	@Column(name = "average")
	private int average;
	
	@Column(name = "examtype_name")
	private String examTypeName;
	
	
	
	public ExamTypeMarks()
	{
		
	}
	
	
	public ExamTypeMarks(int id,int studentId,int tamil_marks,int english_marks,int maths_marks,int science_marks,int social_marks,int total,int average,String examTypeName)
	{
		this.id=id;
		this.studentId=studentId;
		this.tamil_marks=tamil_marks;
		this.english_marks=english_marks;
		this.maths_marks=maths_marks;
		this.science_marks=science_marks;
		this.social_marks=social_marks;
		this.total=total;
		this.average=average;
		this.examTypeName=examTypeName;
	}
	
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	
	  public int getStudentId() { return studentId; }
	  
	  
	  public void setStudentId(int studentId) { this.studentId = studentId; }
	 


	public int getTamil_marks() {
		return tamil_marks;
	}


	public void setTamil_marks(int tamil_marks) {
		this.tamil_marks = tamil_marks;
	}


	public int getEnglish_marks() {
		return english_marks;
	}


	public void setEnglish_marks(int english_marks) {
		this.english_marks = english_marks;
	}


	public int getMaths_marks() {
		return maths_marks;
	}


	public void setMaths_marks(int maths_marks) {
		this.maths_marks = maths_marks;
	}


	public int getScience_marks() {
		return science_marks;
	}


	public void setScience_marks(int science_marks) {
		this.science_marks = science_marks;
	}


	public int getSocial_marks() {
		return social_marks;
	}


	public void setSocial_marks(int social_marks) {
		this.social_marks = social_marks;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	public int getAverage() {
		return average;
	}


	public void setAverage(int average) {
		this.average = average;
	}


	public String getexamTypeName() {
		return examTypeName;
	}


	public void setexamTypeName(String examTypeName) {
		this.examTypeName = examTypeName;
	}
	/*
	 * public Student getStudent() { return student; }
	 * 
	 * 
	 * public void setStudent(Student student) { this.student = student; }
	 */

	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", TamilMarks=" + tamil_marks + ", EnglishMarks=" + english_marks + ", MathsMarks="
				+ maths_marks + ",ScienceMarks=" + science_marks + ", SocialMarks=" + social_marks + ", Total=" + total + ", Average=" + average + "]";
	}
	
	
	

}
