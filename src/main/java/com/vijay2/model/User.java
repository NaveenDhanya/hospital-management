package com.vijay2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}
    private String email;
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    private String password;
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    // Constructors, getters, setters
}