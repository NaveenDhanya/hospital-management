package com.vijay2.repository;

import com.vijay2.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
  //  boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsByPhonenumber(Long phonenumber);
//    @Query("SELECT DISTINCT a.doctorname FROM Appointment a")
//    List<String> getAllDoctornames();


}