package com.example.springproject.controllers;

import com.example.springproject.entity.Student;
import com.example.springproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private  final StudentService service;
    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/show")
    public List<Student> show(){
        return service.getAllStudents();
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id){
        return service.getStudent(id);
    }
    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable int id){
        service.deleteStudent(id);
        return "Student id: "+id + "was deleted";
    }
    @PostMapping("/student")
    public Student saveStudent(@RequestBody Student student){
        service.saveStudent(student);
        return student;
    }
    @PutMapping("/student")
    public void updateStudent( @RequestBody Student updatedStudent) {
        service.saveStudent(updatedStudent);
    }

    @GetMapping("/student/show/{name}")
    public List<Student> findStudentsByName(@PathVariable String name){
        List<Student> students = service.findAllByName(name);
        return students;

    }

}
