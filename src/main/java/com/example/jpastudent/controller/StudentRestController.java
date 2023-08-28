package com.example.jpastudent.controller;

import com.example.jpastudent.model.Student;
import com.example.jpastudent.repositories.StudentRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentRestController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> students() {
        var obj = studentRepository.findAll();
                return obj;
    }

    @GetMapping("/addstudent")
    public List<Student> addstudent() {
        Student student = new Student();
        student.setBornDate(LocalDate.now());
        List<Student> st = studentRepository.findAll();
        return st;
    }


    @GetMapping("student/{name}")
    public List<Student> getStudentByName(@PathVariable String name) {
        return studentRepository.findAllByName(name);
    }

    @PostMapping("student")
    @ResponseStatus(HttpStatus.CREATED)
    public Student postStudent(@RequestBody Student student) {
        System.out.println(student);
        return studentRepository.save(student);
    }

    /*@PutMapping("student")
    public Student putStudent(@RequestBody Student student) {
        Optional<Student> originalStudent = studentRepository.findById(student.getId());
            if (originalStudent.isPresent()) {
                return studentRepository.save(student);
            } else {
                Student noStudent = new Student();
                noStudent.setName("NotFound");
                return noStudent;
            }
    }*/

    @PutMapping("student/{id}")
    public ResponseEntity<Student> putStudent(@PathVariable int id, @RequestBody Student student) {
        Optional<Student> originalStudent = studentRepository.findById(id);
        if (originalStudent.isPresent()) {
            student.setId(id);
            studentRepository.save(student);
           // return new ResponseEntity<>(student, HttpStatus.OK);
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.notFound().build();
           // return new ResponseEntity<>(new Student(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        Optional<Student> originalStudent = studentRepository.findById(id);
        if (originalStudent.isPresent()) {
            studentRepository.deleteById(id);
            return ResponseEntity.ok("student deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("student not found");
        }
    }




}
