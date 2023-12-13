package com.vijay2.controller;

import com.vijay2.model.Appointment;
import com.vijay2.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

//    private final AppointmentService appointmentService;
//    // Constructor Injection
//    public AppointmentController(AppointmentService appointmentService) {
//        this.appointmentService = appointmentService;
//    }
//    @GetMapping("/bookappointment")
//    public String showLoginForm() {
//        return "booking.html"; // Return the login form view
//}

    @PostMapping("/confirmAppointment")
    public String confirmAppointment(@ModelAttribute Appointment appointment) {
        appointmentService.saveAppointment(appointment);
        return "redirect:/signup-success.html"; // Redirect to the confirmation page
    }

}