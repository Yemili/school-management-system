package com.yemili.org.student.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yemili.org.student.model.ExamTypeMarks;
import com.yemili.org.student.model.Student;


@Repository
public interface ExamtypeMarksRepository  extends JpaRepository<ExamTypeMarks,Long> {
	
	 List<ExamTypeMarks> findByStudentIdAndExamTypeName(int student_id, String examTypeName);

}
