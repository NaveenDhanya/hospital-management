package com.vijay2.controller;
import com.vijay2.model.Admin;
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
        /*if (doctorname.isEmpty() || email.isEmpty() || password.isEmpty() || phonenumber.isEmpty() || specialization.isEmpty()) {
            model.addAttribute("error", "Please fill in all fields");
            return "error_doctor_details"; // Redirect back to the error page with an error message
        } */
        // Check if username or email already exists in the database using UserService
 //       if (doctorService.isDoctornameExists(doctorname)) {
 //           model.addAttribute("error", "Doctorname already exists");
 //           return "error_signup"; // Redirect back to signup page with an error message
 //       }
        if (doctorService.isEmailExists(email)) {
            model.addAttribute("error", "Email already exists");
            return "error_doctor_details"; // Redirect back to signup page with an error message
        }
        if (doctorService.isPhonenumberExists(phonenumber)) {
            model.addAttribute("error", "Phonenumber already exists");
            return "error_doctor_details"; // Redirect back to signup page with an error message
        }
        // If username and email are unique, create a new user using UserService
        doctorService.createDoctor(doctorname, email, password, phonenumber, specialization);
        return "redirect:/success_doctor";
    }
    @PostMapping("/doctorverify")
    public String login(@RequestParam String email, @RequestParam String password) {
        // Find the user by username
        Doctor doctor = doctorService.findByEmail(email);

        if (doctor != null && doctor.getPassword().equals(password)) {
            return "redirect:/doctordashboard";
        } else {

            return "redirect:/doctor_error_login";
        }
    }
    @GetMapping("/doctor_error_login")
    public String doctor_error_login() {
        return "doctor_error_login.html";
    }
    @GetMapping("/success_doctor")
    public String success_doctor() {
        return "success_doctor.html";
    }
    @GetMapping("/homepage")
    public String homepage() {
        return "main_dashboard.html";
    }
    @GetMapping("/doctordashboard")
    public String doctordashboard() {
        return "doctor_dashboard.html";
    }
    @GetMapping("/doctor_login")
    public String doctorlogin() {
        return "doctor_login.html";
    }
}