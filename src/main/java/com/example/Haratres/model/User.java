package com.example.Haratres.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private String userName;
    private String password;
    private String roles;
    private String email;
    private String phoneNumber;

    @OneToMany(mappedBy ="user")
    @JsonManagedReference
    private List<Address> addressList;




}
