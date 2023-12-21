package com.vijay2.service;
import com.vijay2.model.Appointment;
import com.vijay2.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    }
}