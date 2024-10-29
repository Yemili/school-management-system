package com.yemili.org.student.service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.yemili.org.student.model.ExamTypeMarks;
import com.yemili.org.student.model.Examtype;
import com.yemili.org.student.model.Student;
import com.yemili.org.student.model.Studentaccedamicdetails;
import com.yemili.org.student.repository.ExamtypeMarksRepository;
import com.yemili.org.student.repository.ExamtypeRepository;
import com.yemili.org.student.repository.StudentRepository;
import com.yemili.org.student.repository.StudentaccedamicdetailsRepository;

/*import com.yemili.org.student.model.Examtype;
import com.yemili.org.student.model.ExamTypeMarks;
import com.yemili.org.student.model.Student;
import com.yemili.org.student.model.Studentaccedamicdetails;
import com.yemili.org.student.repository.ExamtypeMarksRepository;
import com.yemili.org.student.repository.ExamtypeRepository;
import com.yemili.org.student.repository.StudentRepository;
import com.yemili.org.student.repository.StudentaccedamicdetailsRepository;
*/
import java.lang.String;
import java.time.LocalDate;
import java.time.Period;
@Service
public class StudentService {
	
	public List <Student> studentlist=new ArrayList<>();
	
	public List <Studentaccedamicdetails> accedamiclist=new ArrayList<>();
	
	public List <Examtype> examtypelist=new ArrayList<>();
	
	public List <ExamTypeMarks> examtypemarks=new ArrayList<>();
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StudentaccedamicdetailsRepository studentaccedamicRepository;
	
	@Autowired
	private ExamtypeRepository examtypeRepository;

	@Autowired
	private ExamtypeMarksRepository examtypemarksRepository;
	
	//get all students
	public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
	
	//get student by id
	 public Optional<Student> getById(Long id) {
	        return studentRepository.findById(id);
	 }
	 
	 //add student
	public Student addStudent(Student student) {
		return studentRepository.save(student);
		
    }
	
	//delete student by id
	public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
	
	//update student by name
	public Optional<Student> updateStudentName(Long id, String name) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setName(name); // Update the name
            
            return Optional.of(studentRepository.save(student));
        }
        return Optional.empty();
	}  
	
      
	public void updateStudent(Student student) {
		
		if (student.getDate_of_birth() != null) {
	        student.setAge(calculateAge(student.getDate_of_birth()));
	    } else {
	        System.out.println("Date of birth is null for student: " + student);
	    }
		
		 //student.setAge(calculateAge(student.getDate_of_birth()));
		 System.out.println("student values to be updated:"+student);
        studentRepository.save(student);
    }
	public int calculateAge(LocalDate date_of_birth) {
	    if (date_of_birth == null) {
	        return 0; 
	    }
	    int age = Period.between(date_of_birth, LocalDate.now()).getYears();
	    System.out.println("Calculated age: " + age + " for date of birth: " + date_of_birth);
	    return age;
	}
    
	//getting all accedamic details
	public List<Studentaccedamicdetails> getAllAcademicDetails() {
		// TODO Auto-generated method stub
		return studentaccedamicRepository.findAll();
	}
	//adding accedamic details
	public Studentaccedamicdetails addAcademicDetails(Studentaccedamicdetails academicDetails) {
		//Optional<Student> studentOpt = studentRepository.findById(studentId);
        
        System.out.println("student id:"+academicDetails.getId());
        System.out.println("student exam id:"+academicDetails.getExam_id());
        System.out.println("student tamil marks:"+academicDetails.getTamil_marks());
        System.out.println("student english marks:"+academicDetails.getEnglish_marks());
        System.out.println("student maths marks:"+academicDetails.getMaths_marks());
        System.out.println("student science marks:"+academicDetails.getScience_marks());
        System.out.println("student social:"+academicDetails.getSocial_marks());
        System.out.println("student total:"+calculateTotalAndAverage(academicDetails).getTotal());
        System.out.println("student average:"+calculateTotalAndAverage(academicDetails).getAverage());
        System.out.println("student id from student:"+academicDetails.getStudent_id());
        
        
		//System.out.println(calculateTotalAndAverage(academicDetails));
		return studentaccedamicRepository.save(academicDetails);
        }
		
	
	private Studentaccedamicdetails calculateTotalAndAverage(Studentaccedamicdetails academicDetails) {
        int total = academicDetails.getTamil_marks() +
                    academicDetails.getEnglish_marks() +
                    academicDetails.getMaths_marks() +
                    academicDetails.getScience_marks() +
                    academicDetails.getSocial_marks();
        academicDetails.setTotal(total);
        academicDetails.setAverage(total / 5.0); // Assuming 5 subjects
		return academicDetails;
    }
	 // Get all exam types
	public List<Examtype> getAllExamTypes() {
		
		return examtypeRepository.findAll();
	}
	// Add new exam type
	public Examtype addExamType(Examtype examType) {

		return  examtypeRepository.save(examType);
	}
	// Get exam type by ID
	public Examtype getExamTypeById(Long id) {
		
		return  examtypeRepository.findById(id).orElse(null);
	}
	 // Update exam type
	public Examtype updateExamType(Long id, Examtype updatedExamType) {
		Examtype existingExamType = getExamTypeById(id);
        if (existingExamType != null) {
            existingExamType.setExam_name(updatedExamType.getExam_name());
            existingExamType.setDate(updatedExamType.getDate());
            return examtypeRepository.save(existingExamType);
        }
        return null;
    }
	 // Delete exam type by ID
	public void deleteExamType(Long id) {
		examtypeRepository.deleteById(id);
	}
	
	public List<ExamTypeMarks> getMarksByExamType(int student_id, String examTypeName) {
        return examtypemarksRepository.findByStudentIdAndExamTypeName(student_id, examTypeName);
    }
	
	
	}
	
	

        



	