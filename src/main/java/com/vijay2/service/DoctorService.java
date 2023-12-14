package com.vijay2.service;
import com.vijay2.model.Doctor;


public interface DoctorService {
    void saveDoctor(Doctor doctor);

    Doctor findByUsername(String username);
}
