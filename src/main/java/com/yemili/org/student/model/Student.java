package com.yemili.org.student.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name = "student_details")
public class Student implements Serializable {
	
	private static final long serialVersionUID = 1L;
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;

	

	@Column(name = "mobilenumber")
	private String mobilenumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "date_of_birth")
	private LocalDate date_of_birth;
	
	@Column(name = "age")
	private int age;
	
	/*
	 * public void setDate_of_birth(LocalDate date_of_birth) { this.date_of_birth =
	 * date_of_birth; }
	 */

	

	private String gender;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Student() {
	}

	public Student(Integer id, String name, String gender, String password, String mobilenumber, String email,LocalDate date_of_birth,int age) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.mobilenumber = mobilenumber;
		this.password = password;
		this.date_of_birth = date_of_birth;
		this.age=age;
		
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", mobilenumber=" + mobilenumber + ", email=" + email + ", password="
				+ password + ", age=" + age + ", gender=" + gender + ",date_of_birth="+date_of_birth+"]";
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDate getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(LocalDate date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
}
