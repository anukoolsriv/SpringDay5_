package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lti.model.Student;
import com.lti.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService service;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String homePage() {
		return "index";
	}

	@RequestMapping(path = "addStudent.view", method = RequestMethod.GET)
	public String addStudentView() {
		return "addStudent";
	}

	@RequestMapping(path = "addStudent.do", method = RequestMethod.POST)
	public String addStudent(Student student) {
		// I don't have to do manually will be done by Spring
		// String rollNumber=request.getParameter("rollnumber");
		boolean result = service.addStudent(student);
		if (result) {
			return "redirect: findAllStudents.do"; // redirect to a controller,
													// not a page
		} else {
			return "error";
		}
	}

	@RequestMapping(path = "updateStudent.view", method = RequestMethod.GET)
	public String updateStudentsView() {
		return "updateStudent";
	}

	@RequestMapping(path = "updateStudent.do", method = RequestMethod.POST)
	public String updateStudent(Student student) {
		boolean result = service.updateStudent(student);
		if (result) {
			return "redirect: findAllStudents.do";
		} else {
			return "error";
		}

	}

	@RequestMapping(path = "deleteStudent.view", method = RequestMethod.GET)
	public String deleteStudentsView(Student student) {
		return "deleteStudent";
	}

	@RequestMapping(path = "deleteStudent.do", method = RequestMethod.POST)
	public String deleteStudent(Student student) {
		boolean result = service.deleteStudent(student.getRollNumber());
		if (result) {
			return "redirect:findAllStudents.do";
		} else {
			return "error";
		}
	}

	@RequestMapping(path = "findAllStudents.do")
	public String findAllStudents(Model model) {
		List<Student> students = service.getAllStudents();
		model.addAttribute("students", students);
		return "viewAllStudents";

	}

}
