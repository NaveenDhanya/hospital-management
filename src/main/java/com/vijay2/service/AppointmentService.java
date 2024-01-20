package com.vijay2.service;

import com.vijay2.model.Appointment;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.atomic.LongAccumulator;

public interface AppointmentService {
    List<Appointment> getAllAppointments();

 //   boolean isUsernameExists(String username);
    boolean isEmailExists(String email);
    boolean isPhonenumberExists(Long phonenumber);
    void createAppointment(String username, String email, Long phonenumber, String specialization, LocalDate appointmentdate, LocalTime appointmenttime, String symptoms);

}

