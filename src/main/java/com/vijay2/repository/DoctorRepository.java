package com.vijay2.repository;

import com.vijay2.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Doctor findByEmail(String email);

    @Query("SELECT DISTINCT d.doctorname FROM Doctor d")
    List<String> findDistinctColumnName();
}


