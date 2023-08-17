package com.example.springproject.service;

import com.example.springproject.dao.StudentRepository;
import com.example.springproject.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    private  final StudentRepository studentRepository;
    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }
    @Override
    public Student getStudent(int id) {
        Student student = null;
        Optional<Student> optional = studentRepository.findById(id);
        if(optional.isPresent()){
            student = optional.get();
        }
        else{
            System.out.println("No such student");
        }
        return student;
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> findAllByName(String name) {
        List<Student> students = studentRepository.findAllByName(name);
        return students;
    }
}
