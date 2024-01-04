package com.vijay2.service;
import com.vijay2.model.Doctor;
import java.util.List;

public interface DoctorService {

    boolean isDoctornameExists(String doctorname);
    boolean isEmailExists(String email);
    void createDoctor(String doctorname, String email, String password, String phonenumber, String specialization);

}
