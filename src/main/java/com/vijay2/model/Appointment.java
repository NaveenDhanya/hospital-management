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
    private String phonenumber;
    public String getPhonenumber() {return phonenumber;}
    public void setPhonenumber(String phonenumber) {this.phonenumber = phonenumber;}
    private String email;
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    private String doctorid;
    public String getDoctorid() {return doctorid;}
    public void setDoctorid(String doctorid) {this.doctorid = doctorid;}
    private String doctorname;
    public String getDoctorname() {return doctorname;}
    public void setDoctorname(String doctorname) {this.doctorname = doctorname;}
    private String appointmentdate;
    public String getAppointmentdate() {return appointmentdate;}
    public void setAppointmentdate(String appointmentdate) {this.appointmentdate = appointmentdate;}
    private String appointmenttime;
    public String getAppointmenttime() {return appointmenttime;}
    public void setAppointmenttime(String appointmenttime) {this.appointmenttime = appointmenttime;}
    private String symptoms;
    public String getSymptoms() {return symptoms;}
    public void setSymptoms(String symptoms) {this.symptoms = symptoms;}
}
