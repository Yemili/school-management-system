package com.yemili.org.student.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yemili.org.student.model.ExamTypeMarks;
import com.yemili.org.student.model.Examtype;
import com.yemili.org.student.model.Student;
import com.yemili.org.student.model.Studentaccedamicdetails;
import com.yemili.org.student.repository.StudentRepository;
import com.yemili.org.student.service.StudentService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/view")
public class ControllerView {

	@Autowired
	private StudentService studentservice;

	@Autowired
	private StudentRepository studentRepository;
	
	 
	public ControllerView(StudentService studentservice) {
		this.studentservice = studentservice;
	}

	@GetMapping("/registration")
	public String showRegistrationForm(Model model) {
		
		model.addAttribute("student", new Student());

		return "registrationform"; // Returns the Thymeleaf template name
	}

	@PostMapping("/registration")
	public String addRegistrationForm(@ModelAttribute Student student) {
		studentservice.addStudent(student);
		return "registrationform";

	}

	@GetMapping("/login")
	public String showLoginForm() { 
		 // model.addAttribute("student", new Student());
		  
		  return "index"; 
		  }// Returns the Thymeleaf template name } }
		 
	
	@PostMapping("/loginForm")
	public String loginForm(String name, String password, Model model) {
	    Optional<Student> students = studentRepository.findByname(name);

	    if (students.isPresent() && students.get().getPassword().equals(password))
	    {
	        //Student student = students.get(); 
	        //session.setAttribute("student", student); 
	        model.addAttribute("student", students.get().getName());
	        return "redirect:/view/welcome?name=" + name; 
	        
	    } else {
	        model.addAttribute("error", "Invalid name or password");
	        return "index"; 
	    }
	}

	
	
	 @GetMapping("/welcome") 
	 public String showWlcome(@RequestParam String name,Model model) { 
		 model.addAttribute("name", name);
		 Optional<Student> students = studentRepository.findByname(name); 
		 if(students.isPresent())
		 {
			 model.addAttribute("name", students.get().getName()); }
	 
		 	return "welcomepage";
	  
	  }
	 
	@GetMapping("/logout")
	public String logout(HttpSession session) {
	    session.invalidate(); // Invalidate the session
	    return "redirect:/"; // Redirect to home page
	}
	

	@GetMapping("/register")
	public String registerStudent(Student student, Model model) {
		model.addAttribute("message", "Registration Successful!");
		return "registrationsuccess";
	}
	
	
	@GetMapping("/viewDetails")
	public String viewDetails(@RequestParam String name, Model model) {

		
		Optional<Student> students =studentRepository.findByname(name);
		if (students.isPresent()) 
		{
		  System.out.println(students.get());
		  model.addAttribute("student", students.get());
		  
		  
		  } 
		else{model.addAttribute("error", "Invalid name ");
		  
		  } 
		 
		 return "detailsPage";	
	}
	
	@GetMapping("/edit")
    public String editProfileForm(Model model,@RequestParam String name) {
		Optional<Student> students = studentRepository.findByname(name);
		 if (students.isPresent()) {
			 Student student=students.get();
			 
				 model.addAttribute("student", student);	
				 
				}
		 else {
		        
		       System.out.println("student not found");
		    }
			
	return "editProfile";
	}

	@PutMapping("/editProfile")
    public String updateProfile(@RequestParam String name,@ModelAttribute Student student) {
		
		Optional<Student> existingStudentOpt = studentRepository.findByname(name);
	    
	    if (existingStudentOpt.isPresent()) {
	        Student existingStudent = existingStudentOpt.get();
	     // Update the existing student fields with the new values
	        existingStudent.setEmail(student.getEmail());
	        existingStudent.setGender(student.getGender());
	        existingStudent.setDate_of_birth(student.getDate_of_birth());
	        existingStudent.setAge(studentservice.calculateAge(student.getDate_of_birth()));
	        existingStudent.setMobilenumber(student.getMobilenumber());
	       
        studentservice.updateStudent(existingStudent); // Update the student's data
        return "redirect:/view/viewDetails?name=" + name; 
	    }
	    else {
	        
	    	return "redirect:/view/welcome?name=" + name;
	       
	    }
	}
	
	
	
	@GetMapping("/academicDetails")
	public String viewAcademicDetails(@RequestParam String name, Model model) {
        model.addAttribute("name", name);
        return "academicDetailsPage"; 
    }
	
	
	@GetMapping("/academicResults")
	public String getMarks(@RequestParam String examTypeName, Model model,@RequestParam String name) {
		Optional<Student> students = studentRepository.findByname(name);
		
		 if (students.isPresent()) {
			System.out.println(students.get()); 
			model.addAttribute("student", students.get());		
		
		 //  get the logged-in student
       
			List<ExamTypeMarks> marks = studentservice.getMarksByExamType(students.get().getId(), examTypeName);
			if (marks == null || marks.isEmpty()) {
			    System.out.println("No marks found for student ID " + students.get().getId() + " and exam type " + examTypeName);
			} else {
			    System.out.println("Marks retrieved: " + marks);
			}
			//System.out.println(students.get().getId()+" "+examtype_name);
			
        model.addAttribute("marks", marks);
        model.addAttribute("examtype_name", examTypeName);
        return "academicResults";
    }
	else{model.addAttribute("error", "Invalid name or password") ;
	return "welcomepage";
	}
	}
	
	@GetMapping("/studentlist")
	public String getStudentList(Model model) {
		List<Student> students = studentservice.getAllStudents();
		model.addAttribute("students", students);
		return "studentdetails";
	}

	@GetMapping("/{id}")
	public String getStudentById(@PathVariable Long id, Model model) {
		Optional<Student> student = studentservice.getById(id);
		if (student.isPresent()) {
			System.out.println(student.get().getName());
			System.out.println(student.get().getGender());
			System.out.println(student.get().getMobilenumber());
			System.out.println(student.get().getPassword());
			System.out.println(student.get().getAge());

			// Student student1 = student.get();
			// System.out.println("Student Name: " + student1.getName());
			model.addAttribute("student", student.get());

		} else {
			model.addAttribute("message", "student not found");
		}
		return "studentdetails";
	}

	
	 @GetMapping("/studentexamlist")
	 public String getStudentsExamList(Model model) {
		 List<Examtype> exams = studentservice.getAllExamTypes(); 
	  List<Student> students = studentservice.getAllStudents();
	  model.addAttribute("exams", exams); 
	  return "studentexamdetails"; 
	  }
	 
	@GetMapping("/studentaccdemiclist")
	public String getStudentsAccdemicList(Model model) {
		List<Studentaccedamicdetails> details = studentservice.getAllAcademicDetails();

		model.addAttribute("details", details);
		return "studentaccdemicdetails";
	}
	
}
