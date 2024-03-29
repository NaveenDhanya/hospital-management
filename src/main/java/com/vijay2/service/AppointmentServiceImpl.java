package com.vijay2.service;
import com.vijay2.model.Appointment;
import com.vijay2.model.User;
import com.vijay2.repository.AppointmentRepository;
import com.vijay2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    @Autowired
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<Appointment> getAllAppointments() {return appointmentRepository.findAll();}

   // @Override
   // public boolean isUsernameExists(String username) {
    //    return appointmentRepository.existsByUsername(username);
    //}
    @Override
    public boolean isEmailExists(String email) {
        return appointmentRepository.existsByEmail(email);
    }
    @Override
    public boolean isPhonenumberExists(Long phonenumber) {
        return appointmentRepository.existsByPhonenumber(phonenumber);
    }
    @Override
    public void createAppointment(String username, String email, Long phonenumber, String specialization, LocalDate appointmentdate,LocalTime appointmenttime, String symptoms) {
        Appointment newAppointment = new Appointment();
        newAppointment.setUsername(username);
        newAppointment.setEmail(email);
        newAppointment.setPhonenumber(phonenumber);
        newAppointment.setSpecialization(specialization);
        newAppointment.setAppointmentdate(appointmentdate);
        newAppointment.setAppointmenttime(appointmenttime);
        newAppointment.setSymptoms(symptoms);
        appointmentRepository.save(newAppointment);
    }

}