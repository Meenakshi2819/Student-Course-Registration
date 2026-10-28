package com.example.demo.Controller;



import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Model.Student;
import com.example.demo.Service.StudentService;



@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

   
    @PostMapping
    public Student registerStudent(@Valid @RequestBody Student student) {
        return studentService.registerStudent(student);
    }

    
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }


    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

   
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        return studentService.deleteStudent(id);
    }
}