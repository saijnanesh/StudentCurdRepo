package com.example.spring.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.rest.dao.StudentDao;
import com.example.spring.rest.model.Student;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentDao dao;

	@GetMapping("getAllStudents")
	public List<Student> getStudents() {
		return dao.findAll();
	}

	@GetMapping("getStudentById/{id}")
	public Student getStudentById(@PathVariable("id") Long id) {
		return dao.findById(id).get();
	}

	@PostMapping("/createStudent")
	public Student createStudent(@RequestBody Student s) {
		return dao.save(s);
	}

	@PutMapping("/updateStudent")
	public Student updateStudent(@RequestBody Student s) {
		return dao.save(s);
	}

	@GetMapping("deleteStudentById/{id}")
	public void deleteStudentById(@PathVariable("id") Long id) {
		dao.deleteById(id);
	}
	
	@GetMapping("getStudentByName/{name}")
	public Student getStudentByName(@PathVariable("name") String name) {
		return dao.findByName(name);
	}

}
