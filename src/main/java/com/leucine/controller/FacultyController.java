package com.leucine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import com.leucine.entity.Department;
import com.leucine.entity.Faculty;
import com.leucine.entity.Student;
import com.leucine.entity.User;
import com.leucine.service.FacultyService;
import com.leucine.service.StudentService;
import com.leucine.service.UserService;

@Controller
public class FacultyController {

	@Autowired
	StudentService studentService;
	@Autowired
	UserService userService;
	@Autowired
	FacultyService facultyService;
	
	@GetMapping("/faculty/dashboard")
	public String getCourseStudentEnrolled(Model model) {
		List<Student> students = studentService.findAll();
		model.addAttribute("students", students);
		return "facultyDashboard";
	}
	
	@GetMapping("/faculty/profile")
	public String getFacultyProfile(Model model,@SessionAttribute("userId") int id) {
		User user = userService.findById(id);
		Faculty faculty = facultyService.findFacultyById(id);
		Department department = faculty.getDepartment();
		model.addAttribute("user", user);
		model.addAttribute("faculty", faculty);
		model.addAttribute("department", department);
		return "viewFacultyProfile";
	}
	
	@GetMapping("/faculty/edit-profile")
	public String editFacultyProfile(Model model, @SessionAttribute("userId") int id) {
	    Faculty faculty = facultyService.findByUserId(id);
	    User user = userService.findById(id);
	    System.out.println(faculty);
	    System.out.println(user);

	    model.addAttribute("faculty", faculty);
	    model.addAttribute("user", user);
	    
	    return "editFacultyProfile";
	}


	@PostMapping("/faculty/update-profile")
	public String updateFacultyProfile(@SessionAttribute("userId") int id, 
	                                   String officeHours, 
	                                   String email,
	                                   long phone,
	                                   Model model) {

		User user = userService.findById(id);
	    Faculty faculty = facultyService.findByUserId(id);

	    System.out.println("Before Update:");
	    System.out.println("User: " + user);
	    System.out.println("Faculty: " + faculty);

	    System.out.println("Received officeHours: " + officeHours);
	    System.out.println("Received email: " + email);
	    System.out.println("Received phone: " + phone);

	    faculty.setOfficeHours(officeHours);
	    user.setEmail(email);
	    user.setPhone(phone);
	    
	    System.out.println("After Setting New Values:");
	    System.out.println("Updated User: " + user);
	    System.out.println("Updated Faculty: " + faculty);

	    userService.save(user);
	    facultyService.save(faculty); 

	    return "redirect:/faculty/profile";
	}
	
	@GetMapping("/faculty/student/all")
	public String getAllStudents(Model model) {
		List<Student> students = studentService.findAll();
		model.addAttribute("students", students);
		return "displayAllStudents";
	}


}

