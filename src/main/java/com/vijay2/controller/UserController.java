package com.vijay2.controller;

import com.vijay2.model.User;
import com.vijay2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/")
    public String home() {
        return "main_dashboard.html";
    }

    @GetMapping("/main_login")
    public String mainlogin() {
        return "main_login.html";
    }

    @GetMapping("/patient_signup")
    public String patientsignup() {
        return "patient_signup.html";
    }

    @PostMapping("/patientsignupverify")
    public String signup(@RequestParam("username") String username,
                         @RequestParam("email") String email,
                         @RequestParam("password") String password,
                         Model model) {
        // Check if username or email already exists in the database using UserService
        if (userService.isUsernameExists(username)) {
            model.addAttribute("error", "Username already exists");
            return "error_signup"; // Redirect back to signup page with an error message
        }
        if (userService.isEmailExists(email)) {
            model.addAttribute("error", "Email already exists");
            return "error_signup"; // Redirect back to signup page with an error message
        }
        // If username and email are unique, create a new user using UserService
        userService.createUser(username, email, password);
        return "redirect:/success";
    }

    @GetMapping("/success")
    public String success() {
        return "success.html";
    }
    @GetMapping("/patient_login")
    public String patientlogin() {
        return "patient_login.html";
    }

    @PostMapping("/patientloginverify")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {

        // Perform authentication logic here by checking username and password in the database
        User user = userService.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            return "redirect:/patientdash";
        } else {
            // If credentials do not match, return to the login page with an error message
            model.addAttribute("error", "Invalid username or password");
            return "error_signup.html";
        }
    }

    // Route for success page
    @GetMapping("/patientdash")
    public String patientdash() {
        return "patient_dashboard.html"; // Assuming you have a success.html page
    }





@GetMapping("/admin_login")
    public String adminlogin() {
        return "admin_login.html";
    }

    @GetMapping("/doctor_login")
    public String doctorlogin() {
        return "doctor_login.html";
    }
}



/*
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
    @Autowired
    public SignupController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/somelogin")
    public List<User> getAllUsers() {
        return userService.getAllUsers();

    }*/

