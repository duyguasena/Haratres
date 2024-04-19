package com.example.Haratres.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String userName;
    private String password;
    private String roles;

    @OneToMany(mappedBy = "users",cascade =CascadeType.MERGE,fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Address> addressList=new ArrayList<>();


}
