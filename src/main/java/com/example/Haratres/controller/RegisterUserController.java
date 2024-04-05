package com.example.Haratres.controller;

import com.example.Haratres.dto.RegisterRequest;
import com.example.Haratres.dto.UserDTO;
import com.example.Haratres.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterUserController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody RegisterRequest registerRequest){
        UserDTO createdUser=authService.createUser(registerRequest);
        if (createdUser==null)
            return new ResponseEntity<>("User is not created", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
    }
}
