package com.vijay2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}
    private String password;
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    // Constructors, getters, setters
}


