package com.example.spring.rest.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Student")
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@NotNull(message = "Name cannot be Null")
	private long id;
	@NotNull(message = "Name cannot be Null")
	@Size(max = 20)
	private String name;
	@Column(name = "testscore")
	@Min(value = 0, message = "The minimum test score is 0")
	@Max(value = 100, message = "The maximum test score is 100")
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
