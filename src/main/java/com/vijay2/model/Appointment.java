package com.vijay2.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}
    private String email;
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    private Long phonenumber;
    public Long getPhonenumber() {return phonenumber;}
    public void setPhonenumber(Long phonenumber) {this.phonenumber = phonenumber;}
    private String specialization;
    public String getSpecialization() {return specialization;}
    public void setSpecialization(String specialization) {this.specialization = specialization;}

    private LocalDate appointmentdate; // Use LocalDate for storing date
    public LocalDate getAppointmentdate() { return appointmentdate; }
    public void setAppointmentdate(LocalDate appointmentdate) { this.appointmentdate = appointmentdate; }

    private LocalTime appointmenttime; // Use LocalTime for storing time
    public LocalTime getAppointmenttime() { return appointmenttime; }
    public void setAppointmenttime(LocalTime appointmenttime) { this.appointmenttime = appointmenttime; }

  /*  private String appointmentdate;
    public String getAppointmentdate() {return appointmentdate;}
    public void setAppointmentdate(String appointmentdate) {this.appointmentdate = appointmentdate;}
    private String appointmenttime;
    public String getAppointmenttime() {return appointmenttime;}
    public void setAppointmenttime(String appointmenttime) {this.appointmenttime = appointmenttime;} */
    private String symptoms;
    public String getSymptoms() {return symptoms;}
    public void setSymptoms(String symptoms) {this.symptoms = symptoms;}
}
