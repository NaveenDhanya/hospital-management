package com.vijay2.service;

import com.vijay2.model.User;

public interface UserService {
    User saveUser(User user);
    User findByUsername(String username);
}
