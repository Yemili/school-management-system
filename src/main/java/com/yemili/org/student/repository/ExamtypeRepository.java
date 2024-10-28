package com.yemili.org.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yemili.org.student.model.Examtype;

@Repository
public interface ExamtypeRepository extends JpaRepository<Examtype,Long>{

}
