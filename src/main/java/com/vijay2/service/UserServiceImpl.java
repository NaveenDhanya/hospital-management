package com.vijay2.service;

import com.vijay2.model.Appointment;
import com.vijay2.model.User;
import com.vijay2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public boolean isUsernameExists(String username) {
        return userRepository.existsByUsername(username);
    }
    @Override
    public boolean isEmailExists(String email) {
        return userRepository.existsByEmail(email);
    }
    @Override
    public void createUser(String username, String email, String password) {
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setPassword(password);
        userRepository.save(newUser);
    }
    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    /*    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    } */
}
