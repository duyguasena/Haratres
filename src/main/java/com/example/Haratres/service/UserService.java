package com.example.Haratres.service;

import com.example.Haratres.model.User;

public interface UserService {
    User getOneUserByUserName(String userName);
    User saveOneUser(User user);

    boolean existsByUsername(String userName);

}
