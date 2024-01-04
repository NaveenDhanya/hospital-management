package com.vijay2.controller;

import com.vijay2.model.Appointment;
import com.vijay2.model.User;
import com.vijay2.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/getappointments")
    public ResponseEntity<List<Appointment>> getappointments() {
        // Get all appointments from the service
        List<Appointment> appointments = appointmentService.getAllAppointments();

        // Return the list of appointments with a 200 OK status
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    @PostMapping("/confirmappointment")
    public String confirmappointment(@RequestParam("username") String username,
						 @RequestParam("email") String email,
                         @RequestParam("phonenumber") String phonenumber,
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
        appointmentService.createAppointment(username, email, phonenumber, specialization, appointmentdate, appointmenttime, symptoms);
        return "redirect:/success";
    }
}
