package com.example.Haratres.controller;

import com.example.Haratres.dto.LoginDTO;
import com.example.Haratres.dto.UserDTO;
import com.example.Haratres.response.LoginResponse;
import com.example.Haratres.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    private  UserService userService;
    @PostMapping( "/save")
    public String saveUser(@RequestBody UserDTO userDTO){
        String id=userService.addUser(userDTO);
        return id;
    }
    @PostMapping( "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO){
        LoginResponse loginResponse=userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }
}
