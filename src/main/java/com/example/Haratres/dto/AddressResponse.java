package com.example.Haratres.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressResponse {
    private String street;
    private String city;
    private String postalCode;
}
