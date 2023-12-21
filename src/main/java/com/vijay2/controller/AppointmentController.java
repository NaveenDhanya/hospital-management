package com.vijay2.controller;

import com.vijay2.model.Appointment;
import com.vijay2.model.User;
import com.vijay2.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    }

/*    @GetMapping("doctorappointmentdetails")
    public List<Appointment> getAllAppointments() {
        List<Appointment> appointments = appointmentService.getAllAppointments();
        System.out.println("Number of Appointments Fetched: " + appointments.size());
        return appointments;
    } */
}