package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Exception.StudentNotFoundException;
import com.example.demo.Model.Student;



@Service
public class StudentService {

    private final List<Student> students = new ArrayList<>();

    
    public Student registerStudent(Student student) {

        for (Student existing : students) {
            if (existing.getStudentId() == student.getStudentId()) {
                throw new IllegalArgumentException(
                    "Student ID already exists");
            }
        }

        students.add(student);
        return student;
    }

   
    public List<Student> getAllStudents() {
        return students;
    }

   
    public Student getStudentById(int id) {

        for (Student student : students) {
            if (student.getStudentId() == id) {
                return student;
            }
        }

        throw new StudentNotFoundException(
            "Student not found with ID: " + id);
    }

    
    public String deleteStudent(int id) {

        Student student = getStudentById(id);
        students.remove(student);

        return "Student registration deleted successfully";
    }
}
