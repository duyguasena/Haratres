package com.example.Haratres.service;

import com.example.Haratres.dto.AddressRequest;
import com.example.Haratres.model.Address;

public interface AddressService {
    Address addAddress(AddressRequest addressRequest);
    void deleteAddressById(Long id);
    Address updateAddress(Long id, AddressRequest addressRequest);
    boolean existsById(Long id);
}
