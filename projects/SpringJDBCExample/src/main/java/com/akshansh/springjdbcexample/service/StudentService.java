package com.akshansh.springjdbcexample.service;

import com.akshansh.springjdbcexample.model.Student;
import com.akshansh.springjdbcexample.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository repo;

    public StudentService(StudentRepository repo){
        this.repo = repo;
    }

    public void addStudent(Student s) {
        repo.save(s);
    }

    public List<Student> getStudents() {
        return repo.findAll();
    }
}
