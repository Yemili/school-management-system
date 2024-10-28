package com.yemili.org.student.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name = "exam_type")
public class Examtype {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	
	@Column(name = "exam_name")
	private String exam_name;
	
	@Column(name = "date")
	private String date;
	
	/*
	 * @OneToMany(mappedBy = "examType", cascade = CascadeType.ALL) private
	 * List<Studentaccedamicdetails> academicDetails;
	 */

	
	public Examtype() {
		
	}
	
	public Examtype(int id,String exam_name,String date)
	{
		this.date=date;
		this.id=id;
		this.exam_name=exam_name;
	}
	
	/*
	 * public int getIdexam_type() { return id; }
	 * 
	 * public void setIdexam_type(int idexam_type) { this.id = idexam_type; }
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getExam_name() {
		return exam_name;
	}

	public void setExam_name(String exam_name) {
		this.exam_name = exam_name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	
}
