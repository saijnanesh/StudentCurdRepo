package com.example.spring.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.spring.rest.model.Student;

public interface StudentDao extends JpaRepository<Student, Long> {

	@Query(value = "select s from Student s where s.name =:name")
	Student findByName(@Param("name") String name);

}
