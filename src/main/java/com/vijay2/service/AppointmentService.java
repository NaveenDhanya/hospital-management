package com.vijay2.service;

import com.vijay2.model.Appointment;

import java.util.List;

public interface AppointmentService {
    void saveAppointment(Appointment appointment);
    List<Appointment> getAllAppointments();

}

