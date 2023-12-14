package com.vijay2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String doctorname;
    public String getDoctorname() {return doctorname;}
    public void setDoctorname(String doctorname) {this.doctorname = doctorname;}

    private String phonenumber;
    public String getPhonenumber() {return phonenumber;}
    public void setPhonenumber(String phonenumber) {this.phonenumber = phonenumber;}

    private String email;
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    private String password;
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

  //  private String doctorid;
  //  public String getDoctorid() {return doctorid;}
  //  public void setDoctorid(String doctorid) {this.doctorid = doctorid;}

    private String specialization;
    public String getSpecialization() {return specialization;}
    public void setSpecialization(String specialization) {this.specialization = specialization;}

    // Constructors, getters, setters
}


