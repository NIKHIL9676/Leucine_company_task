package com.leucine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.leucine.entity.Department;
import com.leucine.entity.Faculty;
import com.leucine.entity.Student;
import com.leucine.entity.User;
import com.leucine.service.DepartmentService;
import com.leucine.service.FacultyService;
import com.leucine.service.StudentService;
import com.leucine.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class StudentController {

	@Autowired
	UserService userService;
	@Autowired
	StudentService studentService;
	@Autowired
	DepartmentService departmentService;
	@Autowired
	FacultyService facultyService;

	@GetMapping("/student/dashboard")
	public String getStudentDashboard(Model model, HttpSession session) {
		model.addAttribute("studentName", userService.findById((int) session.getAttribute("userId")).getName());
		return "studentDashboard";
	}

	@GetMapping("/student/profile")
	public String getStudentProfile(@SessionAttribute("userId") int id, Model model, HttpSession httpSession) {
		User user = userService.findById(id);
		Student student = studentService.findByUserId(id);
		Department department = student.getDepartment();
		model.addAttribute("user", user);
		model.addAttribute("student", student);
		model.addAttribute("department", department);
		return "viewProfile";
	}

	@GetMapping("/student/all")
	public String getAllStudents(Model model) {
		System.out.println("print all students");
		List<Student> students = studentService.findAll();
		System.out.println(students);
		model.addAttribute("students", students);
		return "displayAllStudents"; // Create this HTML page
	}

	@GetMapping("/student/search")
	public String searchStudents(@RequestParam(name = "query", required = false) String query, Model model) {
		System.out.println("Searching student by name or department or year");
		List<Student> students = studentService.searchStudents(query);
		model.addAttribute("students", students);
		return "displayAllStudents";
	}

	@GetMapping("/student/advisors")
	public String getDepartmentAdvisors(Model model,@SessionAttribute("userId") int userId, HttpSession httpSession) {

		

		User user = userService.findById(userId);
		
		Student student = studentService.findByUserId(user.getId()); // Assuming you have this method

		Department department = student.getDepartment(); // Now we access the department through the student

		List<Faculty> advisors = facultyService.findByDepartmentName(department.getName());
		model.addAttribute("advisors", advisors);

		return "advisor"; // The name of the Thymeleaf template to display advisors
	}

}
