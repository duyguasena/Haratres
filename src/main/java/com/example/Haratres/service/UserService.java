package com.example.Haratres.service;


import com.example.Haratres.dto.LoginDTO;
import com.example.Haratres.dto.UserDTO;
import com.example.Haratres.response.LoginResponse;

public interface UserService {
    String addUser(UserDTO userDTO);
    LoginResponse loginUser(LoginDTO loginDTO);
}
