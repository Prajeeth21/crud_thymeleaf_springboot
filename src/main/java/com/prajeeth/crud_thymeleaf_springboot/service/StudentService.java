package com.prajeeth.crud_thymeleaf_springboot.service;

import java.util.List;
import com.prajeeth.crud_thymeleaf_springboot.model.student;

public interface StudentService {
    List<student> getAllStudents();
    void saveStudent(student student);
    
    
    
}
