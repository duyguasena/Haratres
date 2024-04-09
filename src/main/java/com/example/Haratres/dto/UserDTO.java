package com.example.Haratres.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Data

public class UserDTO {
    private Long id;
    private String userName;
    private String email;
    private String password;

    public UserDTO( Long id,String userName, String email, String encode) {
        this.id =id;
        this.userName = userName;
        this.email = email;
        this.password = encode;
    }



}

