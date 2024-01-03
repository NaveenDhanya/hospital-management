package com.vijay2.controller;

import com.vijay2.model.Appointment;
import com.vijay2.model.User;
import com.vijay2.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Controller
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/appointmentbooking")
    public String appointmentbooking() {
        return "appointment_booking.html";
    }

    @GetMapping("/appointmentstatus")
    public String appointmentstatus() {
        return "appointments_list.html";
    }

    @PostMapping("/saveappointments")
    public String saveappointments(@RequestParam("username") String username,
                         @RequestParam("phonenumber") String phonenumber,
                         @RequestParam("email") String email,
                         @RequestParam("specialization") String specialization,
                         @RequestParam("appointmentdate") String appointmentdate,
                         @RequestParam("appointmenttime") String appointmenttime,
                         @RequestParam("symptoms") String symptoms,
                         Model model) {
        // Check if username or email already exists in the database using UserService
        if (appointmentService.isUsernameExists(username)) {
            model.addAttribute("error", "Username already exists");
            return "error_signup"; // Redirect back to signup page with an error message
        }
        if (appointmentService.isEmailExists(email)) {
            model.addAttribute("error", "Email already exists");
            return "error_signup"; // Redirect back to signup page with an error message
        }
        // If username and email are unique, create a new user using UserService
        appointmentService.createAppointment(username, phonenumber, email, specialization, appointmentdate, appointmenttime, symptoms);
        return "redirect:/success";
    }

    @GetMapping("/success")
    public String success() {
        return "success.html";
    }

/*    @PostMapping("/confirmAppointment")
    public String confirmAppointment(@ModelAttribute Appointment appointment) {
        appointmentService.saveAppointment(appointment);
        return "redirect:/signup-success.html"; // Redirect to the confirmation page
    }
    //below config is to get the dropdown
    @GetMapping("/doctors")
    public ResponseEntity<List<String>> getAllDoctornames() {
        List<String> doctornames = appointmentService.getAllDoctornames();
        return ResponseEntity.ok(doctornames);
    }
    @GetMapping("doctorappointmentdetails")
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        List<Appointment> appointments = appointmentService.getAllAppointments();
        System.out.println("Number of Appointments Fetched: " + appointments.size());
        return ResponseEntity.ok(appointments);
    }*/

}