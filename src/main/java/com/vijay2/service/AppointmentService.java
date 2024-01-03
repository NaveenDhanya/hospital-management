package com.vijay2.service;

import com.vijay2.model.Appointment;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface AppointmentService {

    boolean isUsernameExists(String username);
    boolean isEmailExists(String email);
    void createAppointment(String username, String email, String phonenumber, String specialization, String appointmentdate, String appointmenttime, String symptoms);
/*    void saveAppointment(Appointment appointment);
    List<String> getAllDoctornames();

    List<Appointment> getAllAppointments(); //to show the db table in html */

}

