package com.example.demo.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.StudentJPAH2Config;
import com.example.demo.dao.ExtendedStudentRepository;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import com.example.demo.service.impl.StudentServiceImpl;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(StudentJPAH2Config.class)
public class StudentServiceIntegrationTest {
	
	@TestConfiguration
    static class StudentServiceImplTestContextConfiguration {
        @Bean
        public StudentService studentService() {
            return new StudentServiceImpl();
        }
    }
	
	@Autowired
	StudentService studentService;
	
	@MockBean
	ExtendedStudentRepository dao;
	
	@Before
	public void setUp() {
		Optional<Student> sample = Optional.of(new Student(1, "Student 1"));
		
		Mockito.when(dao.findByName(sample.get().getName())).thenReturn(sample);
	}
	
	@Test
	public void whenValidName_thenSampleShouldBeFound() {
		String name = "Student 1";
		
		Optional<Student> found = studentService.findByName(name);
		
		assertTrue(found.isPresent());
		assertThat(found.get().getName()).isEqualTo(name);
	}
}
