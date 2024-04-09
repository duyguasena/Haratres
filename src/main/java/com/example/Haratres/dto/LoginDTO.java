package com.example.Haratres.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Data
@Getter
@Setter
public class LoginDTO {
    private String email;
    private String password;
}
