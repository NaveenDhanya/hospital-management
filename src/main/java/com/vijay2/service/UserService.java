package com.vijay2.service;

import com.vijay2.model.Appointment;
import com.vijay2.model.User;

import java.util.List;

public interface UserService {

    boolean isUsernameExists(String username);
    boolean isEmailExists(String email);
    void createUser(String username, String email, String password);
    User findByUsername(String username);

}
