package com.vijay2.service;
import com.vijay2.model.Admin;
import com.vijay2.model.Doctor;
import com.vijay2.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

 //   public boolean isDoctornameExists(String doctorname) {
//        return doctorRepository.existsByDoctorname(doctorname);
 //   }
    @Override
    public boolean isEmailExists(String email) {
        return doctorRepository.existsByEmail(email);
    }
    @Override
    public boolean isPhonenumberExists(String phonenumber) {
        return doctorRepository.existsByPhonenumber(phonenumber);
    }
    @Override
    public void createDoctor(String doctorname, String email, String password, String phonenumber, String specialization) {
        Doctor newDoctor = new Doctor();
        newDoctor.setDoctorname(doctorname);
        newDoctor.setEmail(email);
        newDoctor.setPassword(password);
        newDoctor.setPhonenumber(phonenumber);
        newDoctor.setSpecialization(specialization);
        doctorRepository.save(newDoctor);
    }
    @Override
    public Doctor findByEmail(String email) {
        return doctorRepository.findByEmail(email);
    }
}