package com.example.Haratres.service.imp;

import com.example.Haratres.model.User;
import com.example.Haratres.repository.UserRepository;
import com.example.Haratres.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
@Service
public class UserImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User getOneUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
    @Override
    public User saveOneUser(User newUser) {
        return userRepository.save(newUser);
    }

    @Override
    public boolean existsByUsername(String userName) {
        return userRepository.existsByUserName(userName);
    }

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        return (User) userRepository.findByUserName(userName);
    }
    }



