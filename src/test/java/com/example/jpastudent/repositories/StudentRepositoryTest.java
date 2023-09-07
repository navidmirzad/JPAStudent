package com.example.jpastudent.repositories;

import com.example.jpastudent.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class StudentRepositoryTest {


    @Autowired
    StudentRepository studentRepository;


    @BeforeEach
    void setUp() {
        Student student = new Student();
        student.setName("Navid");
        studentRepository.save(student);
    }

    @Test
    void TestOneStudent() {
        List<Student> studentList = studentRepository.findAll();
        assertEquals(studentList.size(), 1);
    }

}