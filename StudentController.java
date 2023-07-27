package com.NoobCoders.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.NoobCoders.entity.Student;

import in.NoobCoders.dao.DaOException;
import in.NoobCoders.dao.StudentDao;


@Controller
public class StudentController {
	
	@Autowired
	StudentDao htDao;
	 
	
	@RequestMapping(path = "/student-details", method = RequestMethod.GET)
	public String getStudentDetails(@RequestParam Integer id , Model model) throws DaOException {
		model.addAttribute("stud", htDao.getStudent(id));
		return "student-details";
		
	}
	
	@RequestMapping(path = "/add-student", method = RequestMethod.GET)
    public String addStudent(Model model) throws DaOException {
		model.addAttribute("stud", new Student());
        return "student-form"; 
    }
	
	@RequestMapping(path = "/save-student" , method = RequestMethod.POST)
	public String saveStudent(Student student) throws DaOException {
		htDao.addStudent(student);
		System.out.println(student.getId());
		return "redirect:student-details?id="+student.getId();
	}
	
	@RequestMapping(method = RequestMethod.GET , path = "/search-by-id")
	public String getStudentById(Model model , @RequestParam Integer id) throws DaOException {
		model.addAttribute("Page Title", "Student details with the ID "+id+" are as follows::");
		model.addAttribute("students", htDao.getStudent(id));
		return "student-details";
	}
	
	
	
}
