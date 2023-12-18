package com.vijay2.service;
import com.vijay2.model.Doctor;
import java.util.List;

public interface DoctorService {
    void saveDoctor(Doctor doctor);
    Doctor findByEmail(String email);

    List<String> getDistinctColumnName();
}
