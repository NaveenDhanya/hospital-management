package com.vijay2.service;

import com.vijay2.model.Doctor;
import com.vijay2.repository.DoctorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }
    @Override
    @Transactional
    public void saveDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }
   @Override
    public Doctor findByUsername(String username) {
        return doctorRepository.findByUsername(username);
    }

}