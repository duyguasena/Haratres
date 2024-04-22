package com.example.Haratres.dto;

import lombok.Data;

@Data
public class AddressRequest {
    private String city;
    private String street;
    private String addressDetail;
    private String postalCode;
}
