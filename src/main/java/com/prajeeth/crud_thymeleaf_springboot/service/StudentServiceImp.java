package com.prajeeth.crud_thymeleaf_springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.prajeeth.crud_thymeleaf_springboot.model.student;
import com.prajeeth.crud_thymeleaf_springboot.repository.StudentRepository;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<student> getAllStudents(){
        return studentRepository.findAll();
    }

    @Override
    public void saveStudent(student student) {
        this.studentRepository.save(student);
        
    }
    
}
