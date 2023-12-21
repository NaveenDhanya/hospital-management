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
    @PostMapping("/doctordetailsentry")
    public String confirmDoctor(@ModelAttribute Doctor doctor) {
        doctorService.saveDoctor(doctor);
        return "redirect:/signup-success.html"; // Redirect to the confirmation page
    }

    @PostMapping("/doctorlogin")

    public String login(@RequestParam String email, @RequestParam String password) {
        // Find the user by username
        Doctor doctor = doctorService.findByEmail(email);

        if (doctor != null && doctor.getPassword().equals(password)) {
            return "redirect:/doctordashboard.html";
        } else {

            return "redirect:/adminlogin?error";
        }
    }

    @GetMapping("/getDesiredColumnValues")
    public String getDesiredColumnValues(Model model) {
        List<String> desiredColumnValues = doctorService.getDistinctColumnName();
        model.addAttribute("desiredColumnValues", desiredColumnValues);
        return "booking.html"; // Return the HTML page with the dropdown

    }
}