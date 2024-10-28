package com.yemili.org.student.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;



@Table(name="student_accdemicdatails")
@Entity
public class Studentaccedamicdetails {
	
	  @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "id")
	  private int id;
	  
	  @Column(name="student_id")
	  private int student_id;
	  
	@Column(name = "exam_id")
	  private int exam_id; 
	  
	  
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
	  private double average;
	  
		/*
		 * @ManyToOne
		 * 
		 * @JoinColumn(name = "student_id", nullable = false) private Student
		 * student_id;
		 */
		
		/*
		 * @ManyToOne
		 * 
		 * @JoinColumn(name = "idexam_type", nullable = false) private Examtype
		 * examType;
		 */
		 
	    
		/*
		 * public Student getStudent_id() { return student_id; }
		 * 
		 * 
		 * public void setStudent_id(Student student_id) { this.student_id = student_id;
		 * }
		 */
	  


	public Studentaccedamicdetails() {
		  
	  }
	  
	  
	  public Studentaccedamicdetails(int id,int student_id,int exam_id,int tamil_marks,int english_marks,int maths_marks,int science_marks,int social_marks,int total,double average){
		  
		  this.id=id;
		  this.exam_id=exam_id;
		  this.student_id=student_id;
		  this.tamil_marks=tamil_marks;
		  this.english_marks=english_marks;
		  this.maths_marks=maths_marks;
		  this.science_marks=science_marks;
		  this.social_marks=social_marks;
		  this.average=average;
		  this.total=total;
		
		  
	  }
	  public int getExam_id() {
			return exam_id;
		}


		public void setExam_id(int exam_id) {
			this.exam_id = exam_id;
		}
		
	public int getStudent_id() {
		return student_id;
	}


	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	  
	  public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double d) {
		this.average = d;
	}
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


	  
	 
	 
}
