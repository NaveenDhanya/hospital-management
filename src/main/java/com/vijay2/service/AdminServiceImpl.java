package com.vijay2.service;

import com.vijay2.model.Admin;
import com.vijay2.repository.AdminRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    @Transactional
    public void saveAdmin(Admin admin) {
        adminRepository.save(admin);
    }
    @Override
    public Admin findByUsername(String username) {
        return adminRepository.findByUsername(username);
    }

}

