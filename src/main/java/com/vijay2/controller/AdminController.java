package com.vijay2.controller;

import com.vijay2.model.Admin;
import com.vijay2.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;
    @GetMapping("/admin_login")
    public String showLoginForm() {
        return "admin_login.html"; // Return the login form view
    }
    @GetMapping("/admin_error_login")
    public String admin_error_login() {
        return "admin_error_login.html";
    }
    @PostMapping("/adminloginverify")
    public String login(@RequestParam String username, @RequestParam String password) {
        // Find the user by username
        Admin admin = adminService.findByUsername(username);

        if (admin != null && admin.getPassword().equals(password)) {
            return "redirect:/admindashboard";
        } else {

            return "redirect:/admin_error_login";
        }
    }
    @GetMapping("/admindashboard")
    public String admindashboard() {
        return "admin_dashboard.html";
    }
    @GetMapping("/adddoctordetails")
    public String adddoctordetails() {
        return "adddoctordetails.html";
    }
    @GetMapping("/getappointmentdetails")
    public String getappointmentdetails() {
        return "appointments_list_admin.html";
    }

}
