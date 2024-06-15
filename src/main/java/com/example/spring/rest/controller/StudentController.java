package com.example.spring.rest.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.rest.dao.StudentDao;
import com.example.spring.rest.model.Student;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/student")
@Tag(name = "Student Rest End point")
public class StudentController {

	@Autowired
	StudentDao dao;

	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

	@GetMapping("getAllStudents")
	public List<Student> getStudents() {
		return dao.findAll();
	}

	@GetMapping("getStudentById/{id}")
	@Transactional
	@Cacheable("student-cache")
	@Operation(summary = "Returns a Single Student", description = "Takes ID and returns a Student")
	public @ApiResponse(description = "Returns a Student") Student getStudentById(
			@Parameter(description = "id of the product") @PathVariable("id") Long id) {
		LOGGER.info("finding ID -> " + id);
		return dao.findById(id).get();
	}

	@PostMapping("/createStudent")
	public Student createStudent(@Valid @RequestBody Student s) {
		return dao.save(s);
	}

	@PutMapping("/updateStudent")
	public Student updateStudent(@Valid @RequestBody Student s) {
		return dao.save(s);
	}

	@DeleteMapping("deleteStudentById/{id}")
	@CacheEvict("student-cache")
	public void deleteStudentById(@PathVariable("id") Long id) {
		dao.deleteById(id);
	}

	@GetMapping("getStudentByName/{name}")
	public Student getStudentByName(@PathVariable("name") String name) {
		return dao.findByName(name);
	}

}
