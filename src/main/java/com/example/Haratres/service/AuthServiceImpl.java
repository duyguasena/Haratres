package com.example.Haratres.service;


import com.example.Haratres.dto.RegisterRequest;
import com.example.Haratres.dto.UserDTO;
import com.example.Haratres.model.User;
import com.example.Haratres.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements  AuthService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO createUser(RegisterRequest registerRequest) {
        User user =new User();
        user.setEmail(registerRequest.getEmail());
        user.setUserName(registerRequest.getUserName());
        user.setPassword(new BCryptPasswordEncoder().encode(registerRequest.getPassword()));
        User createdUser=userRepository.save(user);
        UserDTO userDTO=new UserDTO();
        userDTO.setEmail(createdUser.getEmail());
        userDTO.setUserName(createdUser.getUserName());
        userDTO.setPassword(createdUser.getPassword());
        return userDTO;
    }
}
