package com.example.Haratres.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
public class RegisterRequest {
    private String userName;
    private String password;
    @Email(regexp ="^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}" ,message="Email is not in given pattern")
    private String email;
    @Pattern(regexp="[0]\\d{3}\\d{3}\\d{2}\\d{2}", message="Geçerli bir telefon numarası giriniz")
    private String phoneNumber;
    @NotBlank
    private String gender;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date birthday;
}
