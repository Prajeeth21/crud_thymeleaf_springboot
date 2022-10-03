package com.prajeeth.crud_thymeleaf_springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @Override
    public student getStudentById(long id) {
        Optional<student> optional = studentRepository.findById(id);
        student student = null;
        if(optional.isPresent()){
            student = optional.get();
        } else {
			throw new RuntimeException(" Employee not found for id :: " + id);
		}
        return student;
    }

    @Override
    public void deleteStudentById(long id) {
       this.studentRepository.deleteById(id);
    }

    @Override
    public Page<student> findPaginated(int pageNo, int pageSize, String sortField, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
        Sort.by(sortField).descending();
    
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.studentRepository.findAll(pageable);
    }

    public List<student> getByKeyword(String keyword){
        return studentRepository.findByKeyword(keyword);
       }
    
}
