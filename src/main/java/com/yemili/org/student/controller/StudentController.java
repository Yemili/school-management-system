package com.yemili.org.student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yemili.org.student.model.Examtype;
import com.yemili.org.student.model.Student;
import com.yemili.org.student.model.Studentaccedamicdetails;
import com.yemili.org.student.service.StudentService;



@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentservice;

	public StudentController(StudentService studentservice) {
		this.studentservice = studentservice;
	}
	/*
	 * @GetMapping("/") public String redirectToIndex() { return
	 * "forward:/index.html"; // Forward to the static index.html }
	 */
	
	
	  @GetMapping("/show") 
	  public List<Student> getStudent() 
	  {
		  System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		  return studentservice.getAllStudents();
	  }
	 
	
	  @GetMapping("/{id}")
	  public Optional<Student> getStudentById(@PathVariable Long id)
	  {
		  return studentservice.getById(id); 
		  }
	 

	
	  @PostMapping("/addstudents")
	  public Student addstudent(@RequestBody Student student)
	  {
		  // logger.info("Received student: {}", student); 
		  return studentservice.addStudent(student);
	  
	  }
	 
	
	  @DeleteMapping("/{id}") 
	  public void deleteStudentById(@PathVariable Long id)
	  {
		  studentservice.deleteStudentById(id);
	  }
	  
	  @PutMapping("/{id}/name") 
	  public Optional<Student>updateStudentName(@PathVariable Long id, @RequestParam String name)
	  {
		  return studentservice.updateStudentName(id, name); 
	  }
	  
	 
	  @GetMapping("/academic-details")
	    public List<Studentaccedamicdetails> getAllAcademicDetails() {
		  
	        return studentservice.getAllAcademicDetails();
	    }
	  	// Add academic details
	    @PostMapping("/academic-details")
	    public Studentaccedamicdetails addAcademicDetails(@RequestBody Studentaccedamicdetails academicDetails)
	    {
	 
	        return studentservice.addAcademicDetails(academicDetails);
	    }
	  
	    // Get all exam types
	    @GetMapping("/exam-types")
	    public List<Examtype> getAllExamTypes() {
	        return studentservice.getAllExamTypes();
	    }
	    
	    // Add new exam type
	    @PostMapping("/exam-types")
	    public Examtype addExamType(@RequestBody Examtype examType) {
	        return studentservice.addExamType(examType);
	    }
	    
	    // Get exam type by ID
	    @GetMapping("/exam-types/{id}")
	    public Examtype getExamTypeById(@PathVariable Long id) {
	        return studentservice.getExamTypeById(id);
	    }

	    // Update exam type
	    @PutMapping("/exam-types/{id}")
	    public Examtype updateExamType(@PathVariable Long id, @RequestBody Examtype examType) {
	        return studentservice.updateExamType(id, examType);
	    }

	    // Delete exam type by ID
	    @DeleteMapping("/exam-types/{id}")
	    public void deleteExamType(@PathVariable Long id) {
	        studentservice.deleteExamType(id);
	    }
	}

