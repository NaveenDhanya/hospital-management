package com.vijay2.service;

import com.vijay2.model.Appointment;
import com.vijay2.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User findByUsername(String username);
    List<User> getAllUsers();
}
