package com.vijay2.controller;

import com.vijay2.model.User;
import com.vijay2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SignupController {
    @Autowired
    private UserService userService;
    @Autowired
    private JavaMailSender javaMailSender;

	@GetMapping("/")
	public String home() {
		return "dashboard.html";
	}

    @PostMapping("/signup")
    public String signup(User user) {
        userService.saveUser(user);
        return "redirect:/signup-success.html"; // Redirect to the login page after successful signup
    }
    @GetMapping("/patientlogin")
    public String showLoginForm() {
        return "login"; // Return the login form view
    }
    @PostMapping("/patientlogin")
    public String login(@RequestParam String username, @RequestParam String password) {
        // Find the user by username
        User user = userService.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            return "redirect:/patientdashboard.html";
        } else {

            return "redirect:/login?error";
        }
    }
    @GetMapping("/users")
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "userdetails";
    }


}