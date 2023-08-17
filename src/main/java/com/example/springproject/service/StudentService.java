package com.example.springproject.service;

import com.example.springproject.entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudents();
    public void saveStudent(Student student);
    public Student getStudent(int id);
    public void deleteStudent(int id);
    public List<Student> findAllByName(String name);

}
