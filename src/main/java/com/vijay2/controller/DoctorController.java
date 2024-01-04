package com.vijay2.controller;
import com.vijay2.model.Doctor;
import com.vijay2.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping("/adddoctordetailsverify")
    public String adddoctordetailsverify(@RequestParam("doctorname") String doctorname,
                                         @RequestParam("email") String email,
                                         @RequestParam("password") String password,
                                         @RequestParam("phonenumber") String phonenumber,
                                         @RequestParam("specialization") String specialization,
                                         Model model) {
        // Check if username or email already exists in the database using UserService
        if (doctorService.isDoctornameExists(doctorname)) {
            model.addAttribute("error", "Doctorname already exists");
            return "error_signup"; // Redirect back to signup page with an error message
        }
        if (doctorService.isEmailExists(email)) {
            model.addAttribute("error", "Email already exists");
            return "error_signup"; // Redirect back to signup page with an error message
        }
        // If username and email are unique, create a new user using UserService
        doctorService.createDoctor(doctorname, email, password, phonenumber, specialization);
        return "redirect:/success";
    }
    @GetMapping("/doctor_login")
    public String doctorlogin() {
        return "doctor_login.html";
    }
}