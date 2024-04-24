package com.example.Haratres.dto;

import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Data
public class RegisterRequest {
    private String userName;
    private String password;
    @Email(regexp ="^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}" ,message="Email is not in given pattern")
    private String email;
    @Pattern(regexp="[0]\\d{3}\\d{3}\\d{2}\\d{2}", message="Geçerli bir telefon numarası giriniz")
    private String phoneNumber;
}
