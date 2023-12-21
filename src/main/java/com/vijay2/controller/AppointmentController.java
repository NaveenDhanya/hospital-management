package com.vijay2.controller;

import com.vijay2.model.Appointment;
import com.vijay2.model.User;
import com.vijay2.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/confirmAppointment")
    public String confirmAppointment(@ModelAttribute Appointment appointment) {
        appointmentService.saveAppointment(appointment);
        return "redirect:/signup-success.html"; // Redirect to the confirmation page
    }

/*    @GetMapping("/doctors")
    public List<String> getAllDoctornames() {
        return appointmentService.getAllDoctornames();
    } */
    @GetMapping("/doctors")
    public ResponseEntity<List<String>> getAllDoctornames() {
        List<String> doctornames = appointmentService.getAllDoctornames();
        return ResponseEntity.ok(doctornames);
    }
}