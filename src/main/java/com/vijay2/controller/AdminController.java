package com.vijay2.controller;

import com.vijay2.model.Admin;
import com.vijay2.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;
    @GetMapping("/adminlogin")
    public String showLoginForm() {
        return "login"; // Return the login form view
    }
    @PostMapping("/adminlogin")
    public String login(@RequestParam String username, @RequestParam String password) {
        // Find the user by username
        Admin admin = adminService.findByUsername(username);

        if (admin != null && admin.getPassword().equals(password)) {
            return "redirect:/admindashboard.html";
        } else {

            return "redirect:/adminlogin?error";
        }
    }

    @PostMapping("/doctorDetails")
    public String confirmAdmin(@ModelAttribute Admin admin) {
        adminService.saveAdmin(admin);
        return "redirect:/signup-success.html"; // Redirect to the confirmation page
    }

}