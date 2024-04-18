package com.example.Haratres.service.imp;

import com.example.Haratres.model.User;
import com.example.Haratres.repository.UserRepository;
import com.example.Haratres.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User createAdminUser(User user) {
        user.setRoles("ADMIN");
        return userRepository.save(user);
    }
}
