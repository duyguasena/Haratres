package com.example.Haratres.service.imp;

import com.example.Haratres.model.User;
import com.example.Haratres.repository.UserRepository;
import com.example.Haratres.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
}

