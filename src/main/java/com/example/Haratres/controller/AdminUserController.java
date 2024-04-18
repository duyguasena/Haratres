package com.example.Haratres.controller;

import com.example.Haratres.model.User;
import com.example.Haratres.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/users")
public class AdminUserController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/add")
    public ResponseEntity<User> addAdminUser(@RequestBody User user) {
        User newAdminUser = adminService.createAdminUser(user);
        return ResponseEntity.ok(newAdminUser);
    }
}
