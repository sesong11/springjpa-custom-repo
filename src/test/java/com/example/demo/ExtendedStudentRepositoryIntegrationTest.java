package com.example.demo;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.demo.dao.ExtendedStudentRepository;
import com.example.demo.entity.Student;
import org.springframework.context.annotation.Import;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(StudentJPAH2Config.class)
public class ExtendedStudentRepositoryIntegrationTest {
  
    @Autowired
    private ExtendedStudentRepository extendedStudentRepository;
    
    @Before
    public void setup() {
        Student student = new Student(1, "john");
        extendedStudentRepository.save(student);
        Student student2 = new Student(2, "johnson");
        extendedStudentRepository.save(student2);
        Student student3 = new Student(3, "tom");
        extendedStudentRepository.save(student3);
    }
     
    @Test
    public void givenStudents_whenFindByName_thenOk(){
        List<Student> students 
          = extendedStudentRepository.findByAttributeContainsText("name", "john");
  
        assertEquals("size incorrect", 2, students.size());        
    }
}
