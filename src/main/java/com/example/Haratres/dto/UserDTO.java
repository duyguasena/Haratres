package com.example.Haratres.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String userName;
    private String email;
    private String password;
}
