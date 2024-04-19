package com.example.Haratres.service;

import com.example.Haratres.dto.AddressRequest;
import com.example.Haratres.dto.AddressResponse;
import com.example.Haratres.model.Address;

public interface AddressService {
    AddressResponse addAddress(AddressRequest addressRequest);

    void deleteProductById(Long id);

    Address updateAddress(Long id, AddressRequest addressRequest);
}
