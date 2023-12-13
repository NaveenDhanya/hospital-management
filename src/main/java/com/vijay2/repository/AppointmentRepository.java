package com.vijay2.repository;

import com.vijay2.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    // Define custom queries or methods if needed
}