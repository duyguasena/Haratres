package com.example.Haratres.service;

import com.example.Haratres.dto.RegisterRequest;
import com.example.Haratres.dto.UserDTO;

public interface AuthService {
    UserDTO createUser(RegisterRequest registerRequest);
}
