package com.yemili.org.student.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.yemili.org.student.model.Studentaccedamicdetails;

@Repository
public interface StudentaccedamicdetailsRepository extends JpaRepository<Studentaccedamicdetails,Long>{
	
	/*
	 * List<Studentaccedamicdetails> findByUserIdAndExamType(int student_id, String
	 * examType);
	 */

}
