package com.example.spring.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.example.spring.rest.model.Student;

@SpringBootTest
class SpringRestApplicationTests {

	@Value("${studentapi.baseuri}")
	private String baseURL;
	
	@Test
	void testGetStudent() {
		RestTemplate temp = new RestTemplate();
		Student dt = temp.getForObject(baseURL +"sai", Student.class);
		assertNotNull(dt);
		assertEquals("sai", dt.getName());
	}

	@Test
	void testPostStudent() {
		RestTemplate temp = new RestTemplate();

		Student st = new Student();
		st.setId(2L);
		st.setName("chandu");
		st.setTestScore("980");
		Student dt = temp.postForObject("http://localhost:9909/studentpi/student/createStudent", st, Student.class);

		Student st1 = new Student();
		st.setId(3L);
		st.setName("chujjulu");
		st.setTestScore("980");
		Student dt1 = temp.postForObject("http://localhost:9909/studentpi/student/createStudent", st1, Student.class);
		assertNotNull(dt);
	}

	@Test
	void testPutStudent() {
		RestTemplate temp = new RestTemplate();

		Student getst = temp.getForObject("http://localhost:9909/studentpi/student/getStudentByName/sai",
				Student.class);
		getst.setTestScore("100");
		temp.put("http://localhost:9909/studentpi/student/updateStudent", getst, Student.class);
	}

}
