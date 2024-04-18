package com.example.Haratres.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Data
public class UserRequest {
    private String userName;
    private String password;

}
