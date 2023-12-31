package com.example.springproject.dao;


import com.example.springproject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    public List<Student> findAllByName(String name);
}
