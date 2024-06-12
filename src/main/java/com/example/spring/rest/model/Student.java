package com.example.spring.rest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {

	@Id
	private long id;
	private String name;
	@Column(name = "testscore")
	private String testScore;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTestScore() {
		return testScore;
	}

	public void setTestScore(String testScore) {
		this.testScore = testScore;
	}

}
