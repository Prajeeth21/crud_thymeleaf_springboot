package com.prajeeth.crud_thymeleaf_springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.prajeeth.crud_thymeleaf_springboot.model.User;
import com.prajeeth.crud_thymeleaf_springboot.model.student;

public interface StudentService {
    List<student> getAllStudents();
    List<User> getAllUsername();
    void saveStudent(student student);
    student getStudentById(long id);
    void deleteStudentById(long id);
    Page<student> findPaginated(int pageNo, int pageSize, String sortField, String sortDir);
    List<student> getByKeyword(String keyword);

    
    
}
