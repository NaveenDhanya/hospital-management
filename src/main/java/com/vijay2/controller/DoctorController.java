package com.vijay2.controller;

import com.vijay2.model.Doctor;
import com.vijay2.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping("/doctordetailsentry")
    public String confirmDoctor(@ModelAttribute Doctor doctor) {
        doctorService.saveDoctor(doctor);
        return "redirect:/signup-success.html"; // Redirect to the confirmation page
    }
   @GetMapping("/doctorlogin")
    public String showLoginForm() {
        return "login"; // Return the login form view
    }
    @PostMapping("/doctorlogin")
    public String login(@RequestParam String username, @RequestParam String password) {
        // Find the user by username
        Doctor doctor = doctorService.findByUsername(username);

        if (doctor != null && doctor.getPassword().equals(password)) {
            return "redirect:/admindashboard.html";
        } else {

            return "redirect:/adminlogin?error";
        }
    }

}