package com.vijay2.service;

import com.vijay2.model.Admin;


public interface AdminService {
    void saveAdmin(Admin admin);

    Admin findByUsername(String username);
}
