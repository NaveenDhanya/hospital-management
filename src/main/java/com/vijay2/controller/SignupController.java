package com.vijay2.controller;

import com.vijay2.model.User;
import com.vijay2.repository.UserRepository;
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


//    @GetMapping("/dashboard")
//    public String showSignupForm(Model model) {
//        model.addAttribute("user", new User());
//        return "redirect:/dashboard.html";
//    }
    
	@GetMapping("/")
	public String home() {
		return "dashboard.html";
	}
//	@GetMapping("/patlog")
//	public String patlog() {
//		return "patient";
//	}
//	@GetMapping("/doctorlogin")
//	public String doctorlogin() {
//		return "doctor";
//	}

    @PostMapping("/signup")
    public String signup(User user) {
        userService.saveUser(user);
        return "redirect:/signup-success.html"; // Redirect to the login page after successful signup
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Return the login form view
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        // Find the user by username
        User user = userService.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            return "redirect:/patientdashboard.html";
        } else {

            return "redirect:/login?error";
        }
    }

}