package com.leucine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.leucine.entity.User;
import com.leucine.service.UserService;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(String username, String password, String role, Model model) {
        User user = userService.findUserByUsername(username);

        if (user == null) {
            model.addAttribute("error", "User not found");
            return "login";
        }
        if (!user.getPassword().equals(password)) {
            model.addAttribute("error", "Wrong password");
            return "login";
        } else if (!user.getRole().toString().equals(role)) {
            model.addAttribute("error", "Please select valid role");
            return "login";
        }

        switch (user.getRole()) {
            case STUDENT:
                return "redirect:/student/dashboard"; // Change to your student dashboard path
            case FACULTY_MEMBER:
                return "redirect:/faculty/dashboard"; // Change to your faculty dashboard path
            case ADMINISTRATOR:
                return "redirect:/admin/dashboard"; // Change to your admin dashboard path
            default:
                return "redirect:/login?error"; // Fallback in case of unrecognized role
        }
    }
}
