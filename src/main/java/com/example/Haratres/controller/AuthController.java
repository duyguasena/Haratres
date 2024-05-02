package com.example.Haratres.controller;

import com.example.Haratres.dto.LoginRequest;
import com.example.Haratres.dto.RegisterRequest;
import com.example.Haratres.model.User;
import com.example.Haratres.security.JwtTokenProvider;
import com.example.Haratres.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserService userService, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword());
        Authentication auth = authenticationManager.authenticate(authToken);
        SecurityContextHolder.getContext().setAuthentication(auth);
        String jwtToken = jwtTokenProvider.generateJwtToken(auth);
        return jwtToken;
    }
//    @PostMapping("/register")
//    public ResponseEntity<String> register(@Valid @RequestBody RegisterRequest registerRequest) {
//        if (userService.existsByUsername(registerRequest.getUserName())) {
//            return new ResponseEntity<>("User is already registered!", HttpStatus.BAD_REQUEST);
//        }
//        User user = new User();
//        user.setUserName(registerRequest.getUserName());
//        user.setEmail(registerRequest.getEmail());
//        user.setPhoneNumber(registerRequest.getPhoneNumber());
//        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
//        user.setGender(registerRequest.getGender());
//        user.setBirthday(registerRequest.getBirthday());
//        user.setRoles("CUSTOMER");
//        userService.saveOneUser(user);
//        return new ResponseEntity<>("User succesfully registered", HttpStatus.CREATED);
//
//    }
@PostMapping("/register")
public ResponseEntity<String> register(@Valid @RequestBody RegisterRequest registerRequest, Errors errors) {
    if (errors.hasErrors()) {
        throw new IllegalArgumentException(errors.getAllErrors().toString());
    }
    try {
        if (userService.existsByUsername(registerRequest.getUserName())) {
            return ResponseEntity.badRequest().body("User is already registered!");
        }
        User user = new User();
        user.setUserName(registerRequest.getUserName());
        user.setEmail(registerRequest.getEmail());
        user.setPhoneNumber(registerRequest.getPhoneNumber());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setGender(registerRequest.getGender());
        user.setBirthday(registerRequest.getBirthday());
        user.setRoles("CUSTOMER");
        userService.saveOneUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User successfully registered");
    } catch (Exception e) {
        logger.error("Error registering user: {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error registering user");
    }
}

}
