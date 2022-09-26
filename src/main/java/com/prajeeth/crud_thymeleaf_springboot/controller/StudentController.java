package com.prajeeth.crud_thymeleaf_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.prajeeth.crud_thymeleaf_springboot.model.student;
import com.prajeeth.crud_thymeleaf_springboot.service.StudentService;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listStudents", studentService.getAllStudents());
        return "index";
    }

    @GetMapping("/showNewStudentForm")
    public String showNewStudentForm(Model model){
        student student = new student();
        model.addAttribute("student", student);
        return "new_student";
    }
    
    @PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute("student") student student) {
		
        studentService.saveStudent(student);
		return "redirect:/";
	}

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model){
        student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "update_student";
    }
}
