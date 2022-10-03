package com.prajeeth.crud_thymeleaf_springboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.prajeeth.crud_thymeleaf_springboot.model.student;
import com.prajeeth.crud_thymeleaf_springboot.service.StudentService;

@Controller
public class StudentController {


    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String viewHomePage(Model model){
        return findPaginated(1, "firstName", "asc", model);
    }

    @RequestMapping(path = {"/","/search"})
    public String home(student student, Model model, String keyword) {
        if(keyword!=null) {
            List<student> listStudents = studentService.getByKeyword(keyword);
            model.addAttribute("list", listStudents);
        }
        else{
            List<student> listStudents = studentService.getAllStudents();
            model.addAttribute("list", listStudents);
        }
        return "index";
    }

    @GetMapping("/showNewStudentForm")
    public String showNewStudentForm(Model model){
        student student = new student();
        model.addAttribute("student", student);
        return "new_student";
    }
    
    @PostMapping("/saveStudent")
	public String saveStudent(@Valid @ModelAttribute("student") student student ) {
		
        studentService.saveStudent(student);
		return "redirect:/";
	}

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model){
        student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "update_student";
    }

    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable(value = "id") long id){
        this.studentService.deleteStudentById(id);
        return "redirect:/";
    }

    @GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;
		
		Page<student> page = studentService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<student> listStudents = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listStudents", listStudents);
		return "index";
	}
}
