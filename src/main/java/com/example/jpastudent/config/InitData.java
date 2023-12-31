package com.example.jpastudent.config;

import com.example.jpastudent.model.Student;
import com.example.jpastudent.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
    Student s1 = new Student();
    s1.setName("Navid");
    s1.setBornDate(LocalDate.of(2000, 10, 29));
    s1.setBornTime(LocalTime.of(10,11,12));
    studentRepository.save(s1);

    Student s2 = new Student();
    s2.setName("Ziba");
    s2.setBornDate(LocalDate.of(2002, 04, 05));
    s2.setBornTime(LocalTime.of(7,8,9));
    studentRepository.save(s2);
    }
}
