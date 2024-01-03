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
    public boolean isUsernameExists(String username) {
        return appointmentRepository.existsByUsername(username);
    }
    @Override
    public boolean isEmailExists(String email) {
        return appointmentRepository.existsByEmail(email);
    }
    @Override
    public void createAppointment(String username, String email, String phonenumber, String specialization, String appointmentdate,String appointmenttime, String symptoms) {
        Appointment newAppointment = new Appointment();
        newAppointment.setUsername(username);
        newAppointment.setEmail(email);
        newAppointment.setPhonenumber(phonenumber);
 //       newAppointment.setSpecialization(specialization);
        newAppointment.setAppointmentdate(appointmentdate);
        newAppointment.setAppointmenttime(appointmenttime);
        newAppointment.setSymptoms(symptoms);
        appointmentRepository.save(newAppointment);
    }

    /*    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }
    @Override
    @Transactional
    public void saveAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    //below config is to get the dropdown
    @Override
    public List<String> getAllDoctornames() {
        return appointmentRepository.findAll().stream()
                .map(Appointment::getDoctorname)
                .collect(Collectors.toList());
    }
    //below config is to show the db table in the doctor appointments
    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }*/
}